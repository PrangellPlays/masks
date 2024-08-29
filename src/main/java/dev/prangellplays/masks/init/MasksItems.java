package dev.prangellplays.masks.init;

import dev.prangellplays.masks.Masks;
import dev.prangellplays.masks.item.mask.BlankMaskItem;
import dev.prangellplays.masks.item.mask.KitsuneMaskItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class MasksItems {
    //Masks
    public static final Item BLANK_MASK = registerItem("blank_mask", new BlankMaskItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));
    public static final Item KITSUNE_MASK = registerItem("kitsune_mask", new KitsuneMaskItem(new FabricItemSettings().rarity(Rarity.UNCOMMON).maxCount(1)));

    //Items


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Masks.MOD_ID, name), item);
    }

    public static void init() {
        Masks.LOGGER.info("Registering Mod Items for " + Masks.MOD_ID);
    }
}
