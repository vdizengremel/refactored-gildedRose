package com.gildedrose.domain;

public class AgedBrieUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean isApplicable(Item item) {
        return item.isAgedBrie();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.isExpired()) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality();
        }
    }
}
