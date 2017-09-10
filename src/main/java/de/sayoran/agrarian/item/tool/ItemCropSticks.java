package de.sayoran.agrarian.item.tool;

import de.sayoran.agrarian.init.ModBlocks;
import de.sayoran.agrarian.item.ItemBase;
import net.minecraft.block.SoundType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
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
        //set cropsticks Block
        world.setBlockState(pos.up(), ModBlocks.blockCrop.getDefaultState());

        //Remove used Crop
        player.getHeldItem(hand).shrink(1);

        SoundType type = Blocks.LEAVES.getSoundType();
        world.playSound(null, (double) ((float) cropPos.getX() + 0.5F), (double) ((float) cropPos.getY() + 0.5F), (double) ((float) cropPos.getZ() + 0.5F), type.getPlaceSound(), SoundCategory.PLAYERS, (type.getVolume() + 1.0F) / 4.0F, type.getPitch() * 0.8F);


        //player.sendMessage(new TextComponentString("Right clicked"));
        return EnumActionResult.SUCCESS;
    }








}