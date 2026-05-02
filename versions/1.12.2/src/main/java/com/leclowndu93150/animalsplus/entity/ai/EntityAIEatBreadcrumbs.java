package com.leclowndu93150.animalsplus.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class EntityAIEatBreadcrumbs extends EntityAIBase {
    private final EntityLiving theEntity;
    private final Item itemToPickup;
    private final double searchRadius;
    private final float movementSpeed;
    private List<EntityItem> targetList;
    private EntityItem bestTarget;

    public EntityAIEatBreadcrumbs(EntityLiving entity, Item item, double searchRadius, float speed) {
        setMutexBits(3);
        this.theEntity = entity;
        this.itemToPickup = item;
        this.searchRadius = searchRadius;
        this.movementSpeed = speed;
    }

    @Override
    public boolean shouldExecute() {
        return findClosestItem() != null;
    }

    private EntityItem findClosestItem() {
        AxisAlignedBB aabb = theEntity.getEntityBoundingBox().expand(searchRadius, searchRadius, searchRadius);
        targetList = theEntity.world.getEntitiesWithinAABB(EntityItem.class, aabb,
                e -> e != null && e.getItem().getItem() == itemToPickup);
        if (!targetList.isEmpty()) bestTarget = targetList.get(0);
        bestTarget = null;
        double closest = 0.0;
        for (EntityItem item : targetList) {
            double dist = theEntity.getDistanceSq(item);
            if (dist < closest || closest == 0.0) {
                closest = dist;
                bestTarget = item;
            }
        }
        return bestTarget;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return !theEntity.getNavigator().noPath() && bestTarget != null && bestTarget.isEntityAlive();
    }

    @Override
    public void resetTask() {
        bestTarget = null;
    }

    @Override
    public void updateTask() {
        theEntity.getLookHelper().setLookPositionWithEntity(bestTarget, 30.0f, 30.0f);
        theEntity.getNavigator().tryMoveToEntityLiving(bestTarget, movementSpeed);
        double d0 = theEntity.width * 2.0f * theEntity.width * 2.0f;
        if (theEntity.getDistanceSq(bestTarget) < d0) {
            bestTarget.setDead();
            targetList.remove(bestTarget);
        }
    }
}
