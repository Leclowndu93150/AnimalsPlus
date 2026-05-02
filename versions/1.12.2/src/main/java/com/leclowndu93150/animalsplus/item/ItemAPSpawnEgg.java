package com.leclowndu93150.animalsplus.item;

import com.leclowndu93150.animalsplus.AnimalsPlus;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAPSpawnEgg extends Item implements IColoredItem {
    public ItemAPSpawnEgg() {
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (!isInCreativeTab(tab)) return;
        int id = 0;
        for (EntityEntry entry : ForgeRegistries.ENTITIES) {
            if (entry.getRegistryName() != null && AnimalsPlus.MODID.equals(entry.getRegistryName().getNamespace())) {
                items.add(makeEggStack(entry.getRegistryName()));
                id++;
            }
        }
    }

    private ItemStack makeEggStack(ResourceLocation rl) {
        ItemStack stack = new ItemStack(this, 1, 0);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("entity_name", rl.toString());
        stack.setTagCompound(tag);
        return stack;
    }

    public static String getEntityName(ItemStack stack) {
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey("entity_name")) {
            return stack.getTagCompound().getString("entity_name");
        }
        return "";
    }

    public static Entity spawnModCreature(World world, String entityName, double x, double y, double z) {
        ResourceLocation rl = new ResourceLocation(entityName);
        EntityEntry entry = ForgeRegistries.ENTITIES.getValue(rl);
        if (entry == null) return null;
        Entity entity = entry.newInstance(world);
        if (entity instanceof EntityLivingBase) {
            EntityLiving living = (EntityLiving) entity;
            entity.setLocationAndAngles(x, y, z, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0f), 0.0f);
            living.rotationYawHead = living.rotationYaw;
            living.renderYawOffset = living.rotationYaw;
            living.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entity)), null);
            world.spawnEntity(entity);
            living.playLivingSound();
        }
        return entity;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IItemColor getItemColor() {
        return (stack, tintIndex) -> {
            String entityName = getEntityName(stack);
            if (entityName.isEmpty()) return 0xFFFFFF;
            EntityEntry entry = ForgeRegistries.ENTITIES.getValue(new ResourceLocation(entityName));
            if (entry == null || entry.getEgg() == null) return 0xFFFFFF;
            return tintIndex == 0 ? entry.getEgg().primaryColor : entry.getEgg().secondaryColor;
        };
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) return EnumActionResult.SUCCESS;
        ItemStack stack = player.getHeldItem(hand);
        if (!player.canPlayerEdit(pos.offset(facing), facing, stack)) return EnumActionResult.FAIL;
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() == Blocks.MOB_SPAWNER) {
            TileEntity te = world.getTileEntity(pos);
            if (te instanceof TileEntityMobSpawner) {
                MobSpawnerBaseLogic logic = ((TileEntityMobSpawner) te).getSpawnerBaseLogic();
                logic.setEntityId(new ResourceLocation(getEntityName(stack)));
                te.markDirty();
                world.notifyBlockUpdate(pos, state, state, 3);
                if (!player.capabilities.isCreativeMode) stack.shrink(1);
                return EnumActionResult.SUCCESS;
            }
        }
        pos = pos.offset(facing);
        double d0 = 0.0;
        if (facing == EnumFacing.UP && state.getBlock() instanceof BlockFence) d0 = 0.5;
        Entity entity = spawnModCreature(world, getEntityName(stack), pos.getX() + 0.5, pos.getY() + d0, pos.getZ() + 0.5);
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
                Entity entity = spawnModCreature(world, getEntityName(stack), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
                if (entity != null) {
                    if (entity instanceof EntityLivingBase && stack.hasDisplayName()) ((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
                    if (!player.capabilities.isCreativeMode) stack.shrink(1);
                }
            }
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}
