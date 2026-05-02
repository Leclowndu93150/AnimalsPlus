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

import com.leclowndu93150.animalsplus.client.model.ModelLizard;
import com.leclowndu93150.animalsplus.entity.passive.EntityLizard;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderLizard
extends RenderLiving<EntityLizard> {
    private static final ResourceLocation desertLizardTextures = new ResourceLocation("animalsplus", "textures/entity/lizard/desert.png");
    private static final ResourceLocation brownLizardTextures = new ResourceLocation("animalsplus", "textures/entity/lizard/brown.png");
    private static final ResourceLocation fenceLizardTextures = new ResourceLocation("animalsplus", "textures/entity/lizard/fence.png");

    public RenderLizard(RenderManager renderManager) {
        super(renderManager, (ModelBase)new ModelLizard(), 0.3f);
    }

    protected ResourceLocation getEntityTexture(EntityLizard lizard) {
        switch (lizard.getLizardType()) {
            default: {
                return desertLizardTextures;
            }
            case 1: {
                return brownLizardTextures;
            }
            case 2: 
        }
        return fenceLizardTextures;
    }
}

