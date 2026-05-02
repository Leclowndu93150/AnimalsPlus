package com.leclowndu93150.animalsplus.entity.passive;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityMouse extends EntitySmallAnimal {
    public EntityMouse(World world) {
        super(world);
        setSize(0.4f, 0.2f);
        tasks.addTask(1, new EntityAIPanic(this, 1.4));
        tasks.addTask(2, new EntityAIWander(this, 1.0));
    }

    @Override protected float getSoundVolume() { return 0.1f; }
    @Override protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_BAT_AMBIENT; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return SoundEvents.ENTITY_BAT_HURT; }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_BAT_DEATH; }

    @Override
    public boolean getCanSpawnHere() {
        return rand.nextInt(5) == 0 && super.getCanSpawnHere();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
    }
}
