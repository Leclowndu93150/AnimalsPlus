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
public class ModelLizard
extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer body;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer tail;

    public ModelLizard() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.head = new ModelRenderer((ModelBase)this, 0, 10);
        this.head.setRotationPoint(0.0f, 23.0f, -4.0f);
        this.head.addBox(-1.5f, -1.0f, -3.0f, 3, 2, 3, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.body.addBox(-1.5f, -1.0f, -4.0f, 3, 2, 8, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 9, 10);
        this.leg1.setRotationPoint(-1.5f, 23.0f, 2.5f);
        this.leg1.addBox(-3.0f, -0.5f, -0.5f, 3, 1, 1, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 9, 10);
        this.leg2.setRotationPoint(1.5f, 23.0f, 2.5f);
        this.leg2.addBox(0.0f, -0.5f, -0.5f, 3, 1, 1, 0.0f);
        this.leg2.mirror = true;
        this.leg3 = new ModelRenderer((ModelBase)this, 9, 10);
        this.leg3.setRotationPoint(-1.5f, 23.0f, -2.5f);
        this.leg3.addBox(-3.0f, -0.5f, -0.5f, 3, 1, 1, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 9, 10);
        this.leg4.setRotationPoint(1.5f, 23.0f, -2.5f);
        this.leg4.addBox(0.0f, -0.5f, -0.5f, 3, 1, 1, 0.0f);
        this.leg4.mirror = true;
        this.tail = new ModelRenderer((ModelBase)this, 0, 15);
        this.tail.setRotationPoint(0.0f, 23.5f, 4.0f);
        this.tail.addBox(-1.0f, -0.5f, 0.0f, 2, 1, 8, 0.0f);
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
        float f6 = 0.2617994f;
        this.leg1.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 1.8f * f1 + f6;
        this.leg1.rotateAngleZ = -f6;
        this.leg2.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 1.8f * f1 - f6;
        this.leg2.rotateAngleZ = f6;
        this.leg3.rotateAngleY = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.8f * f1 - f6;
        this.leg3.rotateAngleZ = -f6;
        this.leg4.rotateAngleY = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.8f * f1 + f6;
        this.leg4.rotateAngleZ = f6;
        this.tail.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 1.8f * f1;
    }
}

