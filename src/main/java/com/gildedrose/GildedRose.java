package com.gildedrose;

import com.gildedrose.domain.Item;

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
