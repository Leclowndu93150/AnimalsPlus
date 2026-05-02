package com.leclowndu93150.animalsplus.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBlubber extends Item {
    @Override
    public int getItemBurnTime(ItemStack stack) {
        return 4000;
    }
}
