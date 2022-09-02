package com.gildedrose.domain;

public class Item {

    private final String name;
    private int remainingDaysBeforeExpiration; // called sellIn in the original file
    private Quality quality;
    private final UpdateQualityStrategy updateQualityStrategy;

    public Item(String name, int remainingDaysBeforeExpiration, int quality) {
        this.name = name;
        this.remainingDaysBeforeExpiration = remainingDaysBeforeExpiration;
        this.updateQualityStrategy = UpdateQualityStrategy.findFor(this);

        if(isSulfura()) {
            this.quality = Quality.immutableQualityOf(80);
        } else {
            this.quality = new Quality(quality);
        }

    }

    public void ageByOneDay() {
        boolean isNotSulfura = !this.isSulfura();
        if (isNotSulfura) {
            this.remainingDaysBeforeExpiration = this.remainingDaysBeforeExpiration - 1;
            this.updateQualityStrategy.updateQuality(this);
        }
    }

    public int getQuality() {
        return this.quality.getValue();
    }
    boolean isExpired() {
        return this.remainingDaysBeforeExpiration < 0;
    }

    boolean isExpiredInLessThan(int days) {
        return remainingDaysBeforeExpiration < days;
    }

    void becomeWorthless() {
        this.quality = this.quality.min();
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
