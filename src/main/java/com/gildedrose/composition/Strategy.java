package com.gildedrose.composition;

import java.util.List;

public interface Strategy {
    boolean isApplicable(Item item);

    void updateQuality(Item item);

    static Strategy findFor(Item item) {
        List<Strategy> strategies = List.of(new AgedBrieStrategy(), new BackstageStrategy(), new SulfuraStrategy());
        return strategies.stream().filter(strategy -> strategy.isApplicable(item)).findFirst().orElse(new ClassicStrategy());
    }
}
