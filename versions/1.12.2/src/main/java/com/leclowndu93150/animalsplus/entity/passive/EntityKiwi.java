package com.leclowndu93150.animalsplus.entity.passive;

import com.leclowndu93150.animalsplus.entity.ai.EntityAIEatBreadcrumbs;
import com.leclowndu93150.animalsplus.entity.ambient.EntityCentipede;
import com.leclowndu93150.animalsplus.entity.ambient.EntityCricket;
import com.leclowndu93150.animalsplus.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityKiwi extends EntityAnimal {
    public EntityKiwi(World world) {
        super(world);
        setSize(0.4f, 0.5f);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIPanic(this, 1.3));
        tasks.addTask(2, new EntityAIMate(this, 1.05));
        tasks.addTask(3, new EntityAITempt(this, 1.15, ModItems.breadcrumbs, true));
        tasks.addTask(3, new EntityAITempt(this, 1.15, Items.MELON_SEEDS, true));
        tasks.addTask(4, new EntityAIEatBreadcrumbs(this, ModItems.breadcrumbs, 10.0, 1.0f));
        tasks.addTask(5, new EntityAIFollowParent(this, 1.1));
        tasks.addTask(6, new EntityAIFleeSun(this, 1.2));
        tasks.addTask(7, new EntityAIOcelotAttack(this));
        tasks.addTask(8, new EntityAIWander(this, 1.15));
        tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        tasks.addTask(10, new EntityAILookIdle(this));
        targetTasks.addTask(0, new EntityAINearestAttackableTarget<>(this, EntityCricket.class, false));
        targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, EntityCentipede.class, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0);
    }

    @Override
    public boolean attackEntityAsMob(net.minecraft.entity.Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }

    @Override protected SoundEvent getAmbientSound() { return null; }
    @Override protected SoundEvent getHurtSound(DamageSource src) { return null; }
    @Override protected SoundEvent getDeathSound() { return null; }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }

    @Override
    protected void dropFewItems(boolean drop, int looting) {
        entityDropItem(new ItemStack(Items.FEATHER, rand.nextInt(3), 0), 0.5f);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem() instanceof ItemSeeds;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable other) {
        return new EntityKiwi(world);
    }
}
