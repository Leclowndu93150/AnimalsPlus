/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.model;

import com.leclowndu93150.animalsplus.entity.passive.EntityPenguin;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelPenguin
extends ModelBase {
    private ModelRenderer head = new ModelRenderer((ModelBase)this, 0, 0);
    private ModelRenderer body;
    private ModelRenderer foot1;
    private ModelRenderer foot2;
    private ModelRenderer wing1;
    private ModelRenderer wing2;

    public ModelPenguin() {
        this.head.addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        this.head.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.head.setTextureOffset(24, 0).addBox(-1.0f, 0.0f, -6.0f, 2, 2, 3);
        this.body = new ModelRenderer((ModelBase)this, 0, 12);
        this.body.addBox(-3.0f, -3.0f, -3.0f, 6, 9, 6);
        this.body.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.foot1 = new ModelRenderer((ModelBase)this, 24, 15);
        this.foot1.addBox(-1.0f, 0.0f, -1.5f, 2, 1, 3);
        this.foot1.setRotationPoint(-1.5f, 23.0f, 0.0f);
        this.foot2 = new ModelRenderer((ModelBase)this, 24, 15);
        this.foot2.addBox(-1.0f, 0.0f, -1.5f, 2, 1, 3);
        this.foot2.setRotationPoint(1.5f, 23.0f, 0.0f);
        this.wing1 = new ModelRenderer((ModelBase)this, 24, 5);
        this.wing1.addBox(-1.0f, 0.0f, -2.0f, 1, 6, 4);
        this.wing1.setRotationPoint(-3.0f, 14.0f, 0.0f);
        this.wing2 = new ModelRenderer((ModelBase)this, 24, 5);
        this.wing2.addBox(0.0f, 0.0f, -2.0f, 1, 6, 4);
        this.wing2.setRotationPoint(3.0f, 14.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.rotateAngleX = f4 / 57.295776f;
        this.head.rotateAngleY = f3 / 57.295776f;
        this.head.render(f5);
        this.body.render(f5);
        this.foot1.render(f5);
        this.foot2.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
    }

    public void setLivingAnimations(EntityLivingBase entity, float f, float f1, float f2) {
        EntityPenguin penguin = (EntityPenguin)entity;
        if (penguin.isGliding()) {
            this.head.setRotationPoint(0.0f, 21.0f, -6.0f);
            this.body.setRotationPoint(0.0f, 21.0f, 0.0f);
            this.body.rotateAngleX = 1.5707963f;
            this.wing2.rotateAngleX = 1.5707963f;
            this.wing1.rotateAngleX = 1.5707963f;
            this.wing1.setRotationPoint(-3.0f, 21.0f, -3.0f);
            this.wing2.setRotationPoint(3.0f, 21.0f, -3.0f);
            this.foot2.rotateAngleX = 1.5707963f;
            this.foot1.rotateAngleX = 1.5707963f;
            this.foot2.rotateAngleY = 0.0f;
            this.foot1.rotateAngleY = 0.0f;
            this.foot1.rotateAngleZ = 0.2443461f;
            this.foot2.rotateAngleZ = -0.2443461f;
            this.foot1.setRotationPoint(-1.5f, 21.0f, 6.0f);
            this.foot2.setRotationPoint(1.5f, 21.0f, 6.0f);
        } else {
            this.head.setRotationPoint(0.0f, 11.0f, 0.0f);
            this.body.setRotationPoint(0.0f, 17.0f, 0.0f);
            this.body.rotateAngleX = 0.0f;
            this.wing2.rotateAngleX = 0.0f;
            this.wing1.rotateAngleX = 0.0f;
            this.wing1.setRotationPoint(-3.0f, 14.0f, 0.0f);
            this.wing2.setRotationPoint(3.0f, 14.0f, 0.0f);
            this.foot2.rotateAngleX = 0.0f;
            this.foot1.rotateAngleX = 0.0f;
            this.foot2.rotateAngleZ = 0.0f;
            this.foot1.rotateAngleZ = 0.0f;
            this.foot1.rotateAngleY = 0.2443461f;
            this.foot2.rotateAngleY = -0.2443461f;
            this.foot1.setRotationPoint(-1.5f, 23.0f, 0.0f);
            this.foot2.setRotationPoint(1.5f, 23.0f, 0.0f);
        }
    }
}

