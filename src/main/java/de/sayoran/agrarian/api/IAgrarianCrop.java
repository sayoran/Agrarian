package de.sayoran.agrarian.api;

import de.sayoran.agrarian.api.util.MethodResult;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IAgrarianCrop {

    BlockPos getCropPos();

    World getCropWorld();

    int getGrowthStage();

    void setGrowthStage(int stage);

    boolean isCrossCrop();

    boolean setCrossCrop(boolean status);

    MethodResult onApplyCrops(EntityPlayer player);

    MethodResult onApplySeeds(EntityPlayer player, Item seed);

    MethodResult onBroken(EntityPlayer player);

}
