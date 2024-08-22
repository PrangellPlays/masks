package dev.prangellplays.masks.mixin.server;

import dev.prangellplays.masks.item.MaskItem;
import net.minecraft.entity.Entity;
import net.minecraft.network.message.MessageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.minecraft.network.message.MessageType.params;

@Mixin(MessageType.class)
public class MessageTypeMixin {
    @Inject(method = "params(Lnet/minecraft/registry/RegistryKey;Lnet/minecraft/entity/Entity;)Lnet/minecraft/network/message/MessageType$Parameters;", at = @At("HEAD"), cancellable = true)
    private static void decoratePlayerNameInChat(RegistryKey<MessageType> typeKey, Entity entity, CallbackInfoReturnable<MessageType.Parameters> cir) {
        if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
            if (MaskItem.isWearingMask(serverPlayerEntity)) {
                Text newName = Text.of("Player").copy().formatted(Formatting.OBFUSCATED);
                cir.setReturnValue(params(typeKey, entity.getWorld().getRegistryManager(), newName));
            }
        }
    }
}