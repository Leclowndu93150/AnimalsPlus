/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderLiving
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.util.ResourceLocation
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 *  org.lwjgl.opengl.GL11
 */
package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelPenguin;
import com.leclowndu93150.animalsplus.entity.passive.EntityPenguin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderPenguin
extends RenderLiving<EntityPenguin> {
    private static final ResourceLocation penguinTextures = new ResourceLocation("animalsplus", "textures/entity/penguin.png");

    public RenderPenguin(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelPenguin(), 0.3f);
    }

    protected void applyRotations(EntityPenguin penguin, float f, float f1, float f2) {
        super.applyRotations(penguin, f, f1, f2);
        if ((double)penguin.limbSwingAmount >= 0.01) {
            float f3 = 4.0f;
            float f4 = penguin.limbSwing - penguin.limbSwingAmount * (1.0f - f2) + 6.0f;
            float f5 = (Math.abs(f4 % f3 - f3 * 0.5f) - f3 * 0.25f) / (f3 * 0.25f);
            GL11.glRotatef((float)(10.0f * f5), (float)0.0f, (float)0.0f, (float)1.0f);
        }
    }

    protected ResourceLocation getEntityTexture(EntityPenguin penguin) {
        return penguinTextures;
    }
}

