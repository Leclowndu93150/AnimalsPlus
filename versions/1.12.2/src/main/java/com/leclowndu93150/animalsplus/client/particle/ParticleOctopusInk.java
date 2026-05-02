package com.leclowndu93150.animalsplus.client.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ParticleOctopusInk extends Particle {
    public ParticleOctopusInk(World world, double x, double y, double z, float scale, float age) {
        super(world, x, y, z, 0.0, 0.0, 0.0);
        motionX *= 0.1;
        motionY *= 0.1;
        motionZ *= 0.1;
        particleBlue = 0.0f;
        particleGreen = 0.0f;
        particleRed = 0.0f;
        particleScale *= scale;
        particleMaxAge = (int) (8.0 / (Math.random() * 0.8 + 0.2));
        particleMaxAge = (int) (particleMaxAge * age);
    }

    @Override
    public void onUpdate() {
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        if (particleAge++ >= particleMaxAge) {
            setExpired();
        }
        setParticleTextureIndex(7 - particleAge * 8 / particleMaxAge);
        motionY -= 5.0E-4;
        move(motionX, motionY, motionZ);
        motionX *= 0.96;
        motionY *= 0.96;
        motionZ *= 0.96;
        if (onGround) {
            motionX *= 0.7;
            motionZ *= 0.7;
        }
    }

}
