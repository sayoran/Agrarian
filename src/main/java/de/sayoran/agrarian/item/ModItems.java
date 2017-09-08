package de.sayoran.agrarian.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;


public class ModItems {

    public static ItemBase cropSticks = new ItemBase("crop_sticks");
    public static ItemBase clipper = new ItemBase("clipper").setCreativeTab(CreativeTabs.TOOLS);
    public static ItemBase journal = new ItemBase("journal");
    public static ItemBase magnifyingGlass = new ItemBase("magnifying_glass");
    public static ItemBase trowel = new ItemBase("trowel");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                cropSticks,
                clipper,
                journal,
                magnifyingGlass,
                trowel
        );
    }

    public static void registerModels() {
        cropSticks.registerItemModel();
        clipper.registerItemModel();
        journal.registerItemModel();
        magnifyingGlass.registerItemModel();
        trowel.registerItemModel();
    }

}