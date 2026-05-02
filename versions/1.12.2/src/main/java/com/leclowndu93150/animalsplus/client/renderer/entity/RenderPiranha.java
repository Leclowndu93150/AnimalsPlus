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

import com.leclowndu93150.animalsplus.client.model.ModelPiranha;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderSwimming;
import com.leclowndu93150.animalsplus.entity.water.EntityPiranha;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderPiranha
extends RenderSwimming<EntityPiranha> {
    private static final ResourceLocation piranhaTextures = new ResourceLocation("animalsplus", "textures/entity/piranha.png");

    public RenderPiranha(RenderManager renderManager) {
        super(renderManager, new ModelPiranha(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(EntityPiranha entity) {
        return piranhaTextures;
    }
}

