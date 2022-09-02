package com.gildedrose.domain;

public class SulfuraUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean isApplicable(Item item) {
        return item.isSulfura();
    }

    @Override
    public void updateQuality(Item item) {
        throw new RuntimeException("should not update quality for sulfura");
    }
}
