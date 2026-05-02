/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.renderer.entity.RenderFish;
import com.leclowndu93150.animalsplus.entity.water.EntityTropicalFish;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderTropicalFish
extends RenderFish<EntityTropicalFish> {
    private static final ResourceLocation clownfishTextures = new ResourceLocation("animalsplus", "textures/entity/fish/clownfish.png");
    private static final ResourceLocation blueTangTextures = new ResourceLocation("animalsplus", "textures/entity/fish/blue_tang.png");
    private static final ResourceLocation yellowTangTextures = new ResourceLocation("animalsplus", "textures/entity/fish/yellow_tang.png");
    private static final ResourceLocation damselfishTextures = new ResourceLocation("animalsplus", "textures/entity/fish/damselfish.png");
    private static final ResourceLocation royalGrammaTextures = new ResourceLocation("animalsplus", "textures/entity/fish/royal_gramma.png");

    public RenderTropicalFish(RenderManager renderManager) {
        super(renderManager);
        this.shadowSize *= 0.8f;
    }

    protected void preRenderCallback(EntityTropicalFish tropicalFish, float f) {
        GlStateManager.scale((float)0.8f, (float)0.8f, (float)0.8f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTropicalFish tropicalFish) {
        switch (tropicalFish.getFishType()) {
            default: {
                return clownfishTextures;
            }
            case 1: {
                return blueTangTextures;
            }
            case 2: {
                return yellowTangTextures;
            }
            case 3: {
                return damselfishTextures;
            }
            case 4: 
        }
        return royalGrammaTextures;
    }
}

