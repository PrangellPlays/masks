package dev.prangellplays.masks.init;

import dev.prangellplays.masks.Masks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MasksItemGroups {
    public static final ItemGroup MASKS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Masks.MOD_ID, "masks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.masks.items")).icon(() -> new ItemStack(MasksItems.BLANK_MASK)).entries((displayContext, entries) -> {
                entries.add(MasksItems.BLANK_MASK);
                entries.add(MasksItems.KITSUNE_MASK);
            }).build());


    public static void init() {
        Masks.LOGGER.info("Registering Item Groups for " + Masks.MOD_ID);
    }
}
