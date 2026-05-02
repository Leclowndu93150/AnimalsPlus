package com.leclowndu93150.animalsplus.entity.water;

import com.leclowndu93150.animalsplus.init.ModItems;
import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityWhale extends EntitySwimming {
    private static final DataParameter<Byte> WHALE_TYPE = EntityDataManager.createKey(EntityWhale.class, DataSerializers.BYTE);

    public EntityWhale(World world) {
        super(world);
        setSize(6.0f, 3.0f);
        swimRange = 64.0f;
        swimRangeHeight = 8.0f;
        swimSpeed = 0.8f;
        jumpOutOfWater = false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(WHALE_TYPE, (byte) 0);
    }

    @Override public boolean canBePushed() { return false; }
    @Override protected SoundEvent getAmbientSound() { return ModSounds.entity_whale_ambient; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return ModSounds.entity_whale_death; }
    @Override protected float getSoundVolume() { return 2.0f; }

    @Override
    protected void dropFewItems(boolean flag, int looting) {
        int k = 4 + rand.nextInt(4);
        if (looting > 0) k += rand.nextInt(looting + 1);
        for (int l = 0; l < k; l++) dropItem(ModItems.blubber, 1);
    }

    @Override
    protected int getExperiencePoints(EntityPlayer player) {
        return 10 + world.rand.nextInt(10);
    }

    public int getWhaleType() { return dataManager.get(WHALE_TYPE); }
    public void setWhaleType(int type) { dataManager.set(WHALE_TYPE, (byte) type); }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("WhaleType", getWhaleType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setWhaleType(tag.getInteger("WhaleType"));
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setWhaleType(getRNG().nextInt(2));
        return data;
    }
}
