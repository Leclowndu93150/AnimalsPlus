package com.leclowndu93150.animalsplus.entity.water;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntitySwimming extends EntityWaterMob {
    private double swimTargetX, swimTargetY, swimTargetZ;
    private Entity targetEntity;
    private boolean isAttacking;
    protected float swimRange = 4.0f;
    protected float swimRangeHeight = 4.0f;
    protected boolean isAggressive = false;
    protected int attackInterval = 50;
    protected float attackSpeed = 1.2f;
    protected float swimSpeed = 0.5f;
    protected boolean jumpOutOfWater = true;

    public EntitySwimming(World world) {
        super(world);
    }

    @Override
    protected boolean canTriggerWalking() { return false; }

    public boolean isInWater() {
        double d0 = posY + height + 0.2;
        IBlockState state = world.getBlockState(new BlockPos(posX, d0, posZ));
        return state.getMaterial() == Material.WATER;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        if (isInWater()) {
            double dx = swimTargetX - posX;
            double dy = swimTargetY - posY;
            double dz = swimTargetZ - posZ;
            double dist = MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
            if (dist < 1.0 || dist > 1000.0 || rand.nextInt(100) == 0) {
                swimTargetX = posX + (rand.nextFloat() * 2.0f - 1.0f) * swimRange;
                swimTargetY = posY + (rand.nextFloat() * 2.0f - 1.0f) * swimRangeHeight;
                swimTargetZ = posZ + (rand.nextFloat() * 2.0f - 1.0f) * swimRange;
                isAttacking = false;
            }
            IBlockState targetState = world.getBlockState(new BlockPos(swimTargetX, swimTargetY, swimTargetZ));
            if (targetState.getMaterial() == Material.WATER) {
                motionX += dx / dist * 0.05 * swimSpeed;
                motionY += dy / dist * 0.2 * swimSpeed;
                motionZ += dz / dist * 0.05 * swimSpeed;
            } else {
                swimTargetX = posX;
                swimTargetY = posY + 0.2;
                swimTargetZ = posZ;
            }
            if (isAttacking) {
                motionX *= attackSpeed;
                motionY *= attackSpeed;
                motionZ *= attackSpeed;
            }
            if (isAggressive) {
                if (targetEntity != null && targetEntity.isEntityAlive()) {
                    swimTargetX = targetEntity.posX;
                    swimTargetY = targetEntity.posY + 0.4;
                    swimTargetZ = targetEntity.posZ;
                    isAttacking = true;
                } else if (rand.nextInt(attackInterval) == 0) {
                    targetEntity = findEntityToAttack();
                    if (targetEntity != null) {
                        swimTargetX = targetEntity.posX;
                        swimTargetY = targetEntity.posY + 0.4;
                        swimTargetZ = targetEntity.posZ;
                        isAttacking = true;
                    }
                }
            }
            float f = (float) (Math.atan2(motionZ, motionX) * 180.0 / Math.PI) - 90.0f;
            rotationYaw += MathHelper.wrapDegrees(f - rotationYaw);
            float f1 = MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
            rotationPitch = (float) Math.atan2(motionY, f1) * 180.0f / (float) Math.PI * 2.0f;
        } else if (jumpOutOfWater && onGround && rand.nextInt(30) == 0) {
            motionY = 0.3f;
            motionX = -0.2f + rand.nextFloat() * 0.4f;
            motionZ = -0.2f + rand.nextFloat() * 0.4f;
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        boolean result = super.attackEntityFrom(source, amount);
        if (result && isAggressive && source.getTrueSource() instanceof EntityLivingBase) {
            targetEntity = source.getTrueSource();
            swimTargetX = targetEntity.posX;
            swimTargetY = targetEntity.posY + 0.4;
            swimTargetZ = targetEntity.posZ;
            isAttacking = true;
        }
        return result;
    }

    protected Entity findEntityToAttack() {
        EntityPlayer player = world.getClosestPlayerToEntity(this, 16.0);
        return player != null && canEntityBeSeen(player) ? player : null;
    }

    @Override
    public void applyEntityCollision(Entity entity) {
        super.applyEntityCollision(entity);
        if (isAggressive && entity instanceof EntityLivingBase)
            attackEntityAsMob(entity);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (isAggressive) {
            float f = (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
            return entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        }
        return super.attackEntityAsMob(entity);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
    }
}
