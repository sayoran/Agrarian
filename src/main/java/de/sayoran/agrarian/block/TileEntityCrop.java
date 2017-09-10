package de.sayoran.agrarian.block;


import de.sayoran.agrarian.api.util.MethodResult;
import de.sayoran.agrarian.item.ItemModSeed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class TileEntityCrop extends TileEntity {

    private ItemModSeed seed;
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

    //@Override
    public MethodResult onApplySeeds(EntityPlayer player, ItemModSeed seed) {

        if (this.isRemote()) {
            return MethodResult.PASS;
        }

        if (this.hasSeed()) {
            return MethodResult.FAIL;
        }

        this.setSeed(seed);
        return MethodResult.SUCCESS;
    }

    //@Override
    public MethodResult onApplyCrops(EntityPlayer player) {

        if (this.isRemote()) {
            return MethodResult.PASS;
        }

        if (this.hasSeed()) {
            return MethodResult.FAIL;
        }

        return MethodResult.FAIL;
    }

    //@Override
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
    public ItemModSeed getSeed() {
        return this.seed;
    }

    //@Override
    public boolean acceptSeed(ItemModSeed seed) {
        return (this.seed == null || seed == null);
    }

    //@Override
    public boolean setSeed(ItemModSeed seed) {
        final ItemModSeed oldSeed = this.seed;
        this.seed = seed;
        this.markForUpdate();
        return this.seed != oldSeed;
    }

    //@Override
    public BlockPos getCropPos() {
        return this.getPos();
    }

    //@Override
    private World getCropWorld() {
        return this.getWorld();
    }

    //@Override
    public int getGrowthStage() {
        return this.growthStage;
    }

    //@Override
    public void setGrowthStage(int stage) {
        if (this.isRemote()) {
            return;
        }

        if (!this.hasSeed()) {
            return;
        }

        if (stage < 0) {
            stage = 0;
        } else if (stage >= this.seed.getGrowthStages()) {
            stage = this.seed.getGrowthStages() - 1;
        }

        if (stage != this.growthStage) {
            this.growthStage = stage;
            this.markForUpdate();
        }
    }


    public void markForUpdate() {
        IBlockState state = this.getWorld().getBlockState(this.getPos());
        this.getWorld().notifyBlockUpdate(getPos(), state, state, 3);
        this.markDirty();
    }

    public boolean isRemote() {
        return this.getWorld().isRemote;
    }

}
