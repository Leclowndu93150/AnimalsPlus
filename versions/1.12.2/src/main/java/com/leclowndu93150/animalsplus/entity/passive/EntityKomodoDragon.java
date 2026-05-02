package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.init.MobEffects;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityKomodoDragon extends EntityTameable {
    private static final DataParameter<Byte> STATUS = EntityDataManager.createKey(EntityKomodoDragon.class, DataSerializers.BYTE);
    private int tongueVisibleCounter;

    public EntityKomodoDragon(World world) {
        super(world);
        setSize(1.4f, 0.6f);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAttackMelee(this, 1.0, true));
        tasks.addTask(2, new EntityAIWander(this, 1.0));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(4, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.18);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(STATUS, (byte) 0);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (tongueVisibleCounter > 0 && ++tongueVisibleCounter > 40) {
            tongueVisibleCounter = 0;
            setTongueVisible(false);
        }
    }

    @Override
    public boolean isPotionApplicable(PotionEffect potion) {
        return potion.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potion);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0f)) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 200, 0));
            return true;
        }
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        stickTongueOut();
        return ModSounds.entity_snake_ambient;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource src) {
        stickTongueOut();
        return ModSounds.entity_snake_ambient;
    }

    @Override protected SoundEvent getDeathSound() { return null; }

    private void stickTongueOut() {
        if (!world.isRemote) { tongueVisibleCounter = 1; setTongueVisible(true); }
    }

    public boolean isTongueVisible() { return (dataManager.get(STATUS) & 0x20) != 0; }

    private void setTongueVisible(boolean flag) {
        byte b0 = dataManager.get(STATUS);
        dataManager.set(STATUS, flag ? (byte) (b0 | 0x20) : (byte) (b0 & 0xDF));
    }

    @Override
    public EntityAgeable createChild(EntityAgeable other) { return null; }
}
