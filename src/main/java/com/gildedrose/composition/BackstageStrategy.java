package com.gildedrose.composition;

public class BackstageStrategy implements Strategy {
    @Override
    public boolean isApplicable(Item item) {
        return item.isBackstage();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.isExpired()) {
            item.resetQuality();
        } else if (item.isExpiredInLessThan(6)) {
            item.increaseQuality(3);
        } else if (item.isExpiredInLessThan(11)) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality();
        }
    }
}
