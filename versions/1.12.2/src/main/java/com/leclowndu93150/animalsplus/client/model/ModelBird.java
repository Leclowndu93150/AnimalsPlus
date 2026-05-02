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
public class ModelBird
extends ModelBase {
    private ModelRenderer head = new ModelRenderer((ModelBase)this, 0, 10);
    private ModelRenderer body;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;
    private ModelRenderer tail;

    public ModelBird() {
        this.head.addBox(-1.5f, -3.0f, -2.0f, 3, 3, 3);
        this.head.setRotationPoint(0.0f, 18.0f, -2.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-2.0f, -2.0f, -3.0f, 4, 4, 6);
        this.body.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 12, 10);
        this.leg1.addBox(-1.0f, 0.0f, -2.0f, 2, 2, 2);
        this.leg1.setRotationPoint(-1.5f, 22.0f, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 12, 10);
        this.leg2.mirror = true;
        this.leg2.addBox(-1.0f, 0.0f, -2.0f, 2, 2, 2);
        this.leg2.setRotationPoint(1.5f, 22.0f, 0.0f);
        this.wing1 = new ModelRenderer((ModelBase)this, 20, 0);
        this.wing1.addBox(-1.0f, 0.0f, 0.0f, 1, 4, 6);
        this.wing1.setRotationPoint(-2.0f, 18.0f, -3.0f);
        this.wing2 = new ModelRenderer((ModelBase)this, 20, 0);
        this.wing2.addBox(0.0f, 0.0f, 0.0f, 1, 4, 6);
        this.wing2.setRotationPoint(2.0f, 18.0f, -3.0f);
        this.tail = new ModelRenderer((ModelBase)this, 16, 10);
        this.tail.addBox(-1.5f, 0.0f, 0.0f, 3, 1, 4);
        this.tail.setRotationPoint(0.0f, 18.0f, 3.0f);
        this.head.setTextureOffset(0, 16).addBox(-0.5f, -1.0f, -4.0f, 1, 1, 2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.head.rotateAngleX = f4 / 57.295776f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.leg1.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.leg2.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
        this.wing1.rotateAngleZ = f2;
        this.wing2.rotateAngleZ = -f2;
        this.tail.rotateAngleX = 0.7853982f;
    }
}

