package com.leclowndu93150.animalsplus.client.renderer.entity;

import com.leclowndu93150.animalsplus.client.model.ModelOctopus;
import com.leclowndu93150.animalsplus.entity.water.EntityOctopus;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderOctopus extends RenderLiving<EntityOctopus> {
    private static final ResourceLocation octopusTextures = new ResourceLocation("animalsplus", "textures/entity/octopus.png");

    public RenderOctopus(RenderManager renderManager) {
        super(renderManager, new ModelOctopus(), 0.5f);
    }

    @Override
    protected float handleRotationFloat(EntityOctopus octopus, float partialTicks) {
        return octopus.lastTentacleAngle + (octopus.tentacleAngle - octopus.lastTentacleAngle) * partialTicks;
    }

    @Override
    protected void applyRotations(EntityOctopus octopus, float ageInTicks, float rotationYaw, float partialTicks) {
        float pitch = octopus.prevSquidPitch + (octopus.squidPitch - octopus.prevSquidPitch) * partialTicks;
        float yaw   = octopus.prevSquidYaw   + (octopus.squidYaw   - octopus.prevSquidYaw)   * partialTicks;
        GlStateManager.translate(0.0f, -0.5f, 0.0f);
        GlStateManager.rotate(180.0f - rotationYaw, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(pitch, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(yaw, 0.0f, 1.0f, 0.0f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityOctopus octopus) {
        return octopusTextures;
    }
}
