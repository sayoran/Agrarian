package de.sayoran.agrarian.client;

import de.sayoran.agrarian.Agrarian;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import de.sayoran.agrarian.Agrarian;
import de.sayoran.agrarian.item.ModItems;

public class AgrarianTab extends CreativeTabs {

    public AgrarianTab() {

        super(Agrarian.modId);
           }

    @Override
    public ItemStack getTabIconItem() {

        return new ItemStack(ModItems.cropSticks);
    }

    @Override
    public boolean hasSearchBar() {

        return false;
    }
    public static final  AgrarianTab creativeTab = new AgrarianTab();
}