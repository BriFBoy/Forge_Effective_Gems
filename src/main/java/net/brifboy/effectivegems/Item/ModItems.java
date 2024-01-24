package net.brifboy.effectivegems.Item;

import net.brifboy.effectivegems.EffectiveGems;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, EffectiveGems.MOD_ID);

    public static final RegistryObject<Item> GREEN_GEM = Items.register("green_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLUE_GEM = Items.register("blue_gem",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_GEM = Items.register("black_gem",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        Items.register(eventBus);
    }

}
