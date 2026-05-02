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
public class ModelMouse
extends ModelBase {
    private ModelRenderer body;
    private ModelRenderer tail;

    public ModelMouse() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.addBox(-1.5f, -2.0f, -1.0f, 3, 3, 4);
        this.body.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 0, 7);
        this.tail.addBox(-0.5f, 0.0f, 0.0f, 1, 1, 5);
        this.tail.setRotationPoint(0.0f, 23.0f, 3.0f);
        this.body.setTextureOffset(10, 0).addBox(-1.5f, -1.0f, -3.0f, 3, 2, 2);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.tail.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        this.tail.rotateAngleY = MathHelper.cos((float)(f * 0.6662f)) * 2.0f * f1;
    }
}

