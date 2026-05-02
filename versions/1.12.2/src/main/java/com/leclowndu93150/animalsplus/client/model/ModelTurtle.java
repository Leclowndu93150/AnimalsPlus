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
public class ModelTurtle
extends ModelBase {
    private ModelRenderer head = new ModelRenderer((ModelBase)this, 0, 19);
    private ModelRenderer body;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;

    public ModelTurtle() {
        this.head.addBox(-2.0f, -1.5f, -5.0f, 4, 3, 5);
        this.head.setRotationPoint(0.0f, 19.0f, -6.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-4.5f, -6.0f, -3.0f, 9, 12, 7);
        this.body.setRotationPoint(0.0f, 18.0f, 0.0f);
        this.body.setTextureOffset(32, 0).addBox(-5.0f, -6.5f, -1.0f, 10, 13, 2);
        this.leg1 = new ModelRenderer((ModelBase)this, 18, 19);
        this.leg1.addBox(-2.0f, 0.0f, -1.5f, 2, 5, 3);
        this.leg1.setRotationPoint(-4.5f, 19.0f, 4.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 18, 19);
        this.leg2.addBox(0.0f, 0.0f, -1.5f, 2, 5, 3);
        this.leg2.setRotationPoint(4.5f, 19.0f, 4.0f);
        this.leg2.mirror = true;
        this.leg3 = new ModelRenderer((ModelBase)this, 18, 19);
        this.leg3.addBox(-2.0f, 0.0f, -1.5f, 2, 5, 3);
        this.leg3.setRotationPoint(-4.5f, 19.0f, -4.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 18, 19);
        this.leg4.addBox(0.0f, 0.0f, -1.5f, 2, 5, 3);
        this.leg4.setRotationPoint(4.5f, 19.0f, -4.0f);
        this.leg4.mirror = true;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = f4 / 57.295776f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.body.rotateAngleX = 1.570796f;
        this.leg1.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.2f * f1;
        this.leg2.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.2f * f1;
        this.leg3.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.2f * f1;
        this.leg4.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.2f * f1;
    }
}

