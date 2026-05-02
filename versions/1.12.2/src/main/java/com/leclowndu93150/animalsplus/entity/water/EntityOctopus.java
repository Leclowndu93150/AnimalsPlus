package com.leclowndu93150.animalsplus.entity.water;

import com.leclowndu93150.animalsplus.client.particle.ParticleOctopusInk;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityOctopus extends EntitySquid {
    public EntityOctopus(World world) {
        super(world);
        setSize(1.3f, 1.3f);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.getTrueSource() != null && world.isRemote) {
            spawnInkParticles();
        }
        return super.attackEntityFrom(source, amount);
    }

    @SideOnly(Side.CLIENT)
    private void spawnInkParticles() {
        for (int i = 0; i < 40; i++) {
            double d0 = rand.nextGaussian() - 0.5;
            double d1 = rand.nextGaussian() - 0.5;
            double d2 = rand.nextGaussian() - 0.5;
            float scale = (float) (rand.nextGaussian() * 4.0) + 8.0f;
            Minecraft.getMinecraft().effectRenderer.addEffect(
                    new ParticleOctopusInk(world, posX + d0, posY + d1, posZ + d2, scale, 8.0f));
        }
    }
}
