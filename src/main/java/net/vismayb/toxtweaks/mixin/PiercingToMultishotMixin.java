package net.vismayb.toxtweaks.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.MultishotEnchantment;
import net.minecraft.enchantment.PiercingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PiercingEnchantment.class)
public class PiercingToMultishotMixin extends Enchantment {
    public PiercingToMultishotMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "canAccept", at = @At(value = "HEAD"), cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> rInfo) {
        if(other instanceof MultishotEnchantment) {
            rInfo.setReturnValue(super.canAccept(other));
        }
    }
}
