package net.redfox.arcanemastery.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.redfox.arcanemastery.ArcaneMastery;

public class ModItemGroup {
    public static final ItemGroup ARCANE_MASTERY = FabricItemGroup.builder(new Identifier(ArcaneMastery.MOD_ID, "Arcane Mastery")).icon(() -> new ItemStack(ModItems.FIRE_CRYSTAL)).build();
}
