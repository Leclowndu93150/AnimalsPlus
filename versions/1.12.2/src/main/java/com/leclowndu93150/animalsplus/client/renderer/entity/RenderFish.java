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

import com.leclowndu93150.animalsplus.client.model.ModelFish;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderSwimming;
import com.leclowndu93150.animalsplus.entity.water.EntityFish;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderFish<T extends EntityFish>
extends RenderSwimming<T> {
    private static final ResourceLocation codTextures = new ResourceLocation("animalsplus", "textures/entity/fish/cod.png");
    private static final ResourceLocation salmonTextures = new ResourceLocation("animalsplus", "textures/entity/fish/salmon.png");
    private static final ResourceLocation perchTextures = new ResourceLocation("animalsplus", "textures/entity/fish/perch.png");

    public RenderFish(RenderManager renderManager) {
        super(renderManager, new ModelFish(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(T entity) {
        switch (((EntityFish)((Object)entity)).getFishType()) {
            default: {
                return codTextures;
            }
            case 1: {
                return salmonTextures;
            }
            case 2: 
        }
        return perchTextures;
    }
}

