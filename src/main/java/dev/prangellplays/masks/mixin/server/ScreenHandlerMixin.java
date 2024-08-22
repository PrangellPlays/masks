package dev.prangellplays.masks.mixin.server;

import dev.prangellplays.masks.item.MaskItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ScreenHandler.class})
public class ScreenHandlerMixin {
    @Shadow
    @Final
    public DefaultedList<Slot> slots;

    public ScreenHandlerMixin() {
    }

    @Inject(
            method = {"internalOnSlotClick"},
            at = {@At("HEAD")},
            cancellable = true
    )
    private void masks$preventStacking(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
        if (actionType == SlotActionType.PICKUP && button == 1 && slotIndex >= 0 && slotIndex < this.slots.size()) {
            Slot slot = (Slot) this.slots.get(slotIndex);
            ItemStack stack = slot.getStack();
            if (stack.getItem() instanceof MaskItem) {
                MaskItem.incrementOffset(stack);
                player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.PLAYERS, 0.9F, 1.5F);
                ci.cancel();
            }
        }
    }
}