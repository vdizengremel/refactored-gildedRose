package com.gildedrose.domain;

public class ClassicUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean isApplicable(Item item) {
        return true;
    }

    @Override
    public void updateQuality(Item item) {
        if (item.isExpired()) {
            item.decreaseQuality(2);
        } else {
            item.decreaseQuality();
        }
    }
}
