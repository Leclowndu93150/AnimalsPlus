/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelChicken
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.entity.passive.EntityDuck;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderDuck
extends RenderLiving<EntityDuck> {
    private static final ResourceLocation duckTextures = new ResourceLocation("animalsplus", "textures/entity/duck.png");

    public RenderDuck(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelChicken(), 0.3f);
    }

    protected void preRenderCallback(EntityDuck duck, float f) {
        GL11.glScalef((float)0.8f, (float)0.8f, (float)0.8f);
    }

    protected ResourceLocation getEntityTexture(EntityDuck entity) {
        return duckTextures;
    }

    protected float handleRotationFloat(EntityDuck duck, float f) {
        float f1 = duck.oFlap + (duck.wingRotation - duck.oFlap) * f;
        float f2 = duck.oFlapSpeed + (duck.destPos - duck.oFlapSpeed) * f;
        return (MathHelper.sin((float)f1) + 1.0f) * f2;
    }
}

