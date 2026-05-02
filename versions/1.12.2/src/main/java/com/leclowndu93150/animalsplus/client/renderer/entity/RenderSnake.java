package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelSnake;
import com.leclowndu93150.animalsplus.entity.passive.EntitySnake;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSnake extends RenderLiving<EntitySnake> {
    private static final ResourceLocation snakeBrownTextures = new ResourceLocation("animalsplus", "textures/entity/snake/brown.png");
    private static final ResourceLocation snakeGreenTextures = new ResourceLocation("animalsplus", "textures/entity/snake/green.png");
    private static final ResourceLocation snakeRedTextures   = new ResourceLocation("animalsplus", "textures/entity/snake/red.png");

    public RenderSnake(RenderManager renderManager) {
        super(renderManager, new ModelSnake(), 0.0f);
    }

    @Override
    protected void applyRotations(EntitySnake snake, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(snake, ageInTicks, rotationYaw, partialTicks);
        GlStateManager.translate(0.0f, 0.0f, -0.3f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySnake snake) {
        switch (snake.getSnakeType()) {
            case 1:  return snakeGreenTextures;
            case 2:  return snakeRedTextures;
            default: return snakeBrownTextures;
        }
    }
}
