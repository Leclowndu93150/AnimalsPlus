package com.leclowndu93150.animalsplus.init;

import com.leclowndu93150.animalsplus.AnimalsPlus;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ModConfiguration {
    public static boolean spawnCentipede = true;
    public static boolean spawnCricket = true;
    public static boolean spawnButterfly = true;
    public static boolean spawnMoth = true;
    public static boolean spawnFish = true;
    public static boolean spawnTropicalFish = true;
    public static boolean spawnAngler = true;
    public static boolean spawnMantaRay = true;
    public static boolean spawnWhale = true;
    public static boolean spawnSnake = true;
    public static boolean spawnLizard = true;
    public static boolean spawnChameleon = true;
    public static boolean spawnMouse = true;
    public static boolean spawnBird = true;
    public static boolean spawnDuck = true;
    public static boolean spawnPenguin = true;
    public static boolean spawnPiranha = true;
    public static boolean spawnShark = true;
    public static boolean spawnCrab = true;
    public static boolean spawnTortoise = true;
    public static boolean spawnDragonfly = true;
    public static boolean spawnLyrebird = true;
    public static boolean spawnCrocodile = true;
    public static boolean spawnKomodoDragon = true;
    public static boolean spawnCamel = true;
    public static boolean spawnKiwi = true;
    public static Configuration config;

    public static void init(File configFile) {
        config = new Configuration(configFile);
        try {
            config.load();
            spawnCentipede = config.getBoolean("allowSpawn", "centipede", true, "Allow spawning centipedes");
            spawnCricket = config.getBoolean("allowSpawn", "cricket", true, "Allow spawning crickets");
            spawnButterfly = config.getBoolean("allowSpawn", "butterfly", true, "Allow spawning butterflies");
            spawnMoth = config.getBoolean("allowSpawn", "moth", true, "Allow spawning moths");
            spawnFish = config.getBoolean("allowSpawn", "fish", true, "Allow spawning fish");
            spawnTropicalFish = config.getBoolean("allowSpawn", "tropicalFish", true, "Allow spawning tropical fish");
            spawnAngler = config.getBoolean("allowSpawn", "angler", true, "Allow spawning anglerfish");
            spawnMantaRay = config.getBoolean("allowSpawn", "mantaRay", true, "Allow spawning manta rays");
            spawnWhale = config.getBoolean("allowSpawn", "whale", true, "Allow spawning whales");
            spawnSnake = config.getBoolean("allowSpawn", "snake", true, "Allow spawning snakes");
            spawnLizard = config.getBoolean("allowSpawn", "lizard", true, "Allow spawning lizards");
            spawnChameleon = config.getBoolean("allowSpawn", "chameleon", true, "Allow spawning chameleons");
            spawnMouse = config.getBoolean("allowSpawn", "mouse", true, "Allow spawning mice");
            spawnBird = config.getBoolean("allowSpawn", "bird", true, "Allow spawning birds");
            spawnDuck = config.getBoolean("allowSpawn", "duck", true, "Allow spawning ducks");
            spawnPenguin = config.getBoolean("allowSpawn", "penguin", true, "Allow spawning penguins");
            spawnPiranha = config.getBoolean("allowSpawn", "piranha", true, "Allow spawning piranhas");
            spawnShark = config.getBoolean("allowSpawn", "shark", true, "Allow spawning sharks");
            spawnCrab = config.getBoolean("allowSpawn", "crab", true, "Allow spawning crabs");
            spawnTortoise = config.getBoolean("allowSpawn", "tortoise", true, "Allow spawning tortoises");
            spawnDragonfly = config.getBoolean("allowSpawn", "dragonfly", true, "Allow spawning dragonflies");
            spawnLyrebird = config.getBoolean("allowSpawn", "lyrebird", true, "Allow spawning lyrebirds");
            spawnCrocodile = config.getBoolean("allowSpawn", "crocodile", true, "Allow spawning crocodiles");
            spawnKomodoDragon = config.getBoolean("allowSpawn", "komodoDragon", true, "Allow spawning komodo dragons");
            spawnCamel = config.getBoolean("allowSpawn", "camel", true, "Allow spawning camels");
            spawnKiwi = config.getBoolean("allowSpawn", "kiwi", true, "Allow spawning kiwis");
        } catch (Exception e) {
            AnimalsPlus.logger.error("AnimalsPlus encountered a problem loading the config file.", e);
        } finally {
            if (config.hasChanged()) config.save();
        }
    }
}
