/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.entity.Entity
 */
package com.leclowndu93150.animalsplus.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVulture
extends ModelBase {
    public ModelRenderer rightLeg;
    public ModelRenderer leftLeg;
    public ModelRenderer body;
    public ModelRenderer neck;
    public ModelRenderer rightFoot;
    public ModelRenderer leftFoot;
    public ModelRenderer tail;
    public ModelRenderer rightWing;
    public ModelRenderer leftWing;
    public ModelRenderer head;
    public ModelRenderer beak;
    public ModelRenderer beak2;

    public ModelVulture() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.head = new ModelRenderer((ModelBase)this, 10, 20);
        this.head.setRotationPoint(0.0f, 0.0f, -5.0f);
        this.head.addBox(-1.0f, -1.5f, -4.0f, 2, 3, 5, 0.0f);
        this.tail = new ModelRenderer((ModelBase)this, 0, 16);
        this.tail.setRotationPoint(0.0f, 6.0f, 2.0f);
        this.tail.addBox(-2.0f, 0.0f, -1.0f, 4, 6, 1, 0.0f);
        this.leftWing = new ModelRenderer((ModelBase)this, 20, 0);
        this.leftWing.setRotationPoint(3.0f, -6.0f, 0.0f);
        this.leftWing.addBox(0.0f, 0.0f, -2.0f, 1, 12, 4, 0.0f);
        this.leftFoot = new ModelRenderer((ModelBase)this, 14, 16);
        this.leftFoot.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.leftFoot.addBox(-1.5f, 0.0f, -2.5f, 3, 1, 3, 0.0f);
        this.rightWing = new ModelRenderer((ModelBase)this, 20, 0);
        this.rightWing.setRotationPoint(-3.0f, -6.0f, 0.0f);
        this.rightWing.addBox(-1.0f, 0.0f, -2.0f, 1, 12, 4, 0.0f);
        this.leftLeg = new ModelRenderer((ModelBase)this, 10, 16);
        this.leftLeg.setRotationPoint(2.0f, 17.0f, 1.5f);
        this.leftLeg.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f);
        this.beak = new ModelRenderer((ModelBase)this, 22, 20);
        this.beak.setRotationPoint(0.0f, 0.0f, -4.0f);
        this.beak.addBox(-1.0f, -0.5f, -3.0f, 2, 1, 3, 0.0f);
        this.neck = new ModelRenderer((ModelBase)this, 0, 23);
        this.neck.setRotationPoint(0.0f, 8.0f, -3.0f);
        this.neck.addBox(-1.0f, -1.0f, -5.0f, 2, 2, 6, 0.0f);
        this.beak2 = new ModelRenderer((ModelBase)this, 26, 24);
        this.beak2.setRotationPoint(0.0f, 1.0f, -2.0f);
        this.beak2.addBox(-1.0f, -0.5f, -1.0f, 2, 1, 1, 0.0f);
        this.rightLeg = new ModelRenderer((ModelBase)this, 10, 16);
        this.rightLeg.setRotationPoint(-2.0f, 17.0f, 1.5f);
        this.rightLeg.addBox(-0.5f, 0.0f, -0.5f, 1, 6, 1, 0.0f);
        this.rightFoot = new ModelRenderer((ModelBase)this, 14, 16);
        this.rightFoot.setRotationPoint(0.0f, 6.0f, 0.0f);
        this.rightFoot.addBox(-1.5f, 0.0f, -2.5f, 3, 1, 3, 0.0f);
        this.body = new ModelRenderer((ModelBase)this, 0, 0);
        this.body.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.body.addBox(-3.0f, -6.0f, -2.0f, 6, 12, 4, 0.0f);
        this.neck.addChild(this.head);
        this.body.addChild(this.tail);
        this.body.addChild(this.leftWing);
        this.leftLeg.addChild(this.leftFoot);
        this.body.addChild(this.rightWing);
        this.head.addChild(this.beak);
        this.beak.addChild(this.beak2);
        this.rightLeg.addChild(this.rightFoot);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.leftLeg.render(f5);
        this.neck.render(f5);
        this.rightLeg.render(f5);
        this.body.render(f5);
    }
}

