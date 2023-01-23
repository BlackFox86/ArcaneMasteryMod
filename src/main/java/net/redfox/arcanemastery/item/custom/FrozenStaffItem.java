package net.redfox.arcanemastery.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class FrozenStaffItem extends Item {
    public FrozenStaffItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(hand == Hand.MAIN_HAND) {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 9));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 9));
            entity.damage(DamageSource.MAGIC,10);
            user.getItemCooldownManager().set(this, 400);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

}
