package de.sayoran.agrarian.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;


public class ModItems {

    public static ItemBase cropSticks = new ItemBase("crop_sticks", 64);
    public static ItemBase clipper = new ItemBase("clipper", 1);
    public static ItemBase journal = new ItemBase("journal", 1);
    public static ItemBase magnifyingGlass = new ItemBase("magnifying_glass", 1);
    public static ItemBase trowel = new ItemBase("trowel", 1);
    public static ItemCornSeed cornSeed = new ItemCornSeed();
    public static ItemModFood corn = new ItemModFood("corn", 3, 0.6f,false,64);
    public static ItemModFood poppedCorn = new ItemModFood("popped_corn", 4, 0.6f,false, 32);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                cropSticks,
                clipper,
                journal,
                magnifyingGlass,
                trowel,
                cornSeed,
                corn,
                poppedCorn
        );
    }

    public static void registerModels() {
        cropSticks.registerItemModel();
        clipper.registerItemModel();
        journal.registerItemModel();
        magnifyingGlass.registerItemModel();
        trowel.registerItemModel();
        cornSeed.registerItemModel();
        corn.registerItemModel();
        poppedCorn.registerItemModel();
    }

}