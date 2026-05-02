/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelButterfly;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderInsect;
import com.leclowndu93150.animalsplus.entity.ambient.EntityButterfly;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderButterfly
extends RenderInsect<EntityButterfly> {
    private static final ResourceLocation[] butterflySpeciesTextures = new ResourceLocation[]{new ResourceLocation("animalsplus", "textures/entity/butterfly/monarch.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/blue_morpho.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/purple_emperor.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/green_birdwing.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/red_admiral.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/orangetip.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/common_lime.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/white.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/silvery_blue.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/small_copper.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/clouded_yellow.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/comma.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/marsh_fritillary.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/peacock.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/tiger_swallowtail.png"), new ResourceLocation("animalsplus", "textures/entity/butterfly/urania_sunset.png")};

    public RenderButterfly(RenderManager renderManager) {
        super(renderManager, new ModelButterfly(), 0.2f);
    }

    protected ResourceLocation getEntityTexture(EntityButterfly butterfly) {
        int species = MathHelper.clamp((int)butterfly.getButterflyType(), (int)0, (int)(butterflySpeciesTextures.length - 1));
        return butterflySpeciesTextures[species];
    }
}

