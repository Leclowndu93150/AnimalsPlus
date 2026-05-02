package com.leclowndu93150.animalsplus.entity.passive;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityLyrebird extends EntitySmallAnimal {
    private static final SoundEvent[] AMBIENT = {SoundEvents.ENTITY_SHEEP_AMBIENT, SoundEvents.ENTITY_CAT_AMBIENT, SoundEvents.ENTITY_COW_AMBIENT, SoundEvents.ENTITY_CREEPER_PRIMED, SoundEvents.BLOCK_WOOD_BREAK, SoundEvents.BLOCK_GRASS_BREAK};
    private static final SoundEvent[] HURT    = {SoundEvents.ENTITY_CAT_HURT, SoundEvents.ENTITY_DONKEY_HURT, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundEvents.ENTITY_GENERIC_HURT, SoundEvents.ENTITY_HOSTILE_HURT};
    private static final SoundEvent[] DEATH   = {SoundEvents.ENTITY_CREEPER_DEATH, SoundEvents.ENTITY_RABBIT_DEATH, SoundEvents.ENTITY_SKELETON_DEATH, SoundEvents.ENTITY_ZOMBIE_DEATH};

    public EntityLyrebird(World world) {
        super(world);
        setSize(0.8f, 0.8f);
        tasks.addTask(0, new EntityAIPanic(this, 1.2));
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIWander(this, 1.0));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(4, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
    }

    @Override protected SoundEvent getAmbientSound() { return AMBIENT[rand.nextInt(AMBIENT.length)]; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return HURT[rand.nextInt(HURT.length)]; }
    @Override protected SoundEvent getDeathSound() { return DEATH[rand.nextInt(DEATH.length)]; }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }

    @Override
    protected float getSoundVolume() {
        return (float) (rand.nextGaussian() + 0.8f);
    }

    @Override
    protected void dropFewItems(boolean drop, int looting) {
        if (world.getBiome(getPosition()) == Biomes.JUNGLE) dropItem(Items.MELON_SEEDS, rand.nextInt(2));
        entityDropItem(new ItemStack(Items.FEATHER, rand.nextInt(3), 0), 0.5f);
    }
}
