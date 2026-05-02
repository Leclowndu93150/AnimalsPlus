/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelAngler;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderSwimming;
import com.leclowndu93150.animalsplus.client.renderer.entity.layers.LayerAnglerLights;
import com.leclowndu93150.animalsplus.entity.water.EntityAngler;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderAngler
extends RenderSwimming<EntityAngler> {
    private static final ResourceLocation anglerTextures = new ResourceLocation("animalsplus", "textures/entity/angler/angler.png");

    public RenderAngler(RenderManager renderManager) {
        super(renderManager, new ModelAngler(), 0.3f);
        this.addLayer(new LayerAnglerLights(this));
    }

    protected ResourceLocation getEntityTexture(EntityAngler angler) {
        return anglerTextures;
    }
}

