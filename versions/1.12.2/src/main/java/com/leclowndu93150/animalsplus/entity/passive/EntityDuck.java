package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityDuck extends EntityChicken {
    public EntityDuck(World world) {
        super(world);
        timeUntilNextEgg = Integer.MAX_VALUE;
    }

    @Override protected SoundEvent getAmbientSound() { return ModSounds.entity_duck_ambient; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return ModSounds.entity_duck_hurt; }
    @Override protected SoundEvent getDeathSound() { return ModSounds.entity_duck_hurt; }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        timeUntilNextEgg = Integer.MAX_VALUE;
    }

    @Override
    public EntityChicken createChild(EntityAgeable other) {
        return new EntityDuck(world);
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        int feathers = rand.nextInt(3);
        for (int i = 0; i < feathers; i++) dropItem(Items.FEATHER, 1);
    }
}
