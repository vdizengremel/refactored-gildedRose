package com.gildedrose.inheritance;

public abstract class Item {

    protected String name;
    protected int sellIn;
    protected Quality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new Quality(quality);
    }

    public abstract void updateQuality();

    public void updateSellIn() {
        this.sellIn = this.sellIn - 1;
    }

    boolean isExpired() {
        return this.sellIn <= 0;
    }

    void increaseQuality() {
        increaseQuality(1);
    }

    void increaseQuality(int increaseValue) {
        this.quality = this.quality.increaseBy(increaseValue);
    }

    void decreaseQuality() {
        decreaseQuality(1);
    }

    void decreaseQuality(int decreaseValue) {
        this.quality = this.quality.decreaseBy(decreaseValue);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality.getValue();
    }

}
