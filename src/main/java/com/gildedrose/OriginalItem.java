package com.gildedrose;

public class OriginalItem {

    public String name;
    public int sellIn;
    public int quality;

    public OriginalItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

}
