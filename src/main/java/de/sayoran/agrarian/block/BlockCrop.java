package de.sayoran.agrarian.block;


import de.sayoran.agrarian.api.AgrarianSeed;
import de.sayoran.agrarian.api.util.MethodResult;
import de.sayoran.agrarian.init.ModItems;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class BlockCrop extends BlockTileEntity<TileEntityCrop> implements IPlantable, IGrowable {

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


    public Optional<TileEntityCrop> getCrop(IBlockAccess world, BlockPos pos) {
        return getTile(world, pos, TileEntityCrop.class);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.cropSticks;
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {

        if (world.isRemote) {
            return true;
        }
        TileEntityCrop crop = getTile(world, pos, TileEntityCrop.class).orElse(null);

        if (crop == null) {
            return false;
        }

        if (player.getHeldItem(hand) == null) {
            // crop.onHarvest(player);
            return true;
        }
        System.out.println("clicked " + player.getHeldItem(hand).getUnlocalizedName());


        if (player.getHeldItem(hand).getUnlocalizedName().equals("item.seeds")) {
            System.out.println("clicked with seeds");

            if (crop.onApplySeeds(player, player.getHeldItem(hand).getItem()) == MethodResult.SUCCESS)
                if (!player.isCreative()) {
                    player.getHeldItem(hand).shrink(1);
                }
            return true;
        }
        return true;

    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
        System.out.println("BROKEN");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        System.out.println("PickBlock");
        return new ItemStack(ModItems.cropSticks);
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

        return EnumPlantType.Crop;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {

        return world.getBlockState(pos);
    }

    public boolean canBlockStay(IBlockAccess world, BlockPos pos) {
        if (world.getBlockState(pos.down()) == Blocks.FARMLAND) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return false;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

    }
}