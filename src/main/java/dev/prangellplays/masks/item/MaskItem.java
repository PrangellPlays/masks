package dev.prangellplays.masks.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import dev.prangellplays.masks.Masks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class MaskItem extends TrinketItem {
    public MaskItem(FabricItemSettings settings) {
        super(settings);
    }

    public static boolean isWearingMask(LivingEntity livingEntity) {
        return getWornMask(livingEntity) != ItemStack.EMPTY;
    }

    public static ItemStack getWornMask(LivingEntity livingEntity) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(livingEntity);
        if (component.isPresent()) {
            Iterator var2 = ((TrinketComponent)component.get()).getAllEquipped().iterator();

            while(var2.hasNext()) {
                Pair<SlotReference, ItemStack> pair = (Pair)var2.next();
                if (((ItemStack)pair.getRight()).getItem() instanceof MaskItem) {
                    return (ItemStack)pair.getRight();
                }
            }
        }

        return ItemStack.EMPTY;
    }

    public static int getOffset(ItemStack stack) {
        return stack.getNbt() == null ? 0 : stack.getNbt().getInt("offset");
    }

    public static void incrementOffset(ItemStack stack) {
        NbtCompound compound = stack.getOrCreateNbt();
        compound.putInt("offset", clampLoop(compound.getInt("offset") + 1, -2, 3));
    }

    public static int clampLoop(int input, int start, int end) {
        if (start - end == 0) {
            return start;
        } else {
            if (end < start) {
                int temp = start;
                start = end;
                end = temp;
            }

            return input < start ? end - (start - input) % (end - start) : start + (input - start) % (end - start);
        }
    }
}