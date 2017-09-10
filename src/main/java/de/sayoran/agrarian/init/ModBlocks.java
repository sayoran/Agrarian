package de.sayoran.agrarian.init;

import de.sayoran.agrarian.block.BlockCrop;
import de.sayoran.agrarian.block.BlockCropCorn;
import de.sayoran.agrarian.block.analyzer.BlockAnalyzer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;


public class ModBlocks {

    public static BlockAnalyzer seedAnalyzer = new BlockAnalyzer();
    public static BlockCropCorn cropCorn = new BlockCropCorn();
    public static BlockCrop blockCrop = new BlockCrop(Material.PLANTS, "crop_sticks");


    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
            seedAnalyzer,
                cropCorn,
                blockCrop
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