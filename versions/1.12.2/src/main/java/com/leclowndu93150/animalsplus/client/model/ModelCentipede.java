/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelCentipede
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer legs;

    public ModelCentipede() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-1.0f, -6.0f, 0.0f, 2, 12, 1);
        this.body.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.legs = new ModelRenderer((ModelBase)this, 6, 0);
        this.legs.addBox(-3.0f, -8.0f, 0.0f, 6, 14, 0);
        this.legs.setRotationPoint(0.0f, 24.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float f6;
        this.body.rotateAngleX = f6 = 1.5707964f;
        this.legs.rotateAngleX = f6;
        this.body.render(f5);
        this.legs.render(f5);
    }
}

