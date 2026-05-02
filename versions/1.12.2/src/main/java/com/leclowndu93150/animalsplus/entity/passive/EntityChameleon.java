package com.leclowndu93150.animalsplus.entity.passive;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityChameleon extends EntitySmallAnimal {
    @SideOnly(Side.CLIENT) private int[] skinColor = {0, 0, 0};
    @SideOnly(Side.CLIENT) private int[] newSkinColor = {0, 0, 0};

    public EntityChameleon(World world) {
        super(world);
        setSize(0.8f, 0.4f);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIWander(this, 1.0));
        tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(2, new EntityAILookIdle(this));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) changeSkinColor();
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @SideOnly(Side.CLIENT)
    public void changeSkinColor() {
        BlockPos pos = new BlockPos(this).offset(EnumFacing.DOWN);
        IBlockState state = world.getBlockState(pos);
        int color = state.getMapColor(world, pos).colorValue;
        if (color != 0) {
            newSkinColor[0] = (color >> 16) & 0xFF;
            newSkinColor[1] = (color >> 8) & 0xFF;
            newSkinColor[2] = color & 0xFF;
            if (skinColor[0] == 0 && skinColor[1] == 0 && skinColor[2] == 0) {
                skinColor[0] = newSkinColor[0];
                skinColor[1] = newSkinColor[1];
                skinColor[2] = newSkinColor[2];
            }
        } else if (skinColor[0] == 0 && skinColor[1] == 0 && skinColor[2] == 0) {
            for (int i = 0; i < 3; i++) { newSkinColor[i] = 255; skinColor[i] = 255; }
        }
        for (int i = 0; i < 3; i++) {
            if (skinColor[i] < newSkinColor[i]) skinColor[i]++;
            else if (skinColor[i] > newSkinColor[i]) skinColor[i]--;
        }
    }

    @SideOnly(Side.CLIENT)
    public float[] getSkinColor() {
        return new float[]{skinColor[0] / 255.0f, skinColor[1] / 255.0f, skinColor[2] / 255.0f};
    }
}
