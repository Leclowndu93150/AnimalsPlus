package com.leclowndu93150.animalsplus.entity.ambient;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityDragonfly extends EntityWingedBug {
    public EntityDragonfly(World world) {
        super(world);
        setSize(0.5f, 0.2f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    protected BlockPos searchFavoriteBlock() { return null; }
}
