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
public class ModelMantaRay
extends ModelBase {
    private ModelRenderer body1 = new ModelRenderer((ModelBase)this, 0, 0);
    private ModelRenderer body2;
    private ModelRenderer lobe1;
    private ModelRenderer lobe2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;
    private ModelRenderer outerWing1;
    private ModelRenderer outerWing2;
    private ModelRenderer tail;

    public ModelMantaRay() {
        this.body1.addBox(-5.0f, -6.0f, -1.0f, 10, 12, 3);
        this.body1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 22, 16);
        this.body2.addBox(-3.0f, 0.0f, 0.0f, 6, 1, 4);
        this.body2.setRotationPoint(0.0f, 22.0f, 6.0f);
        this.lobe1 = new ModelRenderer((ModelBase)this, 22, 21);
        this.lobe1.addBox(-2.0f, 0.0f, -4.0f, 2, 1, 4);
        this.lobe1.setRotationPoint(-3.0f, 23.0f, -6.0f);
        this.lobe2 = new ModelRenderer((ModelBase)this, 22, 21);
        this.lobe2.mirror = true;
        this.lobe2.addBox(0.0f, 0.0f, -4.0f, 2, 1, 4);
        this.lobe2.setRotationPoint(3.0f, 23.0f, -6.0f);
        this.wing1 = new ModelRenderer((ModelBase)this, 26, 0);
        this.wing1.addBox(-8.0f, 0.0f, -4.0f, 8, 1, 8);
        this.wing1.setRotationPoint(-5.0f, 21.0f, 0.0f);
        this.wing2 = new ModelRenderer((ModelBase)this, 26, 0);
        this.wing2.mirror = true;
        this.wing2.addBox(0.0f, 0.0f, -4.0f, 8, 1, 8);
        this.wing2.setRotationPoint(5.0f, 21.0f, 0.0f);
        this.outerWing1 = new ModelRenderer((ModelBase)this, 26, 9);
        this.outerWing1.addBox(-6.0f, -1.0f, -3.0f, 6, 1, 6);
        this.outerWing1.setRotationPoint(-8.0f, 1.0f, 0.0f);
        this.outerWing2 = new ModelRenderer((ModelBase)this, 26, 9);
        this.outerWing2.mirror = true;
        this.outerWing2.addBox(0.0f, -1.0f, -3.0f, 6, 1, 6);
        this.outerWing2.setRotationPoint(8.0f, 1.0f, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 0, 15);
        this.tail.addBox(-0.5f, 0.0f, 0.0f, 1, 1, 10);
        this.tail.setRotationPoint(0.0f, 22.0f, 10.0f);
        this.wing1.addChild(this.outerWing1);
        this.wing2.addChild(this.outerWing2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body1.render(f5);
        this.body2.render(f5);
        this.lobe1.render(f5);
        this.lobe2.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body1.rotateAngleX = 1.5707964f;
        this.wing1.rotateAngleZ = MathHelper.cos((float)(f2 * 0.1f)) * 0.5f;
        this.wing2.rotateAngleZ = -this.wing1.rotateAngleZ;
        this.outerWing1.rotateAngleZ = this.wing1.rotateAngleZ * 0.8f;
        this.outerWing2.rotateAngleZ = this.wing2.rotateAngleZ * 0.8f;
        this.tail.rotateAngleY = MathHelper.cos((float)(f * 0.2f)) * 1.2f * f1;
    }
}

