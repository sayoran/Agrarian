package de.sayoran.agrarian;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import de.sayoran.agrarian.block.analyzer.ContainerAnalyzer;
import de.sayoran.agrarian.block.analyzer.GuiAnalyzer;
import de.sayoran.agrarian.block.analyzer.TileEntityAnalyzer;

public class ModGuiHandler implements IGuiHandler {

    public static final int ANALYZER = 0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case ANALYZER:
                return new ContainerAnalyzer(player.inventory, (TileEntityAnalyzer) world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case ANALYZER:
                return new GuiAnalyzer(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            default:
                return null;
        }
    }

}