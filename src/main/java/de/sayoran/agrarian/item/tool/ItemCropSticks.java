package de.sayoran.agrarian.item.tool;

import de.sayoran.agrarian.init.ModBlocks;
import de.sayoran.agrarian.item.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemCropSticks extends ItemBase {


    public ItemCropSticks(String name, int stackSize) {
        super(name, stackSize);

    }



    @Override
    public boolean canItemEditBlocks() {
        return true;
        }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote || side != EnumFacing.UP) {
            return EnumActionResult.PASS;
        }

        final BlockPos cropPos = pos.up();

        if (!world.isAirBlock(cropPos)) {
            return EnumActionResult.FAIL;
        }

        if (world.getBlockState(pos).getBlock() != Blocks.FARMLAND){
            return EnumActionResult.FAIL;
        }

        world.setBlockState(pos.up(), ModBlocks.blockCrop.getDefaultState());



        player.sendMessage(new TextComponentString("Right clicked"));
        return EnumActionResult.SUCCESS;
    }








}