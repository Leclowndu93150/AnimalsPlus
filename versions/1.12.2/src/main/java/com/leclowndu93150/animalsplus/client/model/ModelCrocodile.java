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

public class ModelCrocodile
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer jawUpper;
    private ModelRenderer jawLower;
    private ModelRenderer teeth;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer tail1;
    private ModelRenderer tail2;

    public ModelCrocodile() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.body.addBox(-5.0f, -10.0f, -2.0f, 10, 20, 5, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 30, 0);
        this.head.setRotationPoint(0.0f, 20.0f, -10.0f);
        this.head.addBox(-3.0f, -3.0f, -6.0f, 6, 5, 6, 0.0f);
        this.jawUpper = new ModelRenderer((ModelBase)this, 40, 11);
        this.jawUpper.setRotationPoint(0.0f, -1.0f, -6.0f);
        this.jawUpper.addBox(-2.0f, -1.0f, -8.0f, 4, 2, 8, 0.0f);
        this.jawLower = new ModelRenderer((ModelBase)this, 38, 21);
        this.jawLower.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.jawLower.addBox(-2.5f, 0.0f, -8.0f, 5, 2, 8, 0.0f);
        this.teeth = new ModelRenderer((ModelBase)this, 20, 25);
        this.teeth.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.teeth.addBox(-2.5f, -1.0f, -8.0f, 5, 1, 8, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 25);
        this.leg1.setRotationPoint(-5.0f, 20.0f, 6.0f);
        this.leg1.addBox(-2.0f, 0.0f, -2.0f, 2, 8, 4, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 25);
        this.leg2.mirror = true;
        this.leg2.setRotationPoint(5.0f, 20.0f, 6.0f);
        this.leg2.addBox(0.0f, 0.0f, -2.0f, 2, 8, 4, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 25);
        this.leg3.setRotationPoint(-5.0f, 20.0f, -6.0f);
        this.leg3.addBox(-2.0f, 0.0f, -2.0f, 2, 8, 4, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 25);
        this.leg4.mirror = true;
        this.leg4.setRotationPoint(5.0f, 20.0f, -6.0f);
        this.leg4.addBox(0.0f, 0.0f, -2.0f, 2, 8, 4, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 0, 41);
        this.tail1.setRotationPoint(0.0f, 20.0f, 10.0f);
        this.tail1.addBox(-3.0f, -3.0f, 0.0f, 6, 5, 12, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 30, 35);
        this.tail2.setRotationPoint(0.0f, 0.0f, 12.0f);
        this.tail2.addBox(-1.5f, -2.0f, 0.0f, 3, 4, 14, 0.0f);
        this.head.addChild(this.jawUpper);
        this.head.addChild(this.jawLower);
        this.jawLower.addChild(this.teeth);
        this.tail1.addChild(this.tail2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.head.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail1.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = f4 / 57.295776f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.jawUpper.rotateAngleX = -MathHelper.abs((float)(MathHelper.cos((float)(f * 0.4f)) * 0.6f * f1));
        this.jawLower.rotateAngleX = -this.jawUpper.rotateAngleX;
        this.body.rotateAngleX = 1.5707964f;
        this.leg1.rotateAngleX = MathHelper.cos((float)(f * 0.6f)) * 1.2f * f1 + 0.22439948f;
        this.leg1.rotateAngleZ = 1.0471976f;
        this.leg2.rotateAngleX = MathHelper.cos((float)(f * 0.6f + (float)Math.PI)) * 1.2f * f1 + 0.22439948f;
        this.leg2.rotateAngleZ = -1.0471976f;
        this.leg3.rotateAngleX = MathHelper.cos((float)(f * 0.6f + (float)Math.PI)) * 1.2f * f1 - 0.22439948f;
        this.leg3.rotateAngleZ = 1.0471976f;
        this.leg4.rotateAngleX = MathHelper.cos((float)(f * 0.6f)) * 1.2f * f1 - 0.22439948f;
        this.leg4.rotateAngleZ = -1.0471976f;
        this.tail1.rotateAngleY = MathHelper.cos((float)(f * 0.4f)) * 0.8f * f1;
        this.tail2.rotateAngleY = this.tail1.rotateAngleY * 0.6f;
    }
}

