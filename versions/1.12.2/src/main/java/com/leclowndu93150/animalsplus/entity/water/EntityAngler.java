package com.leclowndu93150.animalsplus.entity.water;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityAngler extends EntitySwimming {
    public EntityAngler(World world) {
        super(world);
        setSize(0.5f, 0.4f);
        isAggressive = true;
        swimRange = 8.0f;
        swimRangeHeight = 2.0f;
        swimSpeed = 0.7f;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0);
    }

    @Override
    public void onUpdate() {
        if (!world.isRemote && world.getDifficulty() == EnumDifficulty.PEACEFUL) setDead();
        super.onUpdate();
    }

    @Override
    protected Entity findEntityToAttack() {
        AxisAlignedBB area = getEntityBoundingBox().expand(16.0, 6.0, 16.0);
        return world.findNearestEntityWithinAABB(EntityFish.class, area, this);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    protected void dropFewItems(boolean flag, int looting) {
        int j = rand.nextInt(3) + rand.nextInt(1 + looting);
        for (int k = 0; k < j; k++) dropItem(Items.GLOWSTONE_DUST, 1);
    }

    private boolean isValidLightLevel() {
        BlockPos pos = new BlockPos(posX, getEntityBoundingBox().minY, posZ);
        return world.getLightFromNeighbors(pos) <= 4;
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.getDifficulty() != EnumDifficulty.PEACEFUL && isValidLightLevel() && super.getCanSpawnHere();
    }
}
