/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelLyrebird;
import com.leclowndu93150.animalsplus.entity.passive.EntityLyrebird;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderLyrebird
extends RenderLiving<EntityLyrebird> {
    private static final ResourceLocation lyrebirdTextures = new ResourceLocation("animalsplus", "textures/entity/lyrebird.png");

    public RenderLyrebird(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelLyrebird(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(EntityLyrebird lyrebird) {
        return lyrebirdTextures;
    }
}

