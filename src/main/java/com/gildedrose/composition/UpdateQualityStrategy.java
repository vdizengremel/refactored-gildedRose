package com.gildedrose.composition;

import java.util.List;

public interface UpdateQualityStrategy {
    boolean isApplicable(Item item);

    void updateQuality(Item item);

    static UpdateQualityStrategy findFor(Item item) {
        List<UpdateQualityStrategy> strategies = List.of(new AgedBrieUpdateQualityStrategy(), new BackstageUpdateQualityStrategy(), new SulfuraUpdateQualityStrategy());
        return strategies.stream().filter(strategy -> strategy.isApplicable(item)).findFirst().orElse(new ClassicUpdateQualityStrategy());
    }
}
