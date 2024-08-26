package net.bob.bobmod.item;

import net.bob.bobmod.BobModFabric;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

//    public static final Item IRON_INGOT = registerItem("iron_ingot", new Item(new FabricItemSettings().maxCount(2000)));

    public static final Item COBBLESTONE = registerItem("cobblestone", new Item(new FabricItemSettings().food(ModFoodComponent.CUSTOM_COBBLESTONE)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
//        entries.add(IRON_INGOT);
        entries.add(COBBLESTONE);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BobModFabric.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BobModFabric.LOGGER.info("Registering Mod item for " + BobModFabric.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}
