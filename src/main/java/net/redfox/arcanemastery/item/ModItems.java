package net.redfox.arcanemastery.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redfox.arcanemastery.ArcaneMastery;
import net.redfox.arcanemastery.item.custom.FrozenStaffItem;

public class ModItems {
    public static final Item FIRE_CRYSTAL = registerItem("fire_crystal",new Item(new Item.Settings()), ModItemGroup.ARCANE_MASTERY);
    public static final Item ICE_CRYSTAL = registerItem("ice_crystal",new Item(new Item.Settings()), ModItemGroup.ARCANE_MASTERY);
    public static final Item FROZEN_STAFF = registerItem("frozen_staff",new FrozenStaffItem(new Item.Settings().maxCount(1)), ModItemGroup.ARCANE_MASTERY);
    private static Item registerItem(String name, Item item, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(ArcaneMastery.MOD_ID, name), item);
    }
    public static void registerModItems() {
        ArcaneMastery.LOGGER.debug("Registering Mod Items for " + ArcaneMastery.MOD_ID);
    }
}
