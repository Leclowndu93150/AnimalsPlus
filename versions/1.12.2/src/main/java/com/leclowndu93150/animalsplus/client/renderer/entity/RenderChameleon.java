/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelChameleon;
import com.leclowndu93150.animalsplus.entity.passive.EntityChameleon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderChameleon
extends RenderLiving<EntityChameleon> {
    private static final ResourceLocation chameleonTextures = new ResourceLocation("animalsplus", "textures/entity/chameleon.png");

    public RenderChameleon(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelChameleon(), 0.4f);
    }

    protected void preRenderCallback(EntityChameleon chameleon, float partialTickTime) {
        float[] color = chameleon.getSkinColor();
        GlStateManager.color((float)color[0], (float)color[1], (float)color[2]);
    }

    protected ResourceLocation getEntityTexture(EntityChameleon chameleon) {
        return chameleonTextures;
    }
}

