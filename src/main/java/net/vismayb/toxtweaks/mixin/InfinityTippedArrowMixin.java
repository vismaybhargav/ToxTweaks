package net.vismayb.toxtweaks.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RangedWeaponItem.class)
public class InfinityTippedArrowMixin extends Item {
    public InfinityTippedArrowMixin(Settings settings) {
        super(settings);
    }

    @Inject(method = "isInfinity", at = @At(value = "HEAD"), cancellable = true)
    private static void isInfinity(ItemStack weaponStack, ItemStack projectileStack, boolean creative, CallbackInfoReturnable<Boolean> cir) {
        if(
                (creative || projectileStack.isOf(Items.ARROW) || projectileStack.isOf(Items.TIPPED_ARROW))
                && EnchantmentHelper.getLevel(Enchantments.INFINITY, weaponStack) > 0)
        {
            cir.setReturnValue(true);
        }
    }
}
