package com.leclowndu93150.animalsplus.entity.water;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPiranha extends EntitySwimming {
    public EntityPiranha(World world) {
        super(world);
        setSize(0.4f, 0.4f);
        isAggressive = true;
        swimSpeed = 0.8f;
        attackSpeed = 1.1f;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0);
    }

    @Override
    public void onUpdate() {
        if (!world.isRemote && world.getDifficulty() == EnumDifficulty.PEACEFUL) setDead();
        super.onUpdate();
    }

    @Override
    protected Entity findEntityToAttack() {
        AxisAlignedBB area = getEntityBoundingBox().expand(16.0, 6.0, 16.0);
        Entity fish = world.findNearestEntityWithinAABB(EntityFish.class, area, this);
        if (fish != null) return fish;
        return world.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    public boolean getCanSpawnHere() {
        return world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
    }
}
