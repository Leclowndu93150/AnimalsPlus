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
public class ModelCricket
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer bigLegs;
    private ModelRenderer leg1;
    private ModelRenderer leg2;
    private ModelRenderer leg3;
    private ModelRenderer leg4;
    private ModelRenderer antennae1;
    private ModelRenderer antennae2;

    public ModelCricket() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-1.5f, -2.0f, -3.0f, 3, 3, 6);
        this.body.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.bigLegs = new ModelRenderer((ModelBase)this, 0, 9);
        this.bigLegs.addBox(-2.0f, -4.0f, 0.0f, 4, 6, 4);
        this.bigLegs.setRotationPoint(0.0f, 22.0f, 2.0f);
        this.leg1 = new ModelRenderer((ModelBase)this, 12, 0);
        this.leg1.addBox(-1.0f, 0.0f, 0.0f, 1, 3, 1);
        this.leg1.setRotationPoint(-1.5f, 22.0f, 1.0f);
        this.leg2 = new ModelRenderer((ModelBase)this, 12, 0);
        this.leg2.mirror = true;
        this.leg2.addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.leg2.setRotationPoint(1.5f, 22.0f, 1.0f);
        this.leg3 = new ModelRenderer((ModelBase)this, 12, 0);
        this.leg3.addBox(-1.0f, 0.0f, 0.0f, 1, 3, 1);
        this.leg3.setRotationPoint(-1.5f, 22.0f, -1.0f);
        this.leg4 = new ModelRenderer((ModelBase)this, 12, 0);
        this.leg4.mirror = true;
        this.leg4.addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.leg4.setRotationPoint(1.5f, 22.0f, -1.0f);
        this.antennae1 = new ModelRenderer((ModelBase)this, 16, 0);
        this.antennae1.addBox(-1.0f, -4.0f, 0.0f, 1, 4, 1);
        this.antennae1.setRotationPoint(0.0f, 19.0f, -2.0f);
        this.antennae2 = new ModelRenderer((ModelBase)this, 16, 0);
        this.antennae2.addBox(0.0f, -4.0f, 0.0f, 1, 4, 1);
        this.antennae2.setRotationPoint(0.0f, 19.0f, -2.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        float f6 = 0.3926991f;
        float f7 = 0.7853982f;
        this.body.rotateAngleX = -f6;
        this.leg1.rotateAngleX = -f6;
        this.leg1.rotateAngleZ = f7;
        this.leg2.rotateAngleX = -f6;
        this.leg2.rotateAngleZ = -f7;
        this.leg3.rotateAngleX = -f7;
        this.leg3.rotateAngleZ = f6;
        this.leg4.rotateAngleX = -f7;
        this.leg4.rotateAngleZ = -f6;
        this.antennae1.rotateAngleX = f6;
        this.antennae1.rotateAngleZ = -f6;
        this.antennae2.rotateAngleX = f6;
        this.antennae2.rotateAngleZ = f6;
        this.body.render(f5);
        this.bigLegs.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.antennae1.render(f5);
        this.antennae2.render(f5);
    }
}

