package com.leclowndu93150.animalsplus.entity.water;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityTropicalFish extends EntityFish {
    public EntityTropicalFish(World world) {
        super(world);
        setSize(0.3f, 0.2f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
    }

    @Override
    protected void dropFewItems(boolean flag, int looting) {
        if (rand.nextInt(4) == 0) entityDropItem(new ItemStack(Items.FISH, 1, 2), 0.0f);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        data = super.onInitialSpawn(difficulty, data);
        setFishType(getRNG().nextInt(5));
        return data;
    }
}
