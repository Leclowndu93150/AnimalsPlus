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
public class ModelAngler
extends ModelBase {
    private ModelRenderer body = new ModelRenderer((ModelBase)this, 0, 0);
    private ModelRenderer beck;
    private ModelRenderer rod;
    private ModelRenderer fin1;
    private ModelRenderer fin2;
    private ModelRenderer tail;

    public ModelAngler() {
        this.body.addBox(-2.0f, -4.0f, -5.0f, 4, 6, 10);
        this.body.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.beck = new ModelRenderer((ModelBase)this, 0, 16);
        this.beck.addBox(-3.0f, -4.0f, -8.0f, 6, 4, 8);
        this.beck.setRotationPoint(0.0f, 24.0f, 3.0f);
        this.rod = new ModelRenderer((ModelBase)this, 28, 7);
        this.rod.addBox(0.0f, -4.0f, -5.0f, 0, 4, 5);
        this.rod.setRotationPoint(0.0f, 18.0f, -4.0f);
        this.fin1 = new ModelRenderer((ModelBase)this, 28, 10);
        this.fin1.addBox(-4.0f, 0.0f, 0.0f, 4, 0, 2);
        this.fin1.setRotationPoint(-2.0f, 23.0f, 3.0f);
        this.fin2 = new ModelRenderer((ModelBase)this, 28, 10);
        this.fin2.mirror = true;
        this.fin2.addBox(0.0f, 0.0f, 0.0f, 4, 0, 2);
        this.fin2.setRotationPoint(2.0f, 23.0f, 3.0f);
        this.tail = new ModelRenderer((ModelBase)this, 28, 0);
        this.tail.addBox(0.0f, -3.0f, 0.0f, 0, 6, 4);
        this.tail.setRotationPoint(0.0f, 20.0f, 5.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.beck.render(f5);
        this.rod.render(f5);
        this.fin1.render(f5);
        this.fin2.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.beck.rotateAngleX = MathHelper.abs((float)(MathHelper.sin((float)(f2 * 0.2f)) * 0.6f));
        this.fin1.rotateAngleX = 0.3926991f;
        this.fin1.rotateAngleY = 0.3926991f;
        this.fin1.rotateAngleZ = -0.3926991f;
        this.fin2.rotateAngleX = 0.3926991f;
        this.fin2.rotateAngleY = -0.3926991f;
        this.fin2.rotateAngleZ = 0.3926991f;
        this.tail.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 2.0f * f1;
    }
}

