package com.gildedrose.inheritance;

public class Backstage extends Item{
    public Backstage(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (isExpired()) {
            this.quality = new Quality(0);
        } else if (this.sellIn < 6) {
            increaseQuality(3);
        } else if (this.sellIn < 11) {
            increaseQuality(2);
        } else {
            increaseQuality();
        }
    }
}
