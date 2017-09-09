package de.sayoran.agrarian.item;

import de.sayoran.agrarian.Agrarian;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemModFood extends ItemFood {
    public ItemModFood(String name, int amount, float saturation, boolean isWolfFood){
        super(amount,saturation,isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Agrarian.creativeTab);
    }

    public void registerItemModel(String name){ //TODO: no String parameter needed
        Agrarian.proxy.registerItemRenderer(this, 0, name);
    }

    public void initOreDict(){
        OreDictionary.registerOre("cropCorn", this);
    }
}
