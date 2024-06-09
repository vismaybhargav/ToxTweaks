package net.vismayb.toxtweaks.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InfinityEnchantment.class)
public class InfinityMendingMixin extends Enchantment {
    public InfinityMendingMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "canAccept", at = @At(value = "HEAD"), cancellable = true)
    public void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> rInfo) {
        if(other instanceof MendingEnchantment) {
            rInfo.setReturnValue(super.canAccept(other));
        }
    }
}
