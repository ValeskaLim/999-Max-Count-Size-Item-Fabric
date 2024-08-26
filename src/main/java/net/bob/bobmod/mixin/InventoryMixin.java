package net.bob.bobmod.mixin;

import net.bob.bobmod.BobModFabric;
import net.minecraft.inventory.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Inventory.class)
public interface InventoryMixin {

    @Inject(method = "getMaxCountPerStack", at = @At("HEAD"), cancellable = true)
    default void modifyMaxCountPerStack(CallbackInfoReturnable<Integer> cir){
        BobModFabric.LOGGER.info("Mixin4 has been triggered!");
        cir.setReturnValue(999);
    }
}
