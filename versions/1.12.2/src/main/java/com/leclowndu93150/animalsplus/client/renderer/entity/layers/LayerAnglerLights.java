/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.entity.layers.LayerRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLiving
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity.layers;

import com.leclowndu93150.animalsplus.client.renderer.entity.RenderAngler;
import com.leclowndu93150.animalsplus.entity.water.EntityAngler;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class LayerAnglerLights
implements LayerRenderer<EntityAngler> {
    private static final ResourceLocation anglerLightsTextures = new ResourceLocation("animalsplus", "textures/entity/angler/angler_lights.png");
    private final RenderAngler anglerRenderer;

    public LayerAnglerLights(RenderAngler anglerRendererIn) {
        this.anglerRenderer = anglerRendererIn;
    }

    public void doRenderLayer(EntityAngler anglerIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.anglerRenderer.bindTexture(anglerLightsTextures);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)1, (int)1);
        GlStateManager.disableLighting();
        if (anglerIn.isInvisible()) {
            GlStateManager.depthMask((boolean)false);
        } else {
            GlStateManager.depthMask((boolean)true);
        }
        int c0 = 61680;
        int i = c0 % 65536;
        int j = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords((int)OpenGlHelper.lightmapTexUnit, (float)((float)i / 1.0f), (float)((float)j / 1.0f));
        GlStateManager.enableLighting();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        this.anglerRenderer.getMainModel().render((Entity)anglerIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.anglerRenderer.setLightmap(anglerIn);
        GlStateManager.disableBlend();
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}

