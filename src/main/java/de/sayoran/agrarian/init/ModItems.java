package de.sayoran.agrarian.init;

import de.sayoran.agrarian.item.ItemBase;
import de.sayoran.agrarian.item.ItemClipping;
import de.sayoran.agrarian.item.ItemModFood;
import de.sayoran.agrarian.item.ItemModSeed;
import de.sayoran.agrarian.item.tool.ItemCropSticks;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;



public class ModItems {

    public static ItemCropSticks cropSticks = new ItemCropSticks("crop_sticks", 64);
    public static ItemBase clipper = new ItemBase("clipper", 1);
    public static ItemBase journal = new ItemBase("journal", 1);
    public static ItemBase magnifyingGlass = new ItemBase("magnifying_glass", 1);
    public static ItemBase trowel = new ItemBase("trowel", 1);
    public static ItemModSeed cornSeed = new ItemModSeed("corn_seed");
    public static ItemModFood corn = new ItemModFood("corn", 3, 0.6f,false,64);
    public static ItemModFood poppedCorn = new ItemModFood("popped_corn", 4, 0.6f,false, 32);
    public static ItemClipping clipping = new ItemClipping("clipping");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                cropSticks,
                clipper,
                journal,
                magnifyingGlass,
                trowel,
                cornSeed,
                corn,
                poppedCorn,
                clipping
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
        clipping.registerItemModel();
    }

}