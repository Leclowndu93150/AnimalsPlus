/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelWhale;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderSwimming;
import com.leclowndu93150.animalsplus.entity.water.EntityWhale;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderWhale
extends RenderSwimming<EntityWhale> {
    private static final ResourceLocation blueWhaleTextures = new ResourceLocation("animalsplus", "textures/entity/whale/blue_whale.png");
    private static final ResourceLocation humpbackTextures = new ResourceLocation("animalsplus", "textures/entity/whale/humpback.png");

    public RenderWhale(RenderManager renderManager) {
        super(renderManager, new ModelWhale(), 3.2f);
    }

    protected void preRenderCallback(EntityWhale whale, float partialTickTime) {
        GL11.glScalef((float)8.0f, (float)8.0f, (float)8.0f);
    }

    protected ResourceLocation getEntityTexture(EntityWhale whale) {
        return whale.getWhaleType() == 1 ? blueWhaleTextures : humpbackTextures;
    }
}

