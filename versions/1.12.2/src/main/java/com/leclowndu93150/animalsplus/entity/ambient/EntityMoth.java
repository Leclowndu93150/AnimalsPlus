package com.leclowndu93150.animalsplus.entity.ambient;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityMoth extends EntityWingedBug {
    public EntityMoth(World world) {
        super(world);
        setSize(0.5f, 0.2f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0);
    }

    @Override
    protected BlockPos searchFavoriteBlock() {
        AxisAlignedBB bb = getEntityBoundingBox().expand(4.0, 4.0, 4.0);
        int xmin = MathHelper.floor(bb.minX), xmax = MathHelper.floor(bb.maxX + 1.0);
        int ymin = MathHelper.floor(bb.minY), ymax = MathHelper.floor(bb.maxY + 1.0);
        int zmin = MathHelper.floor(bb.minZ), zmax = MathHelper.floor(bb.maxZ + 1.0);
        for (int x = xmin; x < xmax; x++) {
            for (int y = ymin; y < ymax; y++) {
                for (int z = zmin; z < zmax; z++) {
                    IBlockState state = world.getBlockState(new BlockPos(x, y, z));
                    if (state.getLightValue() > 0) {
                        return new BlockPos(x + rand.nextInt(2) - rand.nextInt(2), y, z + rand.nextInt(2) - rand.nextInt(2));
                    }
                }
            }
        }
        return null;
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    public void onLivingUpdate() {
        float brightness = getBrightness();
        if (brightness > 0.5f) ticksExisted += 2;
        super.onLivingUpdate();
    }

    @Override
    public boolean getCanSpawnHere() {
        int light = world.getLight(new BlockPos(this));
        return light < 8 && super.getCanSpawnHere();
    }
}
