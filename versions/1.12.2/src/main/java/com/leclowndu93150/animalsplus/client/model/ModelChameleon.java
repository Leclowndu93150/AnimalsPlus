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

public class ModelChameleon
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer head = new ModelRenderer((ModelBase)this, 0, 12);
    private ModelRenderer crest;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer tail;

    public ModelChameleon() {
        this.head.setRotationPoint(0.0f, 20.0f, -4.0f);
        this.head.addBox(-1.5f, -1.0f, -4.0f, 3, 3, 4, 0.0f);
        this.crest = new ModelRenderer((ModelBase)this, 14, 12);
        this.crest.setRotationPoint(0.0f, -3.0f, 0.0f);
        this.crest.addBox(-1.0f, -0.5f, -4.0f, 2, 3, 4, 0.0f);
        this.crest.rotateAngleX = 0.7853982f;
        this.tail = new ModelRenderer((ModelBase)this, 24, 0);
        this.tail.setRotationPoint(0.0f, 20.0f, 4.0f);
        this.tail.addBox(-1.0f, -4.0f, 0.0f, 2, 6, 6, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.body.addBox(-2.0f, -2.0f, -4.0f, 4, 4, 8, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 19);
        this.leg1.setRotationPoint(-2.0f, 21.0f, 2.0f);
        this.leg1.addBox(-4.0f, -0.5f, -0.5f, 4, 1, 1, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 19);
        this.leg2.mirror = true;
        this.leg2.setRotationPoint(2.0f, 21.0f, 2.0f);
        this.leg2.addBox(0.0f, -0.5f, -0.5f, 4, 1, 1, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 19);
        this.leg4.mirror = true;
        this.leg4.setRotationPoint(2.0f, 21.0f, -2.0f);
        this.leg4.addBox(0.0f, -0.5f, -0.5f, 4, 1, 1, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 19);
        this.leg3.setRotationPoint(-2.0f, 21.0f, -2.0f);
        this.leg3.addBox(-4.0f, -0.5f, -0.5f, 4, 1, 1, 0.0f);
        this.head.addChild(this.crest);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = f4 / 57.295776f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.leg1.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 1.2f * f1 + 0.2617994f;
        this.leg1.rotateAngleZ = -0.7853982f;
        this.leg2.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 1.2f * f1 - 0.2617994f;
        this.leg2.rotateAngleZ = 0.7853982f;
        this.leg3.rotateAngleY = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.2f * f1 - 0.2617994f;
        this.leg3.rotateAngleZ = -0.7853982f;
        this.leg4.rotateAngleY = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.2f * f1 + 0.2617994f;
        this.leg4.rotateAngleZ = 0.7853982f;
        this.tail.rotateAngleY = MathHelper.cos((float)(f * 0.4f)) * 1.0f * f1;
        this.tail.rotateAngleZ = MathHelper.cos((float)(f * 0.4f)) * 1.0f * f1;
    }
}

