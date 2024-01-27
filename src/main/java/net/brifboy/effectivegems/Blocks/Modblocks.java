package net.brifboy.effectivegems.Blocks;

import net.brifboy.effectivegems.Blocks.custom.BlackGemBlock;
import net.brifboy.effectivegems.Blocks.custom.BlueGemBlock;
import net.brifboy.effectivegems.Blocks.custom.GreenGemBlock;
import net.brifboy.effectivegems.EffectiveGems;
import net.brifboy.effectivegems.Item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Modblocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EffectiveGems.MOD_ID);

    public static final RegistryObject<Block> GREEN_GEM_BLOCK = registerBlock("green_gem_block",
            () -> new GreenGemBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> BLUE_GEM_BLOCK = registerBlock("blue_gem_block",
            () -> new BlueGemBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> BLACK_GEM_BLOCK = registerBlock("black_gem_block",
            () -> new BlackGemBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> GREEN_GEM_ORE = registerBlock("green_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 3)));
    public static final RegistryObject<Block> DEEPSLATE_GREEN_GEM_ORE = registerBlock("deepslate_green_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 3)));
    public static final RegistryObject<Block> BLUE_GEM_ORE = registerBlock("blue_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .requiresCorrectToolForDrops(), UniformInt.of(2, 5)));
    public static final RegistryObject<Block> DEEPSLATE_BLUE_GEM_ORE = registerBlock("deepslate_blue_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)
                    .requiresCorrectToolForDrops(), UniformInt.of(2,5)));
    public static final RegistryObject<Block> NETHER_BLACK_GEM_ORE = registerBlock("nether_black_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 7)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.Items.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
