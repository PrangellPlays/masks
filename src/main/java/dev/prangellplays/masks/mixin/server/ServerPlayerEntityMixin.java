package dev.prangellplays.masks.mixin.server;

import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
    @Shadow
    @Final
    public MinecraftServer server;

    @Redirect(method = "onDeath", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/damage/DamageTracker;getDeathMessage()Lnet/minecraft/text/Text;"))
    private Text styledChat$replaceDeathMessage(DamageTracker instance) {
        //return StyledChatStyles.getDeath((ServerPlayerEntity) (Object) this, instance.getDeathMessage());
        return null;
    }
}
