package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySnake extends EntitySmallAnimal {
    private static final DataParameter<Byte> SNAKE_TYPE = EntityDataManager.createKey(EntitySnake.class, DataSerializers.BYTE);
    public int snakeLenght = 12;
    public float[] ringBuffer = new float[32];
    public int ringBufferIndex = -1;
    private float slitherAnimTime;

    public EntitySnake(World world) {
        super(world);
        setSize(1.15f, 0.2f);
        tasks.addTask(1, new EntityAIAttackMelee(this, 1.5, true));
        tasks.addTask(2, new EntityAIWander(this, 1.0));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityMouse.class, false));
    }

    @Override
    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
        float yawRad = rotationYaw * (float) Math.PI / 180f;
        float halfLen = width / 2f;
        double ox = MathHelper.sin(yawRad) * halfLen;
        double oz = -MathHelper.cos(yawRad) * halfLen;
        AxisAlignedBB bb = getEntityBoundingBox();
        setEntityBoundingBox(bb.offset(ox, 0, oz));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(4.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(SNAKE_TYPE, (byte) 0);
    }

    public float getRotationForPart(int part) {
        return ringBuffer[(ringBufferIndex - part) & 0xF] - rotationYaw;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (ringBufferIndex < 0) {
            for (int i = 0; i < ringBuffer.length; i++) {
                ringBuffer[i] = rotationYaw + MathHelper.sin(slitherAnimTime) * 80.0f;
                slitherAnimTime += 1.0f;
            }
            ringBufferIndex = 0;
        }
        if (Math.abs(motionX) > 0.02 || Math.abs(motionZ) > 0.02) {
            if (++ringBufferIndex == ringBuffer.length) ringBufferIndex = 0;
            ringBuffer[ringBufferIndex] = rotationYaw + MathHelper.sin(slitherAnimTime) * 80.0f;
            slitherAnimTime += 1.0f;
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (entity.attackEntityFrom(DamageSource.causeMobDamage(this), 2.0f)) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.POISON, 300, 0));
            return true;
        }
        return false;
    }

    @Override protected float getSoundVolume() { return 0.2f; }
    @Override protected SoundEvent getAmbientSound() { return ModSounds.entity_snake_ambient; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    public boolean isPotionApplicable(PotionEffect potion) {
        return potion.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(potion);
    }

    public int getSnakeType() { return dataManager.get(SNAKE_TYPE); }
    public void setSnakeType(int type) { dataManager.set(SNAKE_TYPE, (byte) type); }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("Type", getSnakeType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setSnakeType(tag.getInteger("Type"));
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setSnakeType(getRNG().nextInt(3));
        return data;
    }
}
