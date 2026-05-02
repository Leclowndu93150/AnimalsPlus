package com.leclowndu93150.animalsplus.entity.passive;

import net.minecraft.world.World;

public class EntityBirdBase extends EntitySmallAnimal {
    private boolean flying;

    public EntityBirdBase(World world) {
        super(world);
    }

    public boolean isFlying() { return flying; }
    public void setFlying(boolean flag) { flying = false; }
}
