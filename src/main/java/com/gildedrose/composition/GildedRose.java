package com.gildedrose.composition;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void makeItemsAging() {
        for (Item item : items) {
            item.ageByOneDay();
        }
    }
}
