package de.sayoran.agrarian.block;


import de.sayoran.agrarian.api.AgrarianSeed;
import de.sayoran.agrarian.api.IAgrarianCrop;
import de.sayoran.agrarian.api.IAgrarianPlant;
import de.sayoran.agrarian.api.IAgrarianStat;
import de.sayoran.agrarian.api.util.MethodResult;
import de.sayoran.agrarian.item.ItemModSeed;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Consumer;


public class TileEntityCrop extends TileEntity implements IAgrarianCrop {

    private Item seed; //TODO: change Item to AgrarianSeed everywhere
    private int growthStage;
    private boolean crossCrop = false;

    public TileEntityCrop(){
        super();
    }

    //@Override
    public MethodResult onGrowthTick() {
        if (this.isRemote()) {
            return MethodResult.PASS;
        }
        //TODO: cross, spawn Crops

        return MethodResult.FAIL;
    }

    @Override
    public MethodResult onApplySeeds(EntityPlayer player, Item seed) {

        if (this.isRemote()) {
            return MethodResult.PASS;
        }

        if (this.hasSeed()) {
            return MethodResult.FAIL;
        }

        this.setSeed(seed);
        System.out.println("set Seed");
        return MethodResult.SUCCESS;
    }

    @Override
    public MethodResult onApplyCrops(EntityPlayer player) {

        if (this.isRemote()) {
            return MethodResult.PASS;
        }

        if (this.hasSeed()) {
            return MethodResult.FAIL;
        }

        final boolean wasSet = this.setCrossCrop(true);
        System.out.println("Apply");

        return wasSet ? MethodResult.SUCCESS : MethodResult.FAIL;
    }

    public boolean setCrossCrop(boolean status) {
        if (this.isRemote()) {
            return false;
        }

        if (this.hasSeed()) {
            return false;
        }

        if (this.crossCrop == status) {
            return false;
        }

        this.crossCrop = status;
        this.markForUpdate();
        return true;
    }

    @Override
    public MethodResult onBroken(EntityPlayer player) {
        if (this.isRemote()) {
            return MethodResult.PASS;
        }

        if (player == null || !player.isCreative()) {
            //TODO: drop Items
        }

        this.getWorld().removeTileEntity(pos);
        this.getWorld().setBlockToAir(pos);

        return MethodResult.SUCCESS;
    }

    //@Override
    public boolean hasSeed() {
        return (this.seed != null);
    }

    //@Override
    public Item getSeed() {
        return this.seed;
    }

    //@Override
    public boolean acceptSeed(ItemModSeed seed) {
        return (this.seed == null || seed == null);
    }

    //@Override
    public boolean setSeed(Item seed) {
        final Item oldSeed = this.seed;
        this.seed = seed;
        this.markForUpdate();
        return this.seed != oldSeed;
    }

    //@Override
    public BlockPos getCropPos() {
        return this.getPos();
    }

    //@Override
    public World getCropWorld() {
        return this.getWorld();
    }

    //@Override
    public int getGrowthStage() {
        return this.growthStage;
    }

    //@Override
    public void setGrowthStage(int stage) {
 /*       if (this.isRemote()) {
            return;
        }

        if (!this.hasSeed()) {
            return;
        }

        if (stage < 0) {
            stage = 0;
        } else if (stage >= this.seed.getPlant().getGrowthStages()) {
            stage = this.seed.getPlant().getGrowthStages() - 1;
        }

        if (stage != this.growthStage) {
            this.growthStage = stage;
            this.markForUpdate();
        }*/
    }

    @Override
    public boolean isCrossCrop() {
        return false;
    }


    public void markForUpdate() {
        IBlockState state = this.getWorld().getBlockState(this.getPos());
        this.getWorld().notifyBlockUpdate(getPos(), state, state, 3);
        this.markDirty();
    }

    public boolean isRemote() {
        return
                this.getWorld().isRemote;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag.setBoolean("agrarian_cross_crop", crossCrop);
        tag.setInteger("agrarian_meta", growthStage);
        if (this.hasSeed()) {
            // this.getSeed().getStat().writeToNBT(tag);
            //  tag.setString("agrarian_seed",this.getSeed().getPlant().getId());
        }
        return super.writeToNBT(tag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        final IAgrarianStat stat = null;
        final IAgrarianPlant plant = null;
        if (stat != null && plant != null) {
            // this.seed = new AgrarianSeed(plant, stat);
        } else {
            this.seed = null;
        }
        this.growthStage = tag.getInteger("agrarian_meta");
        this.crossCrop = tag.getBoolean("agrarian_cross_crop");
    }



}
