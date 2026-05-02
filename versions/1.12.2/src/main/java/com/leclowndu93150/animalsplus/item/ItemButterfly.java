package com.leclowndu93150.animalsplus.item;

import com.leclowndu93150.animalsplus.entity.ambient.EntityButterfly;
import net.minecraft.block.BlockLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemButterfly extends Item {
    public ItemButterfly() {
        setHasSubtypes(true);
        setMaxStackSize(1);
        setMaxDamage(0);
        setCreativeTab(CreativeTabs.DECORATIONS);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        if (world.isRemote) return EnumActionResult.SUCCESS;
        if (!player.canPlayerEdit(pos.offset(facing), facing, stack)) return EnumActionResult.FAIL;
        pos = pos.offset(facing);
        Entity entity = spawnButterfly(world, stack.getMetadata(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        if (entity != null) {
            if (entity instanceof EntityLivingBase && stack.hasDisplayName()) entity.setCustomNameTag(stack.getDisplayName());
            if (!player.capabilities.isCreativeMode) stack.shrink(1);
        }
        return EnumActionResult.SUCCESS;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (world.isRemote) return new ActionResult<>(EnumActionResult.FAIL, stack);
        RayTraceResult rtr = rayTrace(world, player, true);
        if (rtr == null) return new ActionResult<>(EnumActionResult.FAIL, stack);
        if (rtr.typeOfHit == RayTraceResult.Type.BLOCK) {
            BlockPos pos = rtr.getBlockPos();
            if (!world.isBlockModifiable(player, pos)) return new ActionResult<>(EnumActionResult.FAIL, stack);
            if (!player.canPlayerEdit(pos, rtr.sideHit, stack)) return new ActionResult<>(EnumActionResult.FAIL, stack);
            if (world.getBlockState(pos).getBlock() instanceof BlockLiquid) {
                Entity entity = spawnButterfly(world, stack.getMetadata(), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
                if (entity != null) {
                    if (entity instanceof EntityLivingBase && stack.hasDisplayName()) ((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
                    if (!player.capabilities.isCreativeMode) stack.shrink(1);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }

    public static Entity spawnButterfly(World world, int type, double x, double y, double z) {
        EntityButterfly butterfly = new EntityButterfly(world);
        butterfly.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0f), 0.0f);
        butterfly.setButterflyType(type);
        world.spawnEntity(butterfly);
        return butterfly;
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        return super.getTranslationKey() + "." + EnumButterfly.byMetadata(stack.getMetadata()).getUnlocalizedName();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) return;
        for (int i = 0; i < 16; i++) items.add(new ItemStack(this, 1, i));
    }
}
