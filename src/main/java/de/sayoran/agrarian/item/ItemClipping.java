package de.sayoran.agrarian.item;

import de.sayoran.agrarian.Agrarian;
import de.sayoran.agrarian.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ItemClipping extends ItemSeeds {

    protected String name;

    public ItemClipping(String name){

        super(ModBlocks.cropCorn, Blocks.FARMLAND);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Agrarian.creativeTab);
    }

    public void registerItemModel(){

        Agrarian.proxy.registerItemRenderer(this, 0, this.name);
        MinecraftForge.addGrassSeed(new ItemStack(this),10);
    }
}
