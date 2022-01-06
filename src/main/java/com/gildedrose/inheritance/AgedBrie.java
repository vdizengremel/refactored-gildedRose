package com.gildedrose.inheritance;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isExpired()) {
            increaseQuality(2);
        }
        else {
            increaseQuality();
        }
    }
}
