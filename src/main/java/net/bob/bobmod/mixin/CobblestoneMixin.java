package net.bob.bobmod.mixin;

import net.bob.bobmod.BobModFabric;
import net.fabricmc.fabric.impl.client.itemgroup.FabricCreativeGuiComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.Settings.class)
public abstract class CobblestoneMixin {

    @ModifyVariable(method = "maxCount",at = @At("HEAD"),ordinal = 0)
    private int setMaxCount(int maxCount){
        BobModFabric.LOGGER.info("Mixin1 has been triggered!");
        return 999;
    }
}
