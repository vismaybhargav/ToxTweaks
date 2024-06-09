package net.vismayb.toxtweaks.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public class ProtectionMixin extends Enchantment {
    public ProtectionMixin(Properties properties) {
        super(properties);
    }

    @Final
    @Shadow
    public ProtectionEnchantment.Type protectionType;

    @Inject(method = "canAccept", at = @At(value = "HEAD"), cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> rInfo) {
        if(other instanceof ProtectionEnchantment) {
            rInfo.setReturnValue(((ProtectionEnchantment) other).protectionType != protectionType);
        }
    }
}
