package com.leclowndu93150.animalsplus.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;

public abstract class EntitySmallAnimal extends EntityCreature implements IAnimals {
    public EntitySmallAnimal(World world) {
        super(world);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAISwimming(this));
    }

    @Override
    public boolean canBeLeashedTo(EntityPlayer player) { return false; }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand) { return false; }

    @Override
    public boolean getCanSpawnHere() {
        if (world.getWorldInfo().getTerrainType() == WorldType.FLAT) return false;
        return super.getCanSpawnHere();
    }
}
