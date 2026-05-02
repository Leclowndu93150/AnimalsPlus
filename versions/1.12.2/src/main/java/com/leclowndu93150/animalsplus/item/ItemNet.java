package com.leclowndu93150.animalsplus.item;

import com.leclowndu93150.animalsplus.entity.ambient.IEntityCatchable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemNet extends Item {
    public ItemNet() {
        setMaxStackSize(1);
        setMaxDamage(16);
        setCreativeTab(CreativeTabs.TOOLS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        world.playSound(player, player.posX, player.posY, player.posZ,
                SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL,
                0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
        player.swingArm(hand);
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand) {
        if (target instanceof IEntityCatchable) {
            IEntityCatchable catchable = (IEntityCatchable) target;
            ItemStack drop = catchable.getCatchedItem();
            if (!player.inventory.addItemStackToInventory(drop)) {
                target.entityDropItem(drop, 0.0f);
            }
            target.setDead();
            stack.damageItem(1, player);
            return true;
        }
        return false;
    }
}
