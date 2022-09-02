package com.gildedrose.composition;

public class Item {

    private final String name;
    private int remainingDaysBeforeExpiration; // called sellIn in the original file
    private Quality quality;
    private final UpdateQualityStrategy updateQualityStrategy;

    public Item(String name, int remainingDaysBeforeExpiration, int quality) {
        this.name = name;
        this.remainingDaysBeforeExpiration = remainingDaysBeforeExpiration;
        this.quality = new Quality(quality);
        this.updateQualityStrategy = UpdateQualityStrategy.findFor(this);
    }

    void ageByOneDay() {
        boolean isNotSulfura = !this.isSulfura();
        if (isNotSulfura) {
            this.remainingDaysBeforeExpiration = this.remainingDaysBeforeExpiration - 1;
            this.updateQualityStrategy.updateQuality(this);
        }
    }

    boolean isExpired() {
        return this.remainingDaysBeforeExpiration < 0;
    }

    boolean isExpiredInLessThan(int days) {
        return remainingDaysBeforeExpiration < days;
    }

    void becomeWorthless() {
        this.quality = Quality.MIN;
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
        return this.name + ", " + this.remainingDaysBeforeExpiration + ", " + this.quality.getValue();
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
