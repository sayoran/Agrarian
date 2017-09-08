package de.sayoran.agrarian.item;

import de.sayoran.agrarian.Agrarian;
import de.sayoran.agrarian.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;

public class ItemCornSeed extends ItemSeeds {

    public ItemCornSeed(){
        super(ModBlocks.cropCorn, Blocks.FARMLAND);
        setUnlocalizedName("corn_seed");
        setRegistryName("corn_seed");
        setCreativeTab(Agrarian.creativeTab);
    }

    public void registerItemModel(){
        Agrarian.proxy.registerItemRenderer(this, 0, "corn_seed");
    }
}
