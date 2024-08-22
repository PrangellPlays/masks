package dev.prangellplays.masks.item.mask;

import dev.prangellplays.masks.item.MaskItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlankMaskItem extends MaskItem {
    public BlankMaskItem(FabricItemSettings settings) {
        super(settings);
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.masks.blank_mask.desc").formatted(Formatting.DARK_GRAY));
        tooltip.add(Text.translatable("item.masks.mask.desc.offset1").formatted(Formatting.GRAY));
        if (stack.getNbt() != null) {
            tooltip.add(Text.translatable("item.masks.mask.desc.offset2", new Object[]{stack.getNbt().getInt("offset")}).formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
