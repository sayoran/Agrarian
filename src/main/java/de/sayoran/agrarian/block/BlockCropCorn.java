package de.sayoran.agrarian.block;

import de.sayoran.agrarian.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCropCorn extends BlockCrops{

    public BlockCropCorn(){
        setUnlocalizedName("crop_corn");
        setRegistryName("crop_corn");
    }

    @Override
    protected Item getSeed(){
        return ModItems.cornSeed;
    }

    @Override
    protected Item getCrop(){
        return ModItems.corn;
    }
}
