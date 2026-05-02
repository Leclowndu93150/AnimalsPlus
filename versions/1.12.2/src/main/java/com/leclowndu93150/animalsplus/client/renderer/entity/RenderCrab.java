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

import com.leclowndu93150.animalsplus.client.model.ModelCrab;
import com.leclowndu93150.animalsplus.entity.passive.EntityCrab;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderCrab
extends RenderLiving<EntityCrab> {
    private static final ResourceLocation crabTextures = new ResourceLocation("animalsplus", "textures/entity/crab.png");

    public RenderCrab(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelCrab(), 0.25f);
    }

    protected ResourceLocation getEntityTexture(EntityCrab crab) {
        return crabTextures;
    }
}

