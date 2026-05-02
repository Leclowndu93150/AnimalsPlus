package com.leclowndu93150.animalsplus.entity.ambient;

import com.leclowndu93150.animalsplus.init.ModItems;
import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityCricket extends EntityInsect {
    private int lastChirpTime;
    private float cricketPitch;

    public EntityCricket(World world) {
        super(world);
        setSize(0.5f, 0.3f);
        moveHelper = new CricketMoveHelper();
        cricketPitch = 0.2f * (rand.nextFloat() - rand.nextFloat());
    }

    @Override
    protected void initEntityAI() {
        tasks.addTask(0, new EntityAIAvoidEntity<>(this, EntityPlayer.class, 4.0f, 1.0, 1.5));
        tasks.addTask(1, new EntityAIWander(this, 1.0));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (onGround && ++lastChirpTime >= 15) {
            lastChirpTime = 0;
            playSound(ModSounds.entity_cricket_chirp, 0.1f, 1.0f + cricketPitch);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setFloat("Chirp", cricketPitch);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        if (tag.hasKey("Chirp")) cricketPitch = tag.getFloat("Chirp");
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        if (rand.nextInt(3) != 0) dropItem(ModItems.cricket_leg, 1);
    }

    @Override
    protected void updateFallState(double y, boolean onGround, IBlockState state, BlockPos pos) {
        if (onGround && fallDistance > 0.0f) {
            if (!isInWater()) handleWaterMovement();
            fallDistance = 0.0f;
        } else {
            super.updateFallState(y, onGround, state, pos);
        }
    }

    class CricketMoveHelper extends EntityMoveHelper {
        private int jumpDelay;

        public CricketMoveHelper() {
            super(EntityCricket.this);
        }

        @Override
        public void onUpdateMoveHelper() {
            if (EntityCricket.this.onGround && isUpdating() && --jumpDelay <= 0) {
                jumpDelay = 2;
                EntityCricket.this.getJumpHelper().setJumping();
            }
            super.onUpdateMoveHelper();
        }
    }
}
