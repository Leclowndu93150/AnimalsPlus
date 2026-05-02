package com.leclowndu93150.animalsplus.entity.ambient;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityWingedBug extends EntityInsect {
    private BlockPos spawnPosition;

    public EntityWingedBug(World world) {
        super(world);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        motionY *= 0.6f;
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        if (spawnPosition != null && (!world.isAirBlock(spawnPosition) || spawnPosition.getY() < 1)) {
            spawnPosition = null;
        }
        if (spawnPosition == null && rand.nextInt(4) == 0) {
            BlockPos block = searchFavoriteBlock();
            if (block != null) spawnPosition = block;
        }
        if (spawnPosition == null || rand.nextInt(30) == 0 || spawnPosition.distanceSq(posX, posY, posZ) < 4.0) {
            spawnPosition = new BlockPos((int) posX + rand.nextInt(4) - rand.nextInt(4),
                    (int) posY + rand.nextInt(6) - 3,
                    (int) posZ + rand.nextInt(4) - rand.nextInt(4));
        }
        double d0 = spawnPosition.getX() + 0.5 - posX;
        double d1 = spawnPosition.getY() + 1.0 - posY;
        double d2 = spawnPosition.getZ() + 0.5 - posZ;
        motionX += (Math.signum(d0) * 0.5 - motionX) * 0.1f;
        motionY += (Math.signum(d1) * 0.7f - motionY) * 0.1f;
        motionZ += (Math.signum(d2) * 0.5 - motionZ) * 0.1f;
        float f = (float) (Math.atan2(motionZ, motionX) * 180.0 / Math.PI) - 90.0f;
        float f1 = MathHelper.wrapDegrees(f - rotationYaw);
        moveForward = 0.5f;
        rotationYaw += f1;
    }

    protected BlockPos searchFavoriteBlock() {
        AxisAlignedBB bb = getEntityBoundingBox().expand(4.0, 2.0, 4.0);
        int xmin = MathHelper.floor(bb.minX), xmax = MathHelper.floor(bb.maxX + 1.0);
        int ymin = MathHelper.floor(bb.minY), ymax = MathHelper.floor(bb.maxY + 1.0);
        int zmin = MathHelper.floor(bb.minZ), zmax = MathHelper.floor(bb.maxZ + 1.0);
        for (int x = xmin; x < xmax; x++) {
            for (int y = ymin; y < ymax; y++) {
                for (int z = zmin; z < zmax; z++) {
                    Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
                    if ((block == Blocks.YELLOW_FLOWER || block == Blocks.RED_FLOWER) && rand.nextInt(5) == 0) {
                        return new BlockPos(x + rand.nextInt(2) - rand.nextInt(2), y, z + rand.nextInt(2) - rand.nextInt(2));
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {}

    @Override
    protected void updateFallState(double y, boolean onGround, IBlockState state, BlockPos pos) {}
}
