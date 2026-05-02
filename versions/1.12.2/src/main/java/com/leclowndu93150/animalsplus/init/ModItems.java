package com.leclowndu93150.animalsplus.init;

import com.leclowndu93150.animalsplus.AnimalsPlus;
import com.leclowndu93150.animalsplus.item.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {
    public static final CreativeTabs tabAnimalsPlus = new CreativeTabs("tabAnimalsPlus") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(net);
        }
    };

    public static ItemArmor.ArmorMaterial reptile_armor = EnumHelper.addArmorMaterial(
            "reptile", AnimalsPlus.MODID + ":reptile", 15, new int[]{2, 5, 6, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0f);

    public static final Item crab_leg          = new ItemFood(3, 0.5f, false).setTranslationKey("crabLeg");
    public static final Item net               = new ItemNet().setTranslationKey("net");
    public static final ItemButterfly butterfly = (ItemButterfly) new ItemButterfly().setTranslationKey("butterfly");
    public static final Item cricket_leg       = new ItemFood(1, 0.2f, false).setTranslationKey("cricketLeg");
    public static final Item breadcrumbs       = new Item().setTranslationKey("breadcrumbs");
    public static final Item shark_tooth       = new Item().setTranslationKey("sharkTooth");
    public static final Item spiked_club       = new ItemSpikedClub().setTranslationKey("spikedClub");
    public static final Item blubber           = new ItemBlubber().setTranslationKey("blubber");
    public static final Item reptile_hide      = new Item().setTranslationKey("reptileHide");
    public static final Item reptile_helmet    = new ItemModArmor(reptile_armor, 0, EntityEquipmentSlot.HEAD).setTranslationKey("helmetReptile");
    public static final Item reptile_chestplate = new ItemModArmor(reptile_armor, 0, EntityEquipmentSlot.CHEST).setTranslationKey("chestplateReptile");
    public static final Item reptile_leggings  = new ItemModArmor(reptile_armor, 0, EntityEquipmentSlot.LEGS).setTranslationKey("leggingsReptile");
    public static final Item reptile_boots     = new ItemModArmor(reptile_armor, 0, EntityEquipmentSlot.FEET).setTranslationKey("bootsReptile");

    public static void init() {
        register(crab_leg,           "crab_leg");
        register(net,                "net");
        register(butterfly,          "butterfly");
        register(cricket_leg,        "cricket_leg");
        register(breadcrumbs,        "breadcrumbs");
        register(shark_tooth,        "shark_tooth");
        register(spiked_club,        "spiked_club");
        register(blubber,            "blubber");
        register(reptile_hide,       "reptile_hide");
        register(reptile_helmet,     "reptile_helmet");
        register(reptile_chestplate, "reptile_chestplate");
        register(reptile_leggings,   "reptile_leggings");
        register(reptile_boots,      "reptile_boots");
    }

    private static void register(Item item, String name) {
        item.setCreativeTab(tabAnimalsPlus);
        item.setRegistryName(new ResourceLocation(AnimalsPlus.MODID, name));
        ForgeRegistries.ITEMS.register(item);
    }
}
