package com.leclowndu93150.animalsplus.client;

import com.leclowndu93150.animalsplus.CommonProxy;
import com.leclowndu93150.animalsplus.client.renderer.entity.*;
import com.leclowndu93150.animalsplus.entity.ambient.*;
import com.leclowndu93150.animalsplus.entity.passive.*;
import com.leclowndu93150.animalsplus.entity.water.*;
import com.leclowndu93150.animalsplus.init.ModItems;
import com.leclowndu93150.animalsplus.item.EnumButterfly;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCentipede.class,  RenderCentipede::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCricket.class,    RenderCricket::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityButterfly.class,  RenderButterfly::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMoth.class,       RenderMoth::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFish.class,       RenderFish::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTropicalFish.class, RenderTropicalFish::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityAngler.class,     RenderAngler::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMantaRay.class,   RenderMantaRay::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWhale.class,      RenderWhale::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySnake.class,      RenderSnake::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLizard.class,     RenderLizard::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityChameleon.class,  RenderChameleon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMouse.class,      RenderMouse::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBird.class,       RenderBird::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class,       RenderDuck::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class,    RenderPenguin::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPiranha.class,    RenderPiranha::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShark.class,      RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class,       RenderCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTortoise.class,   RenderTortoise::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDragonfly.class,  RenderDragonfly::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLyrebird.class,   RenderLyrebird::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCrocodile.class,  RenderCrocodile::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityKomodoDragon.class, RenderKomodoDragon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityOctopus.class,    RenderOctopus::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCamel.class,      RenderCamel::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityKiwi.class,       RenderKiwi::new);
    }

    @Override
    public void registerItemRenderers() {
        registerItem(ModItems.crab_leg, "crab_leg");
        registerItem(ModItems.net, "net");
        registerItem(ModItems.breadcrumbs, "breadcrumbs");
        registerItem(ModItems.cricket_leg, "cricket_leg");
        registerItem(ModItems.shark_tooth, "shark_tooth");
        registerItem(ModItems.spiked_club, "spiked_club");
        registerItem(ModItems.blubber, "blubber");
        registerItem(ModItems.reptile_hide, "reptile_hide");
        registerItem(ModItems.reptile_helmet, "reptile_helmet");
        registerItem(ModItems.reptile_chestplate, "reptile_chestplate");
        registerItem(ModItems.reptile_leggings, "reptile_leggings");
        registerItem(ModItems.reptile_boots, "reptile_boots");

        for (EnumButterfly b : EnumButterfly.values()) {
            ModelLoader.setCustomModelResourceLocation(ModItems.butterfly, b.getMetadata(),
                    new ModelResourceLocation("animalsplus:butterfly_" + b.getUnlocalizedName(), "inventory"));
        }
    }

    @Override
    public void registerColouring() {
    }

    @Override
    public void registerBlockRenderers() {}

    private void registerItem(Item item, String name) {
        ModelLoader.setCustomModelResourceLocation(item, 0,
                new ModelResourceLocation(new ResourceLocation("animalsplus", name), "inventory"));
    }
}
