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

import com.leclowndu93150.animalsplus.entity.passive.EntitySnake;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ModelSnake
extends ModelBase {
    private ModelRenderer head;
    private ModelRenderer tongue;
    private ModelRenderer tail;

    public ModelSnake() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        this.head = new ModelRenderer((ModelBase)this, 0, 0);
        this.head.addBox(-1.5f, -1.0f, -2.0f, 3, 2, 4);
        this.head.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.tongue = new ModelRenderer((ModelBase)this, 14, 0);
        this.tongue.addBox(-1.5f, 0.0f, -3.0f, 3, 1, 3);
        this.tongue.setRotationPoint(0.0f, 23.0f, -2.0f);
        this.tail = new ModelRenderer((ModelBase)this, 0, 6);
        this.tail.addBox(-1.0f, -1.0f, 0.0f, 2, 2, 4);
        this.tail.setRotationPoint(0.0f, 23.0f, 0.0f);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        EntitySnake snake = (EntitySnake)entity;
        this.head.render(f5);
        this.tongue.render(f5);
        float xpos = 0.0f;
        float zpos = 2.0f;
        for (int i = 0; i < snake.snakeLenght; ++i) {
            float rot;
            this.tail.rotationPointX = xpos;
            this.tail.rotationPointZ = zpos;
            this.tail.rotateAngleY = rot = snake.getRotationForPart(i) * (float)Math.PI / 180.0f;
            this.tail.render(f5);
            xpos += MathHelper.sin((float)rot) * 4.0f;
            zpos += MathHelper.cos((float)rot) * 4.0f;
        }
        this.tongue.rotateAngleX = MathHelper.cos((float)(f2 * 4.0f)) * 0.4f;
    }
}

