package de.sayoran.agrarian.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import de.sayoran.agrarian.Agrarian;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name, int stackSize) {
        this.name = name;
        this.setMaxStackSize(stackSize);
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(Agrarian.creativeTab);
    }
//TODO: delete if never used
    public String getName(){
        return name;
    }

    public void registerItemModel() {

        Agrarian.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}