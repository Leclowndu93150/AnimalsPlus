package com.leclowndu93150.animalsplus.init;

import com.leclowndu93150.animalsplus.AnimalsPlus;
import com.leclowndu93150.animalsplus.handler.FurnaceFuelHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
    public static void init() {
        addCraftingRecipes();
        addSmeltingRecipes();
    }

    private static void addCraftingRecipes() {
        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "net"), null,
                new ItemStack(ModItems.net),
                " ~~", " /~", "/  ",
                '/', Items.STICK, '~', Items.STRING);

        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "breadcrumbs"), null,
                new ItemStack(ModItems.breadcrumbs, 4),
                "#",
                '#', Items.BREAD);

        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "spiked_club"), null,
                new ItemStack(ModItems.spiked_club),
                "*/*", "*/*", " / ",
                '/', Items.STICK, '*', ModItems.shark_tooth);

        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "reptile_helmet"), null,
                new ItemStack(ModItems.reptile_helmet),
                "XXX", "X X",
                'X', ModItems.reptile_hide);

        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "reptile_chestplate"), null,
                new ItemStack(ModItems.reptile_chestplate),
                "X X", "XXX", "XXX",
                'X', ModItems.reptile_hide);

        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "reptile_leggings"), null,
                new ItemStack(ModItems.reptile_leggings),
                "XXX", "X X", "X X",
                'X', ModItems.reptile_hide);

        GameRegistry.addShapedRecipe(new ResourceLocation(AnimalsPlus.MODID, "reptile_boots"), null,
                new ItemStack(ModItems.reptile_boots),
                "X X", "X X",
                'X', ModItems.reptile_hide);
    }

    public static void addSmeltingRecipes() {
        FurnaceFuelHandler handler = new FurnaceFuelHandler();
        handler.addFuel(ModItems.blubber, 4000);
        MinecraftForge.EVENT_BUS.register(handler);
    }
}
