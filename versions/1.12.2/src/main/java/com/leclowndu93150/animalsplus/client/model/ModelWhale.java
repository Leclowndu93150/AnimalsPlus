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
public class ModelWhale
extends ModelBase {
    private ModelRenderer body1 = new ModelRenderer((ModelBase)this, 0, 0);
    private ModelRenderer body2;
    private ModelRenderer body3;
    private ModelRenderer fin1;
    private ModelRenderer fin2;
    private ModelRenderer fluke1;
    private ModelRenderer fluke2;

    public ModelWhale() {
        this.body1.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.body1.addBox(-3.5f, -3.0f, -8.0f, 7, 7, 14, 0.0f);
        this.body2 = new ModelRenderer((ModelBase)this, 36, 14);
        this.body2.setRotationPoint(0.0f, 0.0f, 6.0f);
        this.body2.addBox(-3.0f, -2.5f, 0.0f, 6, 6, 8, 0.0f);
        this.body3 = new ModelRenderer((ModelBase)this, 40, 4);
        this.body3.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.body3.addBox(-3.0f, -2.0f, 0.0f, 6, 4, 6, 0.0f);
        this.fin1 = new ModelRenderer((ModelBase)this, 28, 0);
        this.fin1.setRotationPoint(-3.5f, 22.0f, 2.0f);
        this.fin1.addBox(-6.0f, 0.0f, -1.5f, 6, 1, 3, 0.0f);
        this.fin2 = new ModelRenderer((ModelBase)this, 28, 0);
        this.fin2.setRotationPoint(3.5f, 22.0f, 2.0f);
        this.fin2.addBox(0.0f, 0.0f, -1.5f, 6, 1, 3, 0.0f);
        this.fluke1 = new ModelRenderer((ModelBase)this, 0, 21);
        this.fluke1.setRotationPoint(0.0f, -1.0f, 6.0f);
        this.fluke1.addBox(-4.0f, 0.0f, 0.0f, 4, 1, 8, 0.0f);
        this.fluke2 = new ModelRenderer((ModelBase)this, 0, 21);
        this.fluke2.setRotationPoint(0.0f, -1.0f, 6.0f);
        this.fluke2.addBox(0.0f, 0.0f, 0.0f, 4, 1, 8, 0.0f);
        this.body1.addChild(this.body2);
        this.body2.addChild(this.body3);
        this.body3.addChild(this.fluke1);
        this.body3.addChild(this.fluke2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body1.render(f5);
        this.fin1.render(f5);
        this.fin2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.body2.rotateAngleX = MathHelper.sin((float)(f2 * 0.08f)) * 0.2f;
        this.fluke1.rotateAngleX = this.body3.rotateAngleX = this.body2.rotateAngleX * 1.4f;
        this.fluke2.rotateAngleX = this.body3.rotateAngleX;
        this.fin1.rotateAngleY = 1.0471976f;
        this.fin2.rotateAngleY = -1.0471976f;
        this.fluke1.rotateAngleY = -0.7853982f;
        this.fluke2.rotateAngleY = 0.7853982f;
        this.fin1.setRotationPoint(-3.5f, 22.0f, 2.0f);
        this.fin2.setRotationPoint(3.5f, 22.0f, 2.0f);
    }
}

