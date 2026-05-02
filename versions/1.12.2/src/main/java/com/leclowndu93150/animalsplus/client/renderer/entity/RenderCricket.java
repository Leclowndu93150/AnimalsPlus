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

import com.leclowndu93150.animalsplus.client.model.ModelCricket;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderInsect;
import com.leclowndu93150.animalsplus.entity.ambient.EntityCricket;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderCricket
extends RenderInsect<EntityCricket> {
    private static final ResourceLocation cricketTextures = new ResourceLocation("animalsplus", "textures/entity/cricket.png");

    public RenderCricket(RenderManager renderManager) {
        super(renderManager, new ModelCricket(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(EntityCricket cricket) {
        return cricketTextures;
    }
}

