package net.bob.bobmod.mixin;

import net.bob.bobmod.BobModFabric;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class CobblestoneMixin1 {
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void modifyGetMaxCount(CallbackInfoReturnable<Integer> cir) {
        BobModFabric.LOGGER.info("Mixin2 has been triggered!");
        cir.setReturnValue(999);
    }
}
