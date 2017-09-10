package de.sayoran.agrarian.item;

import de.sayoran.agrarian.Agrarian;
import de.sayoran.agrarian.api.IAgrarianPlant;
import de.sayoran.agrarian.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class ItemModSeed extends ItemSeeds implements IAgrarianPlant {
    protected String name;
    public ItemModSeed(String name){

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

    @Override
    public int getGrowthStages() {
        return 0;
    }

    @Override
    public ItemStack getSeed() {
        return null;
    }
}
