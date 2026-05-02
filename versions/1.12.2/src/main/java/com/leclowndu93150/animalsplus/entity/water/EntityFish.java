package com.leclowndu93150.animalsplus.entity.water;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityFish extends EntitySwimming {
    private static final DataParameter<Byte> FISH_TYPE = EntityDataManager.createKey(EntityFish.class, DataSerializers.BYTE);

    public EntityFish(World world) {
        super(world);
        setSize(0.4f, 0.3f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(FISH_TYPE, (byte) 0);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    protected void dropFewItems(boolean flag, int looting) {
        if (rand.nextInt(2) == 0) {
            int type = getFishType() == 1 ? 1 : 0;
            entityDropItem(new ItemStack(Items.FISH, 1, type), 0.0f);
        }
    }

    public int getFishType() { return dataManager.get(FISH_TYPE); }
    public void setFishType(int type) { dataManager.set(FISH_TYPE, (byte) type); }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("Type", getFishType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setFishType(tag.getInteger("Type"));
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setFishType(getRNG().nextInt(3));
        return data;
    }
}
