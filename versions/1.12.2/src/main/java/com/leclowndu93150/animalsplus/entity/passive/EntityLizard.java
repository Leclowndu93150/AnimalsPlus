package com.leclowndu93150.animalsplus.entity.passive;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityLizard extends EntitySmallAnimal {
    private static final DataParameter<Byte> LIZARD_TYPE = EntityDataManager.createKey(EntityLizard.class, DataSerializers.BYTE);

    public EntityLizard(World world) {
        super(world);
        setSize(0.5f, 0.3f);
        tasks.addTask(0, new EntityAIWander(this, 1.0));
        tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(2, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(LIZARD_TYPE, (byte) 0);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    public int getLizardType() { return dataManager.get(LIZARD_TYPE); }
    public void setLizardType(int type) { dataManager.set(LIZARD_TYPE, (byte) type); }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("LizardType", getLizardType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setLizardType(tag.getInteger("LizardType"));
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setLizardType(getRNG().nextInt(3));
        return data;
    }
}
