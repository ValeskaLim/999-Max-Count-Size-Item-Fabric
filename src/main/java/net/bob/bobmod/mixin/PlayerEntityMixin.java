package net.bob.bobmod.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "dropItem(Lnet/minecraft/item/ItemStack;Z)Lnet/minecraft/entity/ItemEntity;", at = @At("HEAD"), cancellable = true)
    private void modifyDropItem(ItemStack stack, boolean throwRandomly, CallbackInfoReturnable<Boolean> cir){
        if(stack.getCount() > 64){
            ItemStack dropStack = stack.split(64);
            ((PlayerEntity) (Object) this).dropItem(dropStack, throwRandomly);
            if(stack.getCount() > 0){
                ((PlayerEntity) (Object) this).dropItem(stack, throwRandomly);
            }
            cir.setReturnValue(true);
        }
    }
}
