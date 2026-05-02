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

import com.leclowndu93150.animalsplus.client.model.ModelMantaRay;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderSwimming;
import com.leclowndu93150.animalsplus.entity.water.EntityMantaRay;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderMantaRay
extends RenderSwimming<EntityMantaRay> {
    private static final ResourceLocation mantaRayTextures = new ResourceLocation("animalsplus", "textures/entity/manta_ray.png");

    public RenderMantaRay(RenderManager renderManager) {
        super(renderManager, new ModelMantaRay(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(EntityMantaRay mantaRay) {
        return mantaRayTextures;
    }
}

