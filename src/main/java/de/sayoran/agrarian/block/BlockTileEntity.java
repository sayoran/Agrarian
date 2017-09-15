package de.sayoran.agrarian.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class BlockTileEntity<TE extends TileEntity> extends BlockBase {

    public BlockTileEntity(Material material, String name) {
        super(material, name);
    }

    public static final <T> Optional<T> getTile(IBlockAccess world, BlockPos pos, Class<T> type) {
        return Optional.ofNullable(world)
                .map(w -> w.getTileEntity(pos))
                .filter(te -> type.isAssignableFrom(te.getClass()))
                .map(te -> type.cast(te));
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockAccess world, BlockPos pos) {

        return (TE)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {

        return true;
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);


}