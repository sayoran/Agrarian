package de.sayoran.agrarian.recipe;

import de.sayoran.agrarian.block.ModBlocks;
import de.sayoran.agrarian.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModItems.corn, new ItemStack(ModItems.poppedCorn), 0);
    }
}
