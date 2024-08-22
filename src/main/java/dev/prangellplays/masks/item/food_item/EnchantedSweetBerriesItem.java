package dev.prangellplays.masks.item.food_item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantedSweetBerriesItem extends Item {
    public EnchantedSweetBerriesItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
