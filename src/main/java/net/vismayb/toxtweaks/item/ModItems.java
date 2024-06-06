package net.vismayb.toxtweaks.item;

import net.fabricmc.fabric.api.item.v1.CustomDamageHandler;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.vismayb.toxtweaks.ToxTweaks;

public class ModItems {
    public static final Item BATON = registerItem("baton", new Item(new Item.Settings().customDamage((stack, amount, entity, slot, breakCallback) -> 1200)));
    public static final Item IRON_STICK = registerItem("iron_stick", new Item(new Item.Settings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(BATON);
        entries.add(IRON_STICK);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ToxTweaks.MOD_ID, name), item);
    }

    public static void registerItems() {
        ToxTweaks.LOGGER.info("Registering Mod Items for" + ToxTweaks.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
