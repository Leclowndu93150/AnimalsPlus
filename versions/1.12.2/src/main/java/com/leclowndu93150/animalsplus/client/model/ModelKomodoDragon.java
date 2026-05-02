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

import com.leclowndu93150.animalsplus.entity.passive.EntityKomodoDragon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelKomodoDragon
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer neck;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer tail1;
    private ModelRenderer head;
    private ModelRenderer tongue;
    private ModelRenderer tail2;
    private ModelRenderer tail3;

    public ModelKomodoDragon() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 18.0f, 0.0f);
        this.body.addBox(-3.0f, -3.0f, -8.0f, 6, 6, 16, 0.0f);
        this.neck = new ModelRenderer((ModelBase)this, 0, 22);
        this.neck.setRotationPoint(0.0f, 18.0f, -8.0f);
        this.neck.addBox(-2.0f, -3.0f, -6.0f, 4, 5, 6, 0.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 0, 33);
        this.leg1.setRotationPoint(-3.0f, 18.0f, 6.0f);
        this.leg1.addBox(-3.0f, 0.0f, -2.0f, 3, 6, 4, 0.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 0, 33);
        this.leg2.mirror = true;
        this.leg2.setRotationPoint(3.0f, 18.0f, 6.0f);
        this.leg2.addBox(0.0f, 0.0f, -2.0f, 3, 6, 4, 0.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 0, 33);
        this.leg3.setRotationPoint(-3.0f, 18.0f, -6.0f);
        this.leg3.addBox(-3.0f, 0.0f, -2.0f, 3, 6, 4, 0.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 0, 33);
        this.leg4.mirror = true;
        this.leg4.setRotationPoint(3.0f, 18.0f, -6.0f);
        this.leg4.addBox(0.0f, 0.0f, -2.0f, 3, 6, 4, 0.0f);
        this.tail1 = new ModelRenderer((ModelBase)this, 34, 0);
        this.tail1.setRotationPoint(0.0f, 18.0f, 8.0f);
        this.tail1.addBox(-2.5f, -3.0f, 0.0f, 5, 5, 10, 0.0f);
        this.head = new ModelRenderer((ModelBase)this, 20, 22);
        this.head.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.head.addBox(-1.5f, -3.0f, -6.0f, 3, 4, 6, 0.0f);
        this.tongue = new ModelRenderer((ModelBase)this, 20, 32);
        this.tongue.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.tongue.addBox(-1.5f, 0.0f, -5.0f, 3, 1, 5, 0.0f);
        this.tail2 = new ModelRenderer((ModelBase)this, 40, 15);
        this.tail2.setRotationPoint(0.0f, 0.0f, 10.0f);
        this.tail2.addBox(-2.0f, -2.0f, 0.0f, 4, 4, 8, 0.0f);
        this.tail3 = new ModelRenderer((ModelBase)this, 40, 27);
        this.tail3.setRotationPoint(0.0f, 0.0f, 8.0f);
        this.tail3.addBox(-1.0f, -1.0f, 0.0f, 2, 3, 10, 0.0f);
        this.tail1.addChild(this.tail2);
        this.tail2.addChild(this.tail3);
        this.neck.addChild(this.head);
        this.head.addChild(this.tongue);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.neck.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.tail1.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        EntityKomodoDragon komodoDragon = (EntityKomodoDragon)entity;
        boolean tongueVisible = komodoDragon.isTongueVisible();
        this.neck.rotateAngleX = f4 / 57.295776f * 0.6f - 0.10471976f;
        this.neck.rotateAngleY = f3 / 57.295776f * 0.6f;
        this.head.rotateAngleX = f4 / 57.295776f * 0.4f + 0.10471976f;
        this.head.rotateAngleY = f3 / 57.295776f * 0.4f;
        this.leg1.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.leg2.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
        this.leg3.rotateAngleX = MathHelper.cos((float)(f * 0.6662f + (float)Math.PI)) * 1.4f * f1;
        this.leg4.rotateAngleX = MathHelper.cos((float)(f * 0.6662f)) * 1.4f * f1;
        this.tail1.rotateAngleX = -0.20943952f;
        this.tail1.rotateAngleY = MathHelper.cos((float)(f * 0.4f)) * 1.2f * f1;
        this.tail2.rotateAngleX = 0.10471976f;
        this.tail2.rotateAngleY = MathHelper.cos((float)(f * 0.4f)) * 0.8f * f1;
        this.tail3.rotateAngleX = 0.10471976f;
        this.tail3.rotateAngleY = MathHelper.cos((float)(f * 0.4f)) * 0.8f * f1;
        this.tongue.isHidden = !tongueVisible;
        this.tongue.rotateAngleX = MathHelper.cos((float)(f2 * 4.0f)) * 0.4f;
    }
}

