package com.leclowndu93150.animalsplus.entity.ambient;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;

public abstract class EntityInsect extends EntityCreature implements IAnimals {
    public EntityInsect(World world) {
        super(world);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAISwimming(this));
    }

    @Override
    public boolean canBePushed() { return false; }

    @Override
    protected void collideWithEntity(Entity entity) {}

    @Override
    protected void collideWithNearbyEntities() {}

    @Override
    protected boolean canTriggerWalking() { return false; }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() { return true; }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.ARTHROPOD; }

    @Override
    public boolean getCanSpawnHere() {
        if (world.getWorldInfo().getTerrainType() == WorldType.FLAT) return false;
        return rand.nextInt(5) != 0 && super.getCanSpawnHere();
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) { return false; }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) { return false; }
}
