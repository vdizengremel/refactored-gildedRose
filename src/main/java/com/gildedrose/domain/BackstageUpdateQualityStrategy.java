package com.gildedrose.domain;

public class BackstageUpdateQualityStrategy implements UpdateQualityStrategy {
    @Override
    public boolean isApplicable(Item item) {
        return item.isBackstage();
    }

    @Override
    public void updateQuality(Item item) {
        if (item.isExpired()) {
            item.becomeWorthless();
        } else if (item.isExpiredInLessThan(5)) {
            item.increaseQuality(3);
        } else if (item.isExpiredInLessThan(10)) {
            item.increaseQuality(2);
        } else {
            item.increaseQuality();
        }
    }
}
