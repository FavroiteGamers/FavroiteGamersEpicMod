package net.favroitegamers.epicmod.block;

import net.favroitegamers.epicmod.EpicMod;
import net.favroitegamers.epicmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EpicMod.MOD_ID);

    public static final RegistryObject<Block> METAL_BLOCK = registerBlock("metal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> WORKBENCH = registerBlock("workbench",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> METAL_ORE = registerBlock("metal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), CreativeModeTab.TAB_REDSTONE);

    public static final RegistryObject<Block> COMPUTER = registerBlock("computer",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), CreativeModeTab.TAB_REDSTONE);
    public static final RegistryObject<Block> DEEPSLATE_METAL_ORE = registerBlock("deepslate_metal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), CreativeModeTab.TAB_REDSTONE);




    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

   return toReturn;
}
   private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab) {
       return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
   }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
