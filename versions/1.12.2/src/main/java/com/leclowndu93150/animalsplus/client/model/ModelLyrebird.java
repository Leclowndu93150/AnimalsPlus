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

public class ModelLyrebird
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer head;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;
    private ModelRenderer tail;
    private ModelRenderer beak;

    public ModelLyrebird() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.setRotationPoint(0.0f, 16.5f, -3.0f);
        this.head.addBox(-1.0f, -2.0f, -2.0f, 2, 3, 2, 0.0f);
        this.wing1 = new ModelRenderer((ModelBase)this, 0, 10);
        this.wing1.setRotationPoint(-1.5f, 16.0f, -3.0f);
        this.wing1.addBox(-1.0f, 0.0f, 0.0f, 1, 4, 6, 0.0f);
        this.wing2 = new ModelRenderer((ModelBase)this, 0, 10);
        this.wing2.setRotationPoint(1.5f, 16.0f, -3.0f);
        this.wing2.addBox(0.0f, 0.0f, 0.0f, 1, 4, 6, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 2, 0);
        this.body.setRotationPoint(0.0f, 18.0f, 0.0f);
        this.body.addBox(-1.5f, -2.0f, -3.0f, 3, 4, 6, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 14, 10);
        this.leg1.setRotationPoint(-1.0f, 20.0f, -1.0f);
        this.leg1.addBox(-0.5f, 0.0f, 0.0f, 1, 4, 2, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 14, 10);
        this.leg2.setRotationPoint(1.0f, 20.0f, -1.0f);
        this.leg2.addBox(-0.5f, 0.0f, 0.0f, 1, 4, 2, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 20, 0);
        this.tail.setRotationPoint(0.0f, 16.0f, 2.0f);
        this.tail.addBox(-0.5f, -6.0f, -1.0f, 1, 8, 3, 0.0f);
        this.beak = new ModelRenderer((ModelBase)this, 8, 10);
        this.beak.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.beak.addBox(-0.5f, -0.5f, -4.0f, 1, 1, 2, 0.0f);
        this.head.addChild(this.beak);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = f4 / 57.295776f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.leg1.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.leg2.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
        this.wing2.rotateAngleX = this.wing1.rotateAngleX = MathHelper.cos((float)(f * 0.662f)) * 0.4f * f1 + 0.17453292f;
        this.wing1.rotateAngleY = -MathHelper.abs((float)MathHelper.cos((float)(f * 0.6662f))) * 1.0f * f1;
        this.wing2.rotateAngleY = -this.wing1.rotateAngleY;
        this.wing1.rotateAngleZ = MathHelper.abs((float)MathHelper.cos((float)(f * 0.6662f))) * 1.0f * f1;
        this.wing2.rotateAngleZ = -this.wing1.rotateAngleZ;
        this.tail.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1 - 0.34906584f;
    }
}

