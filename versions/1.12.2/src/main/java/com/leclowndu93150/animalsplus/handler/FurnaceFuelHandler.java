package com.leclowndu93150.animalsplus.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

public class FurnaceFuelHandler {
    private final Map<Pair<Item, Integer>, Integer> itemMetaFuelList = new HashMap<>();
    private final Map<Item, Integer> itemFuelList = new HashMap<>();

    @SubscribeEvent
    public void onFurnaceFuel(FurnaceFuelBurnTimeEvent event) {
        ItemStack fuel = event.getItemStack();
        int value = getFuelValue(fuel);
        if (value > 0) {
            event.setBurnTime(value);
        }
    }

    public void addFuel(Item item, int metadata, int value) {
        itemMetaFuelList.put(Pair.of(item, metadata), value);
    }

    public void addFuel(Item item, int value) {
        itemFuelList.put(item, value);
    }

    public void addFuel(Block block, int metadata, int value) {
        addFuel(Item.getItemFromBlock(block), metadata, value);
    }

    public void addFuel(Block block, int value) {
        addFuel(Item.getItemFromBlock(block), value);
    }

    public int getFuelValue(ItemStack stack) {
        if (stack.isEmpty()) return 0;
        Item item = stack.getItem();
        Pair<Item, Integer> pair = Pair.of(item, stack.getItemDamage());
        if (itemMetaFuelList.containsKey(pair)) return itemMetaFuelList.get(pair);
        if (itemFuelList.containsKey(item)) return itemFuelList.get(item);
        return 0;
    }
}
