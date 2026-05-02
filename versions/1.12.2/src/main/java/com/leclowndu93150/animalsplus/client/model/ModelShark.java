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

public class ModelShark
extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer beck;
    public ModelRenderer backFin;
    public ModelRenderer fin1;
    public ModelRenderer fin2;
    public ModelRenderer tail;
    public ModelRenderer tailFin1;
    public ModelRenderer tailFin2;

    public ModelShark() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.body.addBox(-3.0f, -4.0f, -9.0f, 6, 8, 18, 0.0f);
        this.beck = new ModelRenderer((ModelBase)this, 0, 39);
        this.beck.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.beck.addBox(-2.0f, 0.0f, -6.0f, 4, 2, 6, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 0, 26);
        this.head.setRotationPoint(0.0f, 21.0f, -9.0f);
        this.head.addBox(-2.5f, -5.0f, -8.0f, 5, 5, 8, 0.0f);
        this.head.addChild(this.beck);
        this.backFin = new ModelRenderer((ModelBase)this, 26, 26);
        this.backFin.setRotationPoint(0.0f, 16.0f, -2.0f);
        this.backFin.addBox(-0.5f, -6.0f, 0.0f, 1, 6, 4, 0.0f);
        this.fin1 = new ModelRenderer((ModelBase)this, 22, 38);
        this.fin1.setRotationPoint(-3.0f, 23.0f, -4.0f);
        this.fin1.addBox(-8.0f, 0.0f, 0.0f, 8, 1, 4, 0.0f);
        this.fin2 = new ModelRenderer((ModelBase)this, 22, 38);
        this.fin2.setRotationPoint(3.0f, 23.0f, -4.0f);
        this.fin2.addBox(0.0f, 0.0f, 0.0f, 8, 1, 4, 0.0f);
        this.fin2.mirror = true;
        this.tail = new ModelRenderer((ModelBase)this, 30, 0);
        this.tail.setRotationPoint(0.0f, 20.0f, 9.0f);
        this.tail.addBox(-2.0f, -3.0f, 0.0f, 4, 6, 10, 0.0f);
        this.tailFin1 = new ModelRenderer((ModelBase)this, 36, 26);
        this.tailFin1.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.tailFin1.addBox(-0.5f, -8.0f, -2.0f, 1, 8, 4, 0.0f);
        this.tailFin2 = new ModelRenderer((ModelBase)this, 46, 26);
        this.tailFin2.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.tailFin2.addBox(-0.5f, 0.0f, -2.0f, 1, 7, 4, 0.0f);
        this.tail.addChild(this.tailFin1);
        this.tail.addChild(this.tailFin2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.head.render(f5);
        this.backFin.render(f5);
        this.fin1.render(f5);
        this.fin2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.rotateAngleY = 0.0f;
        this.beck.rotateAngleX = MathHelper.abs((float)(MathHelper.cos((float)(f * 0.4f)) * 0.6f * f1));
        this.backFin.rotateAngleX = -0.5235988f;
        float f6 = 0.7853982f;
        float f7 = 0.5235988f;
        this.fin1.rotateAngleY = f6;
        this.fin1.rotateAngleZ = -f7;
        this.fin2.rotateAngleY = -f6;
        this.fin2.rotateAngleZ = f7;
        this.tail.rotateAngleY = MathHelper.cos((float)(f * 0.6f)) * 0.6f * f1;
        this.tailFin2.rotateAngleY = this.tailFin1.rotateAngleY = MathHelper.cos((float)(f * 0.6f)) * 0.6f * f1;
        this.tailFin1.rotateAngleX = -0.7853982f;
        this.tailFin2.rotateAngleX = 0.7853982f;
    }
}

