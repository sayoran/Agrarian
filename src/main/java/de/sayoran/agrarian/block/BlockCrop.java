package de.sayoran.agrarian.block;


import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;

public class BlockCrop extends BlockTileEntity<TileEntityCrop> implements IPlantable{

    public BlockCrop(Material material, String name){
        super(material, name);
        this.setTickRandomly(true);
        this.isBlockContainer =true;
        this.setSoundType(SoundType.PLANT);
        this.setHardness(0.0F);
        this.setCreativeTab(null);

    }

    @Override
    public int getMetaFromState(IBlockState state){
        return 0;
    }


    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state){
        return false;
    }



    @Override
    public Class<TileEntityCrop> getTileEntityClass() {
        return TileEntityCrop.class;
    }

    @Nullable
    @Override
    public TileEntityCrop createTileEntity(World world, IBlockState state) {
        return new TileEntityCrop();
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return null;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return null;
    }
}