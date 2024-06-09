package net.vismayb.toxtweaks.mixin;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment {
    public DamageEnchantmentMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "canAccept", at = @At(value = "HEAD"), cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> rInfo) {
        if(other instanceof DamageEnchantment) {
            rInfo.setReturnValue(true);
        }
    }
}
