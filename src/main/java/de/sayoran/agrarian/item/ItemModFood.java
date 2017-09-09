package de.sayoran.agrarian.item;

import de.sayoran.agrarian.Agrarian;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemModFood extends ItemFood {
    protected String name;
    public ItemModFood(String name, int amount, float saturation, boolean isWolfFood, int stackSize){
        super(amount,saturation,isWolfFood);
        this.setMaxStackSize(stackSize);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Agrarian.creativeTab);
    }

    public void registerItemModel(){
        Agrarian.proxy.registerItemRenderer(this, 0, name);
    }

    public void initOreDict(){
        OreDictionary.registerOre("cropCorn", this);
    }
}
