package dev.prangellplays.masks.mixin.server;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.prangellplays.masks.item.MaskItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({DamageSource.class})
public class DamageSourceMixin {
    public DamageSourceMixin() {
    }

    @WrapOperation(
            method = {"getDeathMessage"},
            at = {@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;getDisplayName()Lnet/minecraft/text/Text;"
            )}
    )
    private Text nameless$removeName(LivingEntity instance, Operation<Text> original) {
        if (MaskItem.isWearingMask(instance)) {
            Text name = Text.of("Player").copy().formatted(Formatting.OBFUSCATED);
            return name;
        }
        return (Text) original;
    }
}