package com.gildedrose.composition;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.updateQuality();
            item.updateSellIn();
        }
    }
}
