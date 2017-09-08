package de.sayoran.agrarian.block;

import de.sayoran.agrarian.block.analyzer.BlockAnalyzer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;


public class ModBlocks {

    public static BlockAnalyzer seedAnalyzer = new BlockAnalyzer();
    public static BlockCropCorn cropCorn = new BlockCropCorn();



    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
            seedAnalyzer,
                cropCorn
        );

        GameRegistry.registerTileEntity(seedAnalyzer.getTileEntityClass(), seedAnalyzer.getRegistryName().toString());

    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                seedAnalyzer.createItemBlock()
                );
    }

    public static void registerModels() {
        seedAnalyzer.registerItemModel(Item.getItemFromBlock(seedAnalyzer));
    }

}