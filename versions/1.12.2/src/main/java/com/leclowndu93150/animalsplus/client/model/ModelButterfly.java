/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelButterfly
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer wing1;
    private ModelRenderer wing2;

    public ModelButterfly() {
        this.textureWidth = 32;
        this.textureHeight = 16;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-0.5f, -0.5f, -3.0f, 1, 1, 6);
        this.body.setRotationPoint(0.0f, 23.5f, 0.0f);
        this.wing1 = new ModelRenderer((ModelBase)this, 0, 7);
        this.wing1.addBox(-4.0f, 0.0f, -4.0f, 4, 1, 8);
        this.wing1.setRotationPoint(-0.5f, 23.0f, 0.0f);
        this.wing2 = new ModelRenderer((ModelBase)this, 0, 7);
        this.wing2.mirror = true;
        this.wing2.addBox(0.0f, 0.0f, -4.0f, 4, 1, 8);
        this.wing2.setRotationPoint(0.5f, 23.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body.rotateAngleX = 0.0f;
        this.wing1.rotateAngleZ = MathHelper.cos((float)(f2 + (float)Math.PI));
        this.wing2.rotateAngleZ = MathHelper.cos((float)f2);
    }
}

