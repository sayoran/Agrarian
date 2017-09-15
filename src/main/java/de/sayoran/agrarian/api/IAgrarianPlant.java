package de.sayoran.agrarian.api;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public interface IAgrarianPlant {

    int getGrowthStages();

    ItemStack getSeed();


    String getId();


    String getPlantName();

    @SideOnly(Side.CLIENT)
    ResourceLocation getPrimaryPlantTexture(int meta);

    @SideOnly(Side.CLIENT)
    ResourceLocation getSeedTexture();

}
