package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityPenguin extends EntitySmallAnimal {
    private boolean isGliding;
    private float glideVecX;
    private float glideVecZ;
    private float glideSpeed;

    public EntityPenguin(World world) {
        super(world);
        setSize(0.5f, 1.0f);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 2.0));
        tasks.addTask(2, new EntityAIWander(this, 0.8));
        tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (isGliding) {
            if (!world.isRemote) {
                motionX = glideVecX * glideSpeed;
                motionZ = glideVecZ * glideSpeed;
            }
            rotationYaw = (float) Math.atan2(motionX, motionZ);
        }
    }

    public boolean isGliding() { return isGliding; }

    public void startGlide() {
        isGliding = true;
        float random = rand.nextFloat() * (float) Math.PI * 2.0f;
        glideVecX = MathHelper.cos(random) * 0.2f;
        glideVecZ = MathHelper.sin(random) * 0.2f;
    }

    @Override protected float getSoundVolume() { return 0.4f; }
    @Override protected SoundEvent getAmbientSound() { return ModSounds.entity_penguin_ambient; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return ModSounds.entity_penguin_hurt; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    protected void dropFewItems(boolean flag, int looting) {
        int k = 1 + rand.nextInt(2);
        if (looting > 0) k += rand.nextInt(looting + 1);
        for (int i = 0; i < k; i++) dropItem(Items.FISH, 1);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
    }
}
