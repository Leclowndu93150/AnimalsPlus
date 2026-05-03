package com.leclowndu93150.animalsplus.init;

import com.leclowndu93150.animalsplus.AnimalsPlus;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import com.leclowndu93150.animalsplus.entity.ambient.*;
import com.leclowndu93150.animalsplus.entity.passive.*;
import com.leclowndu93150.animalsplus.entity.water.*;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.Set;

public class ModEntities {
    public static void preInit() {
        register(EntityCentipede.class,  "Centipede",    0,  80, 3, true, 15708256, 5848090);
        register(EntityCricket.class,    "Cricket",      1,  80, 3, true, 8343842,  0x200C0C);
        register(EntityButterfly.class,  "Butterfly",    2,  80, 3, false, 15493137, 721666);
        register(EntityMoth.class,       "Moth",         3,  80, 3, true, 13614758, 6704950);
        register(EntityDragonfly.class,  "Dragonfly",    4,  80, 3, false, 0x454944, 14863822);
        register(EntityFish.class,       "Fish",         5,  64, 3, true, 6928807,  6057867);
        register(EntityTropicalFish.class,"TropicalFish",6,  64, 3, true, 15887623, 15725300);
        register(EntityPiranha.class,    "Piranha",      7,  80, 3, true, 2829109,  14634030);
        register(EntityAngler.class,     "Angler",       8,  64, 3, true, 5397296,  15392616);
        register(EntityMantaRay.class,   "MantaRay",     9,  80, 3, true, 1052965,  0xDCDCDC);
        register(EntityWhale.class,      "Whale",        10, 144,3, true, 9415875,  7243159);
        register(EntityOctopus.class,    "Octopus",      11, 80, 3, true, 8474253,  16091641);
        register(EntityShark.class,      "Shark",        12, 80, 3, true, 0xA8A8A8, 0x747474);
        register(EntityCrab.class,       "Crab",         13, 80, 3, true, 14252298, 16235636);
        register(EntitySnake.class,      "Snake",        14, 80, 3, true, 7096116,  14531977);
        register(EntityLizard.class,     "Lizard",       15, 80, 3, true, 6640957,  10325365);
        register(EntityChameleon.class,  "Chameleon",    16, 80, 3, true, 6073690,  5541444);
        register(EntityMouse.class,      "Mouse",        17, 80, 3, true, 5986381,  15902877);
        register(EntityBird.class,       "Bird",         18, 80, 3, true, 4934535,  15910160);
        register(EntityDuck.class,       "Duck",         19, 80, 3, true, 4413191,  13155998);
        register(EntityPenguin.class,    "Penguin",      20, 80, 3, true, 1066089,  0xD4D4D4);
        register(EntityLyrebird.class,   "Lyrebird",     21, 80, 3, true, 6705992,  8497348);
        register(EntityTortoise.class,   "Tortoise",     22, 80, 3, true, 6850090,  7164960);
        register(EntityCrocodile.class,  "Crocodile",    23, 80, 3, true, 2306333,  8420949);
        register(EntityKomodoDragon.class,"KomodoDragon",24, 80, 3, true, 0x4F422F, 12077098);
        register(EntityCamel.class,      "Camel",        25, 80, 3, true, 14192438, 15382652);
        register(EntityKiwi.class,       "Kiwi",         26, 80, 3, true, 6245698,  16509163);

        EntitySpawnPlacementRegistry.setPlacementType(EntityFish.class,        EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityTropicalFish.class, EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityPiranha.class,      EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityAngler.class,       EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityMantaRay.class,     EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityWhale.class,        EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityOctopus.class,      EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityShark.class,        EntityLiving.SpawnPlacementType.IN_WATER);
        EntitySpawnPlacementRegistry.setPlacementType(EntityCentipede.class,    EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityCricket.class,      EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityButterfly.class,    EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityMoth.class,         EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityDragonfly.class,    EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntitySnake.class,        EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityLizard.class,       EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityChameleon.class,    EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityMouse.class,        EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityBird.class,         EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityDuck.class,         EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityPenguin.class,      EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityCrab.class,         EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityTortoise.class,     EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityCrocodile.class,    EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityKomodoDragon.class, EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityCamel.class,        EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityLyrebird.class,     EntityLiving.SpawnPlacementType.ON_GROUND);
        EntitySpawnPlacementRegistry.setPlacementType(EntityKiwi.class,         EntityLiving.SpawnPlacementType.ON_GROUND);
    }

