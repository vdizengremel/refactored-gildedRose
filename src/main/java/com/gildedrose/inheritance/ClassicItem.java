package com.gildedrose.inheritance;

public class ClassicItem extends Item {
    public ClassicItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isExpired()) {
            decreaseQuality(2);
        } else {
            decreaseQuality();
        }
    }
}
