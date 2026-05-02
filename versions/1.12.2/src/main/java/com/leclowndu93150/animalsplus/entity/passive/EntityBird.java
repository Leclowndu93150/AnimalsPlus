package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityBird extends EntityBirdBase {
    private static final DataParameter<Byte> BIRD_TYPE = EntityDataManager.createKey(EntityBird.class, DataSerializers.BYTE);
    public float wingRotation;
    public float prevWingRotation;
    public float flapSpeed;
    public float prevFlapSpeed;
    public float timeInAir = 1.0f;

    public EntityBird(World world) {
        super(world);
        setSize(0.4f, 0.6f);
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIAvoidEntity<>(this, EntityOcelot.class, 8.0f, 1.0, 1.4));
        tasks.addTask(2, new EntityAIAvoidEntity<>(this, EntityPlayer.class, 8.0f, 1.0, 1.4));
        tasks.addTask(3, new EntityAIWander(this, 1.0));
        tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 4.0f));
        tasks.addTask(5, new EntityAILookIdle(this));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(BIRD_TYPE, (byte) 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        prevWingRotation = wingRotation;
        prevFlapSpeed = flapSpeed;
        flapSpeed += onGround ? -1.0f : 1.2f;
        if (flapSpeed < 0.0f) flapSpeed = 0.0f;
        if (flapSpeed > 1.0f) flapSpeed = 1.0f;
        if (!onGround && timeInAir < 1.0f) timeInAir = 1.0f;
        timeInAir *= 0.9f;
        if (isFlying()) {
            motionY *= 0.1;
        } else if (!onGround && motionY < 0.0) {
            motionY *= 0.6;
        }
        wingRotation += timeInAir * 2.0f;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {}

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("Type", getBirdType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setBirdType(tag.getInteger("Type"));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        switch (getBirdType()) {
            case 1: return ModSounds.entity_bird_cardinal_ambient;
            case 2: return ModSounds.entity_bird_sparrow_ambient;
            case 3: return ModSounds.entity_bird_parrot_ambient;
            case 4: return ModSounds.entity_bird_chickadee_ambient;
            case 5: return ModSounds.entity_bird_crow_ambient;
            default: return ModSounds.entity_bird_jay_ambient;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource src) {
        switch (getBirdType()) {
            case 1: return ModSounds.entity_bird_cardinal_hurt;
            case 2: return ModSounds.entity_bird_sparrow_hurt;
            case 3: return ModSounds.entity_bird_parrot_hurt;
            case 4: return ModSounds.entity_bird_chickadee_hurt;
            case 5: return ModSounds.entity_bird_crow_hurt;
            default: return ModSounds.entity_bird_jay_hurt;
        }
    }

    @Override
    protected SoundEvent getDeathSound() {
        switch (getBirdType()) {
            case 1: return ModSounds.entity_bird_cardinal_death;
            case 5: return ModSounds.entity_bird_crow_death;
            default: return null;
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }

    public int getBirdType() { return dataManager.get(BIRD_TYPE); }
    public void setBirdType(int i) { dataManager.set(BIRD_TYPE, (byte) i); }

    @Override
    public boolean isOnLadder() { return isFlying() ? false : super.isOnLadder(); }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setBirdType(getRNG().nextInt(6));
        return data;
    }
}
