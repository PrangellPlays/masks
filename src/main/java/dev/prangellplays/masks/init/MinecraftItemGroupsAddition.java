package dev.prangellplays.masks.init;

import dev.prangellplays.masks.Masks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class MinecraftItemGroupsAddition {
    private static void addItemsToBuildingItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToColoredItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToFunctionalItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToRedstoneItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
    }
    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToFoodItemGroup(FabricItemGroupEntries entries){
        entries.add(MasksItems.ENCHANTED_SWEET_BERRIES);
    }
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToSpawnItemGroup(FabricItemGroupEntries entries){
    }
    private static void addItemsToOperatorItemGroup(FabricItemGroupEntries entries){
    }

    public static void init() {
        Masks.LOGGER.info("Registering Minecraft Item Group Additions for " + Masks.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(MinecraftItemGroupsAddition::addItemsToBuildingItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(MinecraftItemGroupsAddition::addItemsToColoredItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(MinecraftItemGroupsAddition::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(MinecraftItemGroupsAddition::addItemsToFunctionalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(MinecraftItemGroupsAddition::addItemsToRedstoneItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(MinecraftItemGroupsAddition::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(MinecraftItemGroupsAddition::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(MinecraftItemGroupsAddition::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(MinecraftItemGroupsAddition::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(MinecraftItemGroupsAddition::addItemsToSpawnItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(MinecraftItemGroupsAddition::addItemsToOperatorItemGroup);
    }
}
