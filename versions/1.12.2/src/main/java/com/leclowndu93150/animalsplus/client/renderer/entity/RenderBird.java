/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelBird;
import com.leclowndu93150.animalsplus.entity.passive.EntityBird;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderBird
extends RenderLiving<EntityBird> {
    private static final ResourceLocation jayTextures = new ResourceLocation("animalsplus", "textures/entity/bird/jay.png");
    private static final ResourceLocation cardinalTextures = new ResourceLocation("animalsplus", "textures/entity/bird/cardinal.png");
    private static final ResourceLocation sparrowTextures = new ResourceLocation("animalsplus", "textures/entity/bird/sparrow.png");
    private static final ResourceLocation parrotTextures = new ResourceLocation("animalsplus", "textures/entity/bird/parrot.png");
    private static final ResourceLocation chickadeeTextures = new ResourceLocation("animalsplus", "textures/entity/bird/chickadee.png");
    private static final ResourceLocation crowTextures = new ResourceLocation("animalsplus", "textures/entity/bird/crow.png");

    public RenderBird(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelBird(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(EntityBird bird) {
        switch (bird.getBirdType()) {
            default: {
                return jayTextures;
            }
            case 1: {
                return cardinalTextures;
            }
            case 2: {
                return sparrowTextures;
            }
            case 3: {
                return parrotTextures;
            }
            case 4: {
                return chickadeeTextures;
            }
            case 5: 
        }
        return crowTextures;
    }

    protected float handleRotationFloat(EntityBird bird, float f) {
        float f1 = bird.prevWingRotation + (bird.wingRotation - bird.prevWingRotation) * f;
        float f2 = bird.prevFlapSpeed + (bird.flapSpeed - bird.prevFlapSpeed) * f;
        return (MathHelper.sin((float)f1) + 1.0f) * f2;
    }
}

