package com.leclowndu93150.animalsplus.item;

import com.google.common.collect.Maps;

import java.util.Map;

public enum EnumButterfly {
    MONARCH(0, "monarch"),
    BLUE_MORPHO(1, "blue_morpho"),
    PURPLE_EMPEROR(2, "purple_emperor"),
    GREEN_BIRDWING(3, "green_birdwing"),
    RED_ADMIRAL(4, "red_admiral"),
    ORANGETIP(5, "orangetip"),
    COMMON_LIME(6, "common_lime"),
    WHITE(7, "white"),
    SILVERY_BLUE(8, "silvery_blue"),
    SMALL_COPPER(9, "small_copper"),
    CLOUDED_YELLOW(10, "clouded_yellow"),
    COMMA(11, "comma"),
    MARSH_FRITILLARY(12, "marsh_fritillary"),
    PEACOCK(13, "peacock"),
    TIGER_SWALLOWTAIL(14, "tiger_swallowtail"),
    URANIA_SUNSET(15, "urania_sunset");

    private static final Map<Integer, EnumButterfly> META_LOOKUP = Maps.newHashMap();

    static {
        for (EnumButterfly b : values()) META_LOOKUP.put(b.meta, b);
    }

    private final int meta;
    private final String unlocalizedName;

    EnumButterfly(int meta, String unlocalizedName) {
        this.meta = meta;
        this.unlocalizedName = unlocalizedName;
    }

    public int getMetadata() { return meta; }
    public String getUnlocalizedName() { return unlocalizedName; }

    public static EnumButterfly byMetadata(int meta) {
        EnumButterfly b = META_LOOKUP.get(meta);
        return b == null ? MONARCH : b;
    }
}
