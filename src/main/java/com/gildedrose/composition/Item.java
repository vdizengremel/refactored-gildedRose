package com.gildedrose.composition;

public class Item {

    private final String name;
    private int sellIn;
    private Quality quality;
    private final UpdateQualityStrategy updateQualityStrategy;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = new Quality(quality);
        this.updateQualityStrategy = UpdateQualityStrategy.findFor(this);
    }

    public void updateQuality() {
        this.updateQualityStrategy.updateQuality(this);
    }

    public void updateSellIn() {
        boolean isNotSulfura = !this.isSulfura();
        if (isNotSulfura) {
            this.sellIn = this.sellIn - 1;
        }
    }

    boolean isExpired() {
        return this.sellIn <= 0;
    }

    boolean isExpiredInLessThan(int days) {
        return sellIn < days;
    }

    void resetQuality() {
        this.quality = new Quality(0);
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

    static Item agedBrie(int quantity, int sellIn) {
        return new Item("Aged Brie", quantity, sellIn);
    }

    public boolean isAgedBrie() {
        return name.equals("Aged Brie");
    }

    public boolean isBackstage() {
        return name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public boolean isSulfura() {
        return name.equals("Sulfuras, Hand of Ragnaros");
    }
}
