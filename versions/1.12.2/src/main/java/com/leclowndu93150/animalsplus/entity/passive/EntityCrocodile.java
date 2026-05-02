package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityCrocodile extends EntitySmallAnimal {
    public EntityCrocodile(World world) {
        super(world);
        setSize(1.4f, 1.0f);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAIAttackMelee(this, 1.5, true));
        tasks.addTask(1, new EntityAIWander(this, 1.0));
        tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(3, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (isInWater()) {
            if (motionY < 0.0) motionY = 0.0;
            motionY += 0.002;
            if (collidedHorizontally) motionY += 0.08;
        }
    }

    @Override
    public void travel(float strafe, float vertical, float forward) {
        if (isServerWorld() && isInWater()) {
            moveRelative(strafe, vertical, forward, 0.1f);
            move(MoverType.SELF, motionX, motionY, motionZ);
            motionX *= 0.9;
            motionY *= 0.9;
            motionZ *= 0.9;
        } else {
            super.travel(strafe, vertical, forward);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        playSound(ModSounds.entity_crocodile_attack, 1.0f, 1.0f);
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }

    @Override protected SoundEvent getAmbientSound() { return ModSounds.entity_crocodile_ambient; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return ModSounds.entity_crocodile_hurt; }
    @Override protected SoundEvent getDeathSound() { return ModSounds.entity_crocodile_death; }
    @Override public int getVerticalFaceSpeed() { return 180; }
}
