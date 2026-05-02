package com.leclowndu93150.animalsplus.init;

import com.leclowndu93150.animalsplus.AnimalsPlus;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModSounds {
    public static SoundEvent entity_bird_cardinal_ambient;
    public static SoundEvent entity_bird_cardinal_death;
    public static SoundEvent entity_bird_cardinal_hurt;
    public static SoundEvent entity_bird_chickadee_ambient;
    public static SoundEvent entity_bird_chickadee_hurt;
    public static SoundEvent entity_bird_crow_ambient;
    public static SoundEvent entity_bird_crow_death;
    public static SoundEvent entity_bird_crow_hurt;
    public static SoundEvent entity_bird_jay_ambient;
    public static SoundEvent entity_bird_jay_hurt;
    public static SoundEvent entity_bird_parrot_ambient;
    public static SoundEvent entity_bird_parrot_hurt;
    public static SoundEvent entity_bird_sparrow_ambient;
    public static SoundEvent entity_bird_sparrow_hurt;
    public static SoundEvent entity_camel_ambient;
    public static SoundEvent entity_camel_death;
    public static SoundEvent entity_camel_hurt;
    public static SoundEvent entity_cricket_chirp;
    public static SoundEvent entity_crocodile_ambient;
    public static SoundEvent entity_crocodile_attack;
    public static SoundEvent entity_crocodile_death;
    public static SoundEvent entity_crocodile_hurt;
    public static SoundEvent entity_duck_ambient;
    public static SoundEvent entity_duck_hurt;
    public static SoundEvent entity_penguin_ambient;
    public static SoundEvent entity_penguin_hurt;
    public static SoundEvent entity_snake_ambient;
    public static SoundEvent entity_whale_ambient;
    public static SoundEvent entity_whale_death;

    public static void init() {
        entity_bird_cardinal_ambient = register("entity.bird.cardinal.ambient");
        entity_bird_cardinal_death = register("entity.bird.cardinal.death");
        entity_bird_cardinal_hurt = register("entity.bird.cardinal.hurt");
        entity_bird_chickadee_ambient = register("entity.bird.chickadee.ambient");
        entity_bird_chickadee_hurt = register("entity.bird.chickadee.hurt");
        entity_bird_crow_ambient = register("entity.bird.crow.ambient");
        entity_bird_crow_death = register("entity.bird.crow.death");
        entity_bird_crow_hurt = register("entity.bird.crow.hurt");
        entity_bird_jay_ambient = register("entity.bird.jay.ambient");
        entity_bird_jay_hurt = register("entity.bird.jay.hurt");
        entity_bird_parrot_ambient = register("entity.bird.parrot.ambient");
        entity_bird_parrot_hurt = register("entity.bird.parrot.hurt");
        entity_bird_sparrow_ambient = register("entity.bird.sparrow.ambient");
        entity_bird_sparrow_hurt = register("entity.bird.sparrow.hurt");
        entity_camel_ambient = register("entity.camel.ambient");
        entity_camel_death = register("entity.camel.death");
        entity_camel_hurt = register("entity.camel.hurt");
        entity_cricket_chirp = register("entity.cricket.chirp");
        entity_crocodile_ambient = register("entity.crocodile.ambient");
        entity_crocodile_attack = register("entity.crocodile.attack");
        entity_crocodile_death = register("entity.crocodile.death");
        entity_crocodile_hurt = register("entity.crocodile.hurt");
        entity_duck_ambient = register("entity.duck.ambient");
        entity_duck_hurt = register("entity.duck.hurt");
        entity_penguin_ambient = register("entity.penguin.ambient");
        entity_penguin_hurt = register("entity.penguin.hurt");
        entity_snake_ambient = register("entity.snake.ambient");
        entity_whale_ambient = register("entity.whale.ambient");
        entity_whale_death = register("entity.whale.death");
    }

    private static SoundEvent register(String name) {
        ResourceLocation rl = new ResourceLocation(AnimalsPlus.MODID, name);
        SoundEvent event = new SoundEvent(rl).setRegistryName(rl);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
