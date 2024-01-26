package net.brifboy.effectivegems.Item;

import net.brifboy.effectivegems.Blocks.Modblocks;
import net.brifboy.effectivegems.EffectiveGems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EffectiveGems.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EFFECTIVEGEMS_TAB  = CREATIVE_MODE_TABS.register("effectivegems_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.GREEN_GEM.get()))
                    .title(Component.translatable("creativetab.effectivegems"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.GREEN_GEM.get());
                        pOutput.accept(ModItems.BLUE_GEM.get());
                        pOutput.accept(ModItems.BLACK_GEM.get());

                        pOutput.accept(Modblocks.GREEN_GEM_BLOCK.get());
                        pOutput.accept(Modblocks.BLUE_GEM_BLOCK.get());
                        pOutput.accept(Modblocks.BLACK_GEM_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
