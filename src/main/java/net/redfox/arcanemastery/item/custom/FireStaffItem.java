package net.redfox.arcanemastery.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class FireStaffItem extends Item {
    public FireStaffItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(hand == Hand.MAIN_HAND) {
            user.getItemCooldownManager().set(this, 400);
            entity.setOnFireFor(100);
            entity.damage(DamageSource.MAGIC,3);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

}
