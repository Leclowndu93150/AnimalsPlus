/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 */
package com.leclowndu93150.animalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCamel
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer hump;
    public ModelRenderer neck;
    public ModelRenderer head;
    public ModelRenderer ear1;
    public ModelRenderer ear2;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer tail;

    public ModelCamel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 24, 0);
        this.body.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.body.addBox(-5.0f, -10.0f, -4.0f, 10, 20, 10, 0.0f);
        this.hump = new ModelRenderer((ModelBase)this, 24, 30);
        this.hump.setRotationPoint(0.0f, 0.0f, 1.0f);
        this.hump.addBox(-5.0f, -6.0f, -5.0f, 10, 6, 10, 0.0f);
        this.neck = new ModelRenderer((ModelBase)this, 6, 35);
        this.neck.setRotationPoint(0.0f, 8.0f, -9.5f);
        this.neck.addBox(-1.5f, -14.0f, -2.0f, 3, 14, 4, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 6, 20);
        this.head.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.head.addBox(-2.0f, -4.0f, -8.0f, 4, 5, 10, 0.0f);
        this.ear1 = new ModelRenderer((ModelBase)this, 28, 36);
        this.ear1.setRotationPoint(-1.0f, -3.5f, 0.0f);
        this.ear1.addBox(-1.0f, -2.0f, 0.0f, 1, 2, 2, 0.0f);
        this.ear2 = new ModelRenderer((ModelBase)this, 28, 36);
        this.ear2.setRotationPoint(1.0f, -3.5f, 0.0f);
        this.ear2.addBox(0.0f, -2.0f, 0.0f, 1, 2, 2, 0.0f);
        this.head.addChild(this.ear1);
        this.head.addChild(this.ear2);
        this.neck.addChild(this.head);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg1.setRotationPoint(-3.0f, 10.0f, 8.0f);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg2.setRotationPoint(3.0f, 10.0f, 8.0f);
        this.leg2.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg3.setRotationPoint(-3.0f, 10.0f, -8.0f);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 0);
        this.leg4.setRotationPoint(3.0f, 10.0f, -8.0f);
        this.leg4.addBox(-2.0f, 0.0f, -2.0f, 4, 14, 4, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 16, 0);
        this.tail.setRotationPoint(0.0f, 3.0f, 10.0f);
        this.tail.addBox(-1.0f, 0.0f, -1.0f, 2, 12, 2, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.hump.render(f5);
        this.neck.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.rotateAngleX = 1.5707964f;
        this.neck.rotateAngleX = 0.31415927f;
        this.head.rotateAngleX = -0.31415927f + f4 / 57.295776f;
        this.neck.rotateAngleY = f3 / 57.295776f;
        this.ear1.rotateAngleX = -0.31415927f;
        this.ear2.rotateAngleX = -0.31415927f;
        this.leg1.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.leg2.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
        this.leg3.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
        this.leg4.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.tail.rotateAngleX = 0.15707964f + Math.abs(MathHelper.cos((float)(f * 0.2f)) * 0.8f * f1);
    }
}

