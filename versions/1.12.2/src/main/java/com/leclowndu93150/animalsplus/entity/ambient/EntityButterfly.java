package com.leclowndu93150.animalsplus.entity.ambient;

import com.leclowndu93150.animalsplus.init.ModItems;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityButterfly extends EntityWingedBug implements IEntityCatchable {
    private static final DataParameter<Byte> BUTTERFLY_TYPE = EntityDataManager.createKey(EntityButterfly.class, DataSerializers.BYTE);

    public EntityButterfly(World world) {
        super(world);
        setSize(0.5f, 0.2f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(BUTTERFLY_TYPE, (byte) 0);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(net.minecraft.util.DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setInteger("Type", getButterflyType());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setButterflyType(tag.getInteger("Type"));
    }

    public int getButterflyType() { return dataManager.get(BUTTERFLY_TYPE); }
    public void setButterflyType(int type) { dataManager.set(BUTTERFLY_TYPE, (byte) type); }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setButterflyType(getRNG().nextInt(16));
        return data;
    }

    @Override
    public ItemStack getCatchedItem() {
        return new ItemStack(ModItems.butterfly, 1, getButterflyType());
    }
}
