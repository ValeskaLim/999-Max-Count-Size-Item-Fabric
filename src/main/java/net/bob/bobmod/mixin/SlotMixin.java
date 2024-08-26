package net.bob.bobmod.mixin;

import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public class SlotMixin {
    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)

    private void modifyCanInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir){
        if(stack.getCount() > 64){
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getMaxItemCount", at = @At("HEAD"), cancellable = true)
    private void modifyMaxItemCount(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(999);
    }

    @Inject(method = "getMaxItemCount", at = @At("HEAD"), cancellable = true)
    private void modifyMaxItemCount(ItemStack stack, CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(Math.min(999, stack.getMaxCount()));
    }

    ItemEntity
}
