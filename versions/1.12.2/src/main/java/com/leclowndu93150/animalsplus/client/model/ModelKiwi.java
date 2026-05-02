/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 */
package com.leclowndu93150.animalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelKiwi
extends ModelBase {
    public ModelRenderer kiwiHead;
    public ModelRenderer kiwiBeak;
    public ModelRenderer kiwiBody;
    public ModelRenderer kiwiRightLeg;
    public ModelRenderer kiwiLeftLeg;

    public ModelKiwi() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.kiwiBody = new ModelRenderer((ModelBase)this, 0, 0);
        this.kiwiBody.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.kiwiBody.addBox(-3.0f, -3.0f, -4.0f, 6, 5, 7, 0.0f);
        this.kiwiHead = new ModelRenderer((ModelBase)this, 0, 12);
        this.kiwiHead.setRotationPoint(0.0f, 17.0f, -3.0f);
        this.kiwiHead.addBox(-1.5f, -2.0f, -4.0f, 3, 4, 3, 0.0f);
        this.kiwiBeak = new ModelRenderer((ModelBase)this, 0, 19);
        this.kiwiBeak.setRotationPoint(0.0f, 0.0f, -4.0f);
        this.kiwiBeak.addBox(-0.5f, -0.5f, -5.0f, 1, 1, 5, 0.0f);
        this.kiwiHead.addChild(this.kiwiBeak);
        this.kiwiRightLeg = new ModelRenderer((ModelBase)this, 14, 12);
        this.kiwiRightLeg.setRotationPoint(-1.5f, 21.0f, 0.0f);
        this.kiwiRightLeg.addBox(-1.5f, 0.0f, -2.0f, 3, 3, 2, 0.0f);
        this.kiwiLeftLeg = new ModelRenderer((ModelBase)this, 14, 12);
        this.kiwiLeftLeg.setRotationPoint(1.5f, 21.0f, 0.0f);
        this.kiwiLeftLeg.addBox(-1.5f, 0.0f, -2.0f, 3, 3, 2, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float scale) {
        this.setRotationAngles(f, f1, f2, f3, f4, scale, entity);
        if (this.isChild) {
            float f5 = 2.0f;
            GlStateManager.pushMatrix();
            GlStateManager.scale((float)(1.0f / f5), (float)(1.0f / f5), (float)(1.0f / f5));
            GlStateManager.translate((float)0.0f, (float)(24.0f * scale), (float)0.0f);
            this.kiwiBody.render(scale);
            this.kiwiHead.render(scale);
            this.kiwiRightLeg.render(scale);
            this.kiwiLeftLeg.render(scale);
            GlStateManager.popMatrix();
        } else {
            this.kiwiBody.render(scale);
            this.kiwiHead.render(scale);
            this.kiwiRightLeg.render(scale);
            this.kiwiLeftLeg.render(scale);
        }
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.kiwiHead.rotateAngleX = f4 / 57.295776f;
        this.kiwiHead.rotateAngleY = f3 / 57.295776f;
        this.kiwiRightLeg.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.kiwiLeftLeg.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
    }
}

