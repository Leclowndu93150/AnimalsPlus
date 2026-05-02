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

import com.leclowndu93150.animalsplus.client.model.ModelButterfly;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderInsect;
import com.leclowndu93150.animalsplus.entity.ambient.EntityDragonfly;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderDragonfly
extends RenderInsect<EntityDragonfly> {
    private static final ResourceLocation dragonflyTextures = new ResourceLocation("animalsplus", "textures/entity/dragonfly.png");

    public RenderDragonfly(RenderManager renderManager) {
        super(renderManager, new ModelButterfly(), 0.2f);
    }

    protected ResourceLocation getEntityTexture(EntityDragonfly dragonfly) {
        return dragonflyTextures;
    }
}

