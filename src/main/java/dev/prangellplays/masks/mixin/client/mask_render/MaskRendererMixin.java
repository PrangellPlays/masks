package dev.prangellplays.masks.mixin.client.mask_render;

import dev.prangellplays.masks.Masks;
import dev.prangellplays.masks.init.MasksItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class MaskRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useMaskModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(MasksItems.BLANK_MASK) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND && renderMode != ModelTransformationMode.FIXED && renderMode != ModelTransformationMode.FIRST_PERSON_LEFT_HAND && renderMode != ModelTransformationMode.FIRST_PERSON_RIGHT_HAND && renderMode != ModelTransformationMode.THIRD_PERSON_LEFT_HAND && renderMode != ModelTransformationMode.THIRD_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).masks$getModels().getModelManager().getModel(new ModelIdentifier(Masks.MOD_ID, "blank_mask_head", "inventory"));
        }
        if (stack.isOf(MasksItems.KITSUNE_MASK) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.GROUND && renderMode != ModelTransformationMode.FIXED && renderMode != ModelTransformationMode.FIRST_PERSON_LEFT_HAND && renderMode != ModelTransformationMode.FIRST_PERSON_RIGHT_HAND && renderMode != ModelTransformationMode.THIRD_PERSON_LEFT_HAND && renderMode != ModelTransformationMode.THIRD_PERSON_RIGHT_HAND) {
            return ((ItemRendererAccessor) this).masks$getModels().getModelManager().getModel(new ModelIdentifier(Masks.MOD_ID, "kitsune_mask_head", "inventory"));
        }
        return value;
    }
}