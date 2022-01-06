package com.gildedrose.composition;

public class AgedBrieStrategy implements Strategy {
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
