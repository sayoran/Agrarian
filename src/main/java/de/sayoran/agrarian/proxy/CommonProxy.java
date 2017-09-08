package de.sayoran.agrarian.proxy;

import de.sayoran.agrarian.Agrarian;
import de.sayoran.agrarian.block.analyzer.TileEntityAnalyzer;
import net.minecraft.item.Item;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }

    public void registerRenderers() {
    }

    public void preInit(FMLPreInitializationEvent e) {
    }
}