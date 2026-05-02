package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.init.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityCamel extends EntityTameable {
    public EntityCamel(World world) {
        super(world);
        setSize(1.2f, 2.0f);
        ((PathNavigateGround) getNavigator()).setCanSwim(true);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAttackMelee(this, 1.2, true));
        tasks.addTask(2, new EntityAIWander(this, 1.0));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(4, new EntityAILookIdle(this));
        targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
        getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0);
    }

    @Override
    public boolean attackEntityAsMob(net.minecraft.entity.Entity entity) {
        super.attackEntityAsMob(entity);
        float f = (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    @Override protected SoundEvent getAmbientSound() { return ModSounds.entity_camel_ambient; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return ModSounds.entity_camel_hurt; }
    @Override protected SoundEvent getDeathSound() { return ModSounds.entity_camel_death; }
    @Override protected float getSoundVolume() { return 1.0f; }
    @Override protected void playStepSound(BlockPos pos, Block block) { super.playStepSound(pos, block); }
    @Override protected Item getDropItem() { return Items.LEATHER; }

    @Override
    protected void dropFewItems(boolean recent, int looting) {
        int i = rand.nextInt(5);
        for (int j = 0; j < i; j++) dropItem(Items.LEATHER, 1);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable other) {
        return new EntityCamel(world);
    }
}
