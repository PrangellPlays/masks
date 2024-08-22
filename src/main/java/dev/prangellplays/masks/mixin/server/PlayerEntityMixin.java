package dev.prangellplays.masks.mixin.server;

import dev.prangellplays.masks.item.MaskItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends Entity {
    Entity entity;
    public PlayerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @ModifyArg(method = "getDisplayName", at = @At(value = "INVOKE", target = "Lnet/minecraft/scoreboard/Team;decorateName(Lnet/minecraft/scoreboard/AbstractTeam;Lnet/minecraft/text/Text;)Lnet/minecraft/text/MutableText;"))
    private Text masks$replaceName(Text text) {
        if (entity instanceof LivingEntity living) {
            if (MaskItem.isWearingMask(living)) {
                Text name = Text.of("Player");
                return name;
            }
        }
        return text;
    }
}