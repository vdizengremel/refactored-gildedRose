package com.gildedrose.composition;

public class SulfuraUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean isApplicable(Item item) {
        return item.isSulfura();
    }

    @Override
    public void updateQuality(Item item) {
        // Do Nothing
    }
}
