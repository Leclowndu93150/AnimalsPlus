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
public class ModelCrab
extends ModelBase {
    public ModelRenderer body = new ModelRenderer((ModelBase)this, 0, 0);
    public ModelRenderer top;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer leg5;
    public ModelRenderer leg6;
    public ModelRenderer leg7;
    public ModelRenderer leg8;
    public ModelRenderer arm1;
    public ModelRenderer arm2;
    public ModelRenderer clawBig1;
    public ModelRenderer clawBig2;
    public ModelRenderer claw1;
    public ModelRenderer claw2;

    public ModelCrab() {
        this.body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.body.addBox(-3.0f, 0.0f, -3.0f, 6, 2, 6, 0.0f);
        this.top = new ModelRenderer((ModelBase)this, 18, 0);
        this.top.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.top.addBox(-2.0f, -1.0f, -2.0f, 4, 1, 4, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg1.setRotationPoint(-1.0f, 22.0f, -1.0f);
        this.leg1.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg2.setRotationPoint(-1.0f, 22.0f, 1.0f);
        this.leg2.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg2.mirror = true;
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg3.setRotationPoint(0.0f, 22.0f, -1.0f);
        this.leg3.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg4.setRotationPoint(0.0f, 22.0f, 1.0f);
        this.leg4.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg4.mirror = true;
        this.leg5 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg5.setRotationPoint(0.0f, 22.0f, -1.0f);
        this.leg5.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg6 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg6.setRotationPoint(0.0f, 22.0f, 1.0f);
        this.leg6.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg6.mirror = true;
        this.leg7 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg7.setRotationPoint(1.0f, 22.0f, -1.0f);
        this.leg7.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg8 = new ModelRenderer((ModelBase)this, 0, 8);
        this.leg8.setRotationPoint(1.0f, 22.0f, 1.0f);
        this.leg8.addBox(-0.5f, 0.0f, -0.5f, 1, 5, 1, 0.0f);
        this.leg8.mirror = true;
        this.arm1 = new ModelRenderer((ModelBase)this, 4, 8);
        this.arm1.setRotationPoint(2.0f, 21.0f, -3.0f);
        this.arm1.addBox(0.0f, 0.0f, -1.0f, 2, 1, 1, 0.0f);
        this.arm2 = new ModelRenderer((ModelBase)this, 4, 8);
        this.arm2.setRotationPoint(2.0f, 21.0f, 3.0f);
        this.arm2.addBox(0.0f, 0.0f, 0.0f, 2, 1, 1, 0.0f);
        this.clawBig1 = new ModelRenderer((ModelBase)this, 10, 8);
        this.clawBig1.setRotationPoint(2.0f, 0.0f, 0.0f);
        this.clawBig1.addBox(0.0f, -1.0f, -2.0f, 3, 2, 2, 0.0f);
        this.clawBig2 = new ModelRenderer((ModelBase)this, 10, 8);
        this.clawBig2.setRotationPoint(2.0f, 0.0f, 0.0f);
        this.clawBig2.addBox(0.0f, -1.0f, 0.0f, 3, 2, 2, 0.0f);
        this.claw1 = new ModelRenderer((ModelBase)this, 4, 10);
        this.claw1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.claw1.addBox(0.0f, 0.0f, 0.0f, 2, 1, 1, 0.0f);
        this.claw2 = new ModelRenderer((ModelBase)this, 4, 10);
        this.claw2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.claw2.addBox(0.0f, 0.0f, -1.0f, 2, 1, 1, 0.0f);
        this.body.addChild(this.top);
        this.arm1.addChild(this.clawBig1);
        this.arm2.addChild(this.clawBig2);
        this.clawBig1.addChild(this.claw1);
        this.clawBig2.addChild(this.claw2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.leg5.render(f5);
        this.leg6.render(f5);
        this.leg7.render(f5);
        this.leg8.render(f5);
        this.arm1.render(f5);
        this.arm2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        float f6 = 1.151917f;
        this.leg1.rotateAngleX = -f6;
        this.leg2.rotateAngleX = f6;
        this.leg3.rotateAngleX = -f6;
        this.leg4.rotateAngleX = f6;
        this.leg5.rotateAngleX = -f6;
        this.leg6.rotateAngleX = f6;
        this.leg7.rotateAngleX = -f6;
        this.leg8.rotateAngleX = f6;
        float f7 = 0.3926991f;
        this.leg1.rotateAngleY = f7 * 1.5f;
        this.leg2.rotateAngleY = -f7 * 1.5f;
        this.leg3.rotateAngleY = f7 * 0.75f;
        this.leg4.rotateAngleY = -f7 * 0.75f;
        this.leg5.rotateAngleY = -f7 * 0.75f;
        this.leg6.rotateAngleY = f7 * 0.75f;
        this.leg7.rotateAngleY = -f7 * 1.5f;
        this.leg8.rotateAngleY = f7 * 1.5f;
        float f8 = -(MathHelper.cos((float)(f * 0.6662f + 0.0f)) * 0.4f) * f1;
        float f9 = -(MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 0.4f) * f1;
        float f10 = -(MathHelper.cos((float)(f * 0.6662f + 1.5707964f)) * 0.4f) * f1;
        float f11 = -(MathHelper.cos((float)(f * 0.6662f + 4.712389f)) * 0.4f) * f1;
        this.leg1.rotateAngleY += f8;
        this.leg2.rotateAngleY += -f8;
        this.leg3.rotateAngleY += f9;
        this.leg4.rotateAngleY += -f9;
        this.leg5.rotateAngleY += f10;
        this.leg6.rotateAngleY += -f10;
        this.leg7.rotateAngleY += f11;
        this.leg8.rotateAngleY += -f11;
        float f12 = Math.abs(MathHelper.sin((float)(f * 0.6662f + 0.0f)) * 0.4f) * f1;
        float f13 = Math.abs(MathHelper.sin((float)(f * 0.6662f + (float)Math.PI)) * 0.4f) * f1;
        float f14 = Math.abs(MathHelper.sin((float)(f * 0.6662f + 1.5707964f)) * 0.4f) * f1;
        float f15 = Math.abs(MathHelper.sin((float)(f * 0.6662f + 4.712389f)) * 0.4f) * f1;
        this.leg1.rotateAngleX += -f12;
        this.leg2.rotateAngleX += f12;
        this.leg3.rotateAngleX += -f13;
        this.leg4.rotateAngleX += f13;
        this.leg5.rotateAngleX += -f14;
        this.leg6.rotateAngleX += f14;
        this.leg7.rotateAngleX += -f15;
        this.leg8.rotateAngleX += f15;
        this.arm1.rotateAngleY = 0.31415927f + MathHelper.cos((float)(f * 0.6662f)) * 0.8f * f1;
        this.arm2.rotateAngleY = -this.arm1.rotateAngleY;
        this.claw1.rotateAngleY = -this.arm1.rotateAngleY * 1.5f;
        this.claw2.rotateAngleY = -this.arm2.rotateAngleY * 1.5f;
    }
}

