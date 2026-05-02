package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrab extends EntitySmallAnimal {
    public EntityCrab(World world) {
        super(world);
        setSize(0.4f, 0.3f);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAIPanic(this, 1.0));
        tasks.addTask(1, new EntityAIWander(this, 1.0));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.34);
    }

    @Override
    public void travel(float strafe, float vertical, float forward) {
        if (isServerWorld() && isInWater()) {
            moveRelative(strafe, vertical, forward, 0.1f);
            move(net.minecraft.entity.MoverType.SELF, motionX, motionY, motionZ);
            motionX *= 0.9;
            motionY *= 0.9;
            motionZ *= 0.9;
            motionY -= 0.05;
        } else {
            super.travel(strafe, vertical, forward);
        }
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return SoundEvents.ENTITY_SKELETON_HURT; }
    @Override protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_SKELETON_DEATH; }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        int i = rand.nextInt(2);
        for (int j = 0; j < i; j++) dropItem(ModItems.crab_leg, 1);
    }

    @Override public boolean canBreatheUnderwater() { return true; }
    @Override public boolean isPushedByWater() { return false; }
    @Override public boolean getCanSpawnHere() { return true; }
}
