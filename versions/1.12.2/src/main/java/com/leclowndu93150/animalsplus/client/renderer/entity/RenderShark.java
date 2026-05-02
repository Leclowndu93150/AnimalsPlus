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

import com.leclowndu93150.animalsplus.client.model.ModelShark;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderSwimming;
import com.leclowndu93150.animalsplus.entity.water.EntityShark;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderShark
extends RenderSwimming<EntityShark> {
    private static final ResourceLocation sharkTextures = new ResourceLocation("animalsplus", "textures/entity/shark.png");

    public RenderShark(RenderManager renderManager) {
        super(renderManager, new ModelShark(), 0.3f);
    }

    protected void preRenderCallback(EntityShark shark, float f) {
        GL11.glScalef((float)1.5f, (float)1.5f, (float)1.5f);
    }

    protected ResourceLocation getEntityTexture(EntityShark shark) {
        return sharkTextures;
    }
}

