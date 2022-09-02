package com.gildedrose.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    void sulfuraShouldAlwayHaveQualityTo80() {
        Item item = createSulfura();
        assertThat(item.getQuality()).isEqualTo(80);
    }

    @Test
    void sulfuraShouldAlwayHaveQualityTo80EvenAfterIncrease() {
        Item item = createSulfura();

        item.increaseQuality(5);
        assertThat(item.getQuality()).isEqualTo(80);
    }

    @Test
    void sulfuraShouldAlwayHaveQualityTo80EvenAfterDecrease() {
        Item item = createSulfura();

        item.decreaseQuality(5);
        assertThat(item.getQuality()).isEqualTo(80);
    }

    @Test
    void sulfuraCannotBecomeWorthless() {
        Item item = createSulfura();

        item.becomeWorthless();
        assertThat(item.getQuality()).isEqualTo(80);
    }

    private Item createSulfura() {
        return new Item("Sulfuras, Hand of Ragnaros", 10, 10);
    }
}
