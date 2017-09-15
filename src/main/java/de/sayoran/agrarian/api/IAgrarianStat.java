package de.sayoran.agrarian.api;

import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nonnull;

public interface IAgrarianStat {


    default String getId() {
        return this.getClass().getCanonicalName();
    }

    @Nonnull
    boolean writeToNBT(@Nonnull NBTTagCompound tag);

    String getGrowth();

    String getStrength();
}
