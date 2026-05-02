package com.leclowndu93150.animalsplus.entity.water;

import com.leclowndu93150.animalsplus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityShark extends EntitySwimming {
    public EntityShark(World world) {
        super(world);
        setSize(2.0f, 0.7f);
        isAggressive = true;
        swimRange = 16.0f;
        swimSpeed = 0.9f;
        attackInterval = 30;
        jumpOutOfWater = false;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0);
    }

    @Override
    public void onUpdate() {
        if (!world.isRemote && world.getDifficulty() == EnumDifficulty.PEACEFUL) setDead();
        super.onUpdate();
    }

    @Override
    protected Entity findEntityToAttack() {
        AxisAlignedBB area = getEntityBoundingBox().expand(16.0, 16.0, 16.0);
        Entity fish = world.findNearestEntityWithinAABB(EntityFish.class, area, this);
        if (fish != null) return fish;
        return world.findNearestEntityWithinAABB(EntityAnimal.class, area, this);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }
    @Override protected Item getDropItem() { return ModItems.shark_tooth; }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        int i = rand.nextInt(2);
        for (int j = 0; j < i; j++) dropItem(ModItems.shark_tooth, 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return world.getDifficulty() != EnumDifficulty.PEACEFUL && super.getCanSpawnHere();
    }
}
