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

import com.leclowndu93150.animalsplus.client.model.ModelCentipede;
import com.leclowndu93150.animalsplus.client.renderer.entity.RenderInsect;
import com.leclowndu93150.animalsplus.entity.ambient.EntityCentipede;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderCentipede
extends RenderInsect<EntityCentipede> {
    private static final ResourceLocation centipedeTextures = new ResourceLocation("animalsplus", "textures/entity/centipede.png");

    public RenderCentipede(RenderManager renderManager) {
        super(renderManager, new ModelCentipede(), 0.0f);
    }

    protected ResourceLocation getEntityTexture(EntityCentipede centipede) {
        return centipedeTextures;
    }
}

