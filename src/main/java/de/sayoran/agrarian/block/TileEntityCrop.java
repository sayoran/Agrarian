package de.sayoran.agrarian.block;

import de.sayoran.agrarian.item.ItemModSeed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TileEntityCrop extends BlockTileEntity {
    private ItemModSeed seed;

    public TileEntityCrop(Material material, String name){
        super(material, name);
    }

    @Override
    public Class getTileEntityClass() {
        return null;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return null;
    }
}
