package net.redfox.arcanemastery.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrozenStaffItem extends Item {
    public FrozenStaffItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(hand == Hand.MAIN_HAND) {
            user.getItemCooldownManager().set(this, 400);
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 3));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 200, 0));
            entity.damage(DamageSource.MAGIC,10);
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Slows enemies and does damage when right clicked").formatted(Formatting.GRAY));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