    public static void init() {
        if (ModConfiguration.spawnBird) {
            addSpawn(EntityBird.class, 10, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.FOREST);
            addSpawn(EntityBird.class, 10, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.SWAMP);
            addSpawn(EntityBird.class, 10, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.JUNGLE);
            addSpawn(EntityBird.class, 10, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.PLAINS);
            addSpawn(EntityBird.class, 10, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.SAVANNA);
        }
        if (ModConfiguration.spawnDuck) {
            addSpawn(EntityDuck.class, 10, 2, 4, EnumCreatureType.CREATURE, BiomeDictionary.Type.RIVER);
            addSpawn(EntityDuck.class, 10, 2, 4, EnumCreatureType.CREATURE, BiomeDictionary.Type.SWAMP);
        }
        if (ModConfiguration.spawnPenguin) {
            addSpawn(EntityPenguin.class, 6, 2, 6, EnumCreatureType.CREATURE, BiomeDictionary.Type.SNOWY);
        }
        if (ModConfiguration.spawnSnake) {
            addSpawn(EntitySnake.class, 12, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.SANDY);
            addSpawn(EntitySnake.class, 12, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.SAVANNA);
            addSpawn(EntitySnake.class, 12, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.HOT);
        }
        if (ModConfiguration.spawnLizard) {
            addSpawn(EntityLizard.class, 12, 2, 4, EnumCreatureType.CREATURE, BiomeDictionary.Type.SANDY);
            addSpawn(EntityLizard.class, 12, 2, 4, EnumCreatureType.CREATURE, BiomeDictionary.Type.SAVANNA);
            addSpawn(EntityLizard.class, 12, 2, 4, EnumCreatureType.CREATURE, BiomeDictionary.Type.HOT);
        }
        if (ModConfiguration.spawnCrab) {
            addSpawn(EntityCrab.class, 8, 2, 4, EnumCreatureType.CREATURE, BiomeDictionary.Type.BEACH);
        }
        if (ModConfiguration.spawnTortoise) {
            addSpawn(EntityTortoise.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.SWAMP);
            addSpawn(EntityTortoise.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.JUNGLE);
        }
        if (ModConfiguration.spawnChameleon) {
            addSpawn(EntityChameleon.class, 8, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.JUNGLE);
        }
        if (ModConfiguration.spawnLyrebird) {
            addSpawn(EntityLyrebird.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.JUNGLE);
        }
        if (ModConfiguration.spawnFish) {
            addSpawn(EntityFish.class, 16, 2, 4, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.RIVER);
            addSpawn(EntityFish.class, 16, 4, 6, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.OCEAN);
        }
        if (ModConfiguration.spawnTropicalFish) {
            addSpawn(EntityTropicalFish.class, 14, 4, 6, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.OCEAN);
            addSpawn(EntityTropicalFish.class, 12, 4, 6, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.RIVER);
            addSpawn(EntityTropicalFish.class, 8,  4, 6, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.SAVANNA);
            addSpawn(EntityTropicalFish.class, 6,  4, 6, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.JUNGLE);
        }
        if (ModConfiguration.spawnAngler) {
            addSpawn(EntityAngler.class, 8, 1, 2, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.OCEAN);
        }
        if (ModConfiguration.spawnMantaRay) {
            addSpawn(EntityMantaRay.class, 6, 1, 1, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.OCEAN);
        }
        if (ModConfiguration.spawnWhale) {
            EntityRegistry.addSpawn(EntityWhale.class, 1, 1, 1, EnumCreatureType.WATER_CREATURE, Biomes.DEEP_OCEAN);
        }
        if (ModConfiguration.spawnPiranha) {
            addSpawn(EntityPiranha.class, 8,  6, 10, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.RIVER);
            addSpawn(EntityPiranha.class, 10, 6, 10, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.SAVANNA);
            addSpawn(EntityPiranha.class, 10, 4, 6,  EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.JUNGLE);
        }
        if (ModConfiguration.spawnShark) {
            addSpawn(EntityShark.class, 4, 1, 4, EnumCreatureType.WATER_CREATURE, BiomeDictionary.Type.OCEAN);
        }
        if (ModConfiguration.spawnCentipede) {
            addSpawn(EntityCentipede.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.FOREST);
            addSpawn(EntityCentipede.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SWAMP);
        }
        if (ModConfiguration.spawnCricket) {
            addSpawn(EntityCricket.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.JUNGLE);
            addSpawn(EntityCricket.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.PLAINS);
            addSpawn(EntityCricket.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SWAMP);
            addSpawn(EntityCricket.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SAVANNA);
        }
        if (ModConfiguration.spawnButterfly) {
            addSpawn(EntityButterfly.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.JUNGLE);
            addSpawn(EntityButterfly.class, 2, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.FOREST);
            addSpawn(EntityButterfly.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.PLAINS);
            addSpawn(EntityButterfly.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SWAMP);
            addSpawn(EntityButterfly.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SAVANNA);
        }
        if (ModConfiguration.spawnMoth) {
            addSpawn(EntityMoth.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.FOREST);
            addSpawn(EntityMoth.class, 4, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SWAMP);
        }
        if (ModConfiguration.spawnMouse) {
            addSpawn(EntityMouse.class, 4, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.FOREST);
        }
        if (ModConfiguration.spawnDragonfly) {
            addSpawn(EntityDragonfly.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.RIVER);
            addSpawn(EntityDragonfly.class, 6, 1, 2, EnumCreatureType.AMBIENT, BiomeDictionary.Type.SWAMP);
        }
        if (ModConfiguration.spawnCrocodile) {
            addSpawn(EntityCrocodile.class, 6, 1, 3, EnumCreatureType.CREATURE, BiomeDictionary.Type.RIVER);
            addSpawn(EntityCrocodile.class, 6, 1, 3, EnumCreatureType.CREATURE, BiomeDictionary.Type.SWAMP);
        }
        if (ModConfiguration.spawnKomodoDragon) {
            addSpawn(EntityKomodoDragon.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.PLAINS);
            addSpawn(EntityKomodoDragon.class, 6, 1, 3, EnumCreatureType.CREATURE, BiomeDictionary.Type.RIVER);
            addSpawn(EntityKomodoDragon.class, 6, 1, 3, EnumCreatureType.CREATURE, BiomeDictionary.Type.SWAMP);
            addSpawn(EntityKomodoDragon.class, 8, 1, 1, EnumCreatureType.CREATURE, BiomeDictionary.Type.SANDY);
            addSpawn(EntityKomodoDragon.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.SAVANNA);
        }
        if (ModConfiguration.spawnCamel) {
            EntityRegistry.addSpawn(EntityCamel.class, 4, 1, 3, EnumCreatureType.CREATURE, Biomes.DESERT);
        }
        if (ModConfiguration.spawnKiwi) {
            addSpawn(EntityKiwi.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.FOREST);
            addSpawn(EntityKiwi.class, 4, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.JUNGLE);
            addSpawn(EntityKiwi.class, 6, 1, 2, EnumCreatureType.CREATURE, BiomeDictionary.Type.PLAINS);
        }
    }

    private static <T extends net.minecraft.entity.EntityLiving> void register(Class<T> cls, String name, int id, int range, int freq, boolean vel, int primary, int secondary) {
        EntityRegistry.registerModEntity(
                new net.minecraft.util.ResourceLocation(AnimalsPlus.MODID, name),
                cls, name, id, AnimalsPlus.instance, range, freq, vel, primary, secondary);
    }

    private static <T extends net.minecraft.entity.EntityLiving> void addSpawn(Class<T> cls, int weight, int min, int max, EnumCreatureType type, BiomeDictionary.Type biomeType) {
        Set<Biome> biomes = BiomeDictionary.getBiomes(biomeType);
        EntityRegistry.addSpawn(cls, weight, min, max, type, biomes.toArray(new Biome[0]));
    }
}
