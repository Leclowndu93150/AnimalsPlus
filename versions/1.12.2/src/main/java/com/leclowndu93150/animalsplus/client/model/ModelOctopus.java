/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package com.leclowndu93150.animalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelOctopus
extends ModelBase {
    ModelRenderer body;
    ModelRenderer[] tentacles = new ModelRenderer[8];

    public ModelOctopus() {
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-6.0f, -4.0f, -6.0f, 12, 12, 12);
        this.body.setRotationPoint(0.0f, 8.0f, 0.0f);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i] = new ModelRenderer((ModelBase)this, 48, 0);
            double d0 = (double)i * Math.PI * 2.0 / (double)this.tentacles.length;
            float f = (float)Math.cos(d0) * 7.0f;
            float f1 = (float)Math.sin(d0) * 7.0f;
            this.tentacles[i].addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
            this.tentacles[i].setRotationPoint(f, 16.0f, f1);
            d0 = (double)i * Math.PI * -2.0 / (double)this.tentacles.length + 1.5707963267948966;
            this.tentacles[i].rotateAngleY = (float)d0;
        }
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        for (ModelRenderer modelrenderer : this.tentacles) {
            modelrenderer.rotateAngleX = p_78087_3_ * 1.0f + 0.2617994f;
        }
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.body.render(p_78088_7_);
        for (int i = 0; i < this.tentacles.length; ++i) {
            this.tentacles[i].render(p_78088_7_);
        }
    }
}

