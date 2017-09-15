package de.sayoran.agrarian.api;

import javax.annotation.Nonnull;
import java.util.Objects;

public final class AgrarianSeed {

    @Nonnull
    private final IAgrarianPlant plant;
    @Nonnull
    private final IAgrarianStat stat;

    public AgrarianSeed(@Nonnull IAgrarianPlant plant, @Nonnull IAgrarianStat stat) {
        this.plant = Objects.requireNonNull(plant, "Plant may not be null");
        this.stat = Objects.requireNonNull(stat, "Stat may not be null");
    }

    @Nonnull
    public IAgrarianPlant getPlant() {
        return this.plant;
    }

    @Nonnull
    public IAgrarianStat getStat() {
        return this.stat;
    }


}
