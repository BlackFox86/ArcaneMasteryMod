package net.redfox.arcanemastery.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redfox.arcanemastery.ArcaneMastery;
import net.redfox.arcanemastery.block.custom.FireLanternBlock;
import net.redfox.arcanemastery.block.custom.IceLanternBlock;
import net.redfox.arcanemastery.item.ModItemGroup;

public class ModBlocks {
    public static final Block FIRE_CRYSTAL_BLOCK = registerBlock("fire_crystal_block", new Block(FabricBlockSettings.of(Material.AMETHYST).luminance(7).strength(2f).requiresTool()), ModItemGroup.ARCANE_MASTERY);
    public static final Block ICE_CRYSTAL_BLOCK = registerBlock("ice_crystal_block", new Block(FabricBlockSettings.of(Material.AMETHYST).luminance(7).strength(2f).requiresTool()), ModItemGroup.ARCANE_MASTERY);
    public static final Block FIRE_LANTERN = registerBlock("fire_lantern", new FireLanternBlock(FabricBlockSettings.of(Material.METAL).luminance(15).strength(2f).requiresTool()), ModItemGroup.ARCANE_MASTERY);
    public static final Block ICE_LANTERN = registerBlock("ice_lantern", new IceLanternBlock(FabricBlockSettings.of(Material.METAL).luminance(15).strength(2f).requiresTool()), ModItemGroup.ARCANE_MASTERY);

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        RegisterBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(ArcaneMastery.MOD_ID, name), block);
    }
    private static Item RegisterBlockItem(String name, Block block, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(ArcaneMastery.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        ArcaneMastery.LOGGER.debug("Registering ModBlocks for " + ArcaneMastery.MOD_ID);
    }
}
