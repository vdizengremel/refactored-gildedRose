package com.gildedrose.composition;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void shouldDecreaseSellInWhenAnyNameAndQualityIsZero() {
        Item item = new Item("Foo", 1, 0);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(new Item("Foo", 0, 0));
    }

    @Test
    void shouldDecreaseSellInAndQualityWhenAnyNameAndQualityIsSuperiorToZero() {
        Item item = new Item("Foo", 1, 1);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(new Item("Foo", 0, 0));
    }

    @Test
    void shouldDecreaseSellInAndQualityWhenSulfuraAndQualityIsSuperiorToZero() {
        Item item = createSulfura(1, 1);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(createSulfura(1, 1));
    }

    private Item createSulfura(int quality, int sellIn) {
        return new Item("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Test
    void shouldDecreaseSellInWhenAgedBrieAndQualityIs50() {
        Item item = buildAgedBrie(1, 50);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(0, 50));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityWhenAgedBrieAndQualityIs49() {
        Item item = buildAgedBrie(1, 49);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(0, 50));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityWhenAgedBrie() {
        Item item = buildAgedBrie(1, 0);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(0, 1));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityBy1WhenBackstageWhenSellInGreaterThan10() {
        Item item = buildBackstage(11, 0);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(10, 1));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityBy1WhenBackstageAndSellInLowerOrEqualTo10AndQualityAlmost50() {
        Item item = buildBackstage(10, 49);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(9, 50));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityBy2WhenBackstageAndSellInLowerOrEqualTo10() {
        Item item = buildBackstage(10, 48);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(9, 50));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityBy1WhenBackstageAndSellInLowerOrEqualTo5AndQualityAlmost50() {
        Item item = buildBackstage(5, 49);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(4, 50));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityBy3WhenBackstageAndSellInLowerOrEqualTo5() {
        Item item = buildBackstage(5, 47);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(4, 50));
    }

    @Test
    void shouldDecreaseSellInWhenAgedBrieAndSellInLowerOrEqualTo0AndQualityAlmost50() {
        Item item = buildAgedBrie(0, 49);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(-1, 50));
    }

    @Test
    void shouldDecreaseSellInAndIncreaseQualityBy2WhenAgedBrieAndSellInLowerOrEqualTo0() {
        int sellIn = 0;
        int quality = 48;
        Item item = buildAgedBrie(sellIn, quality);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(-1, 50));
    }

    private Item buildAgedBrie(int sellIn, int quality) {
        return Item.agedBrie(sellIn, quality);
    }

    @Test
    void shouldDecreaseSellInAndPutQualityTo0WhenBackstageAndSellInLowerOrEqualTo0() {
        Item item = buildBackstage(0, 48);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(-1, 0));
    }

    private Item buildBackstage(int sellIn, int quality) {
        return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Test
    void shouldDecreaseSellInWhenAnyNameAndSellInLowerOrEqualTo0AndQualityIs0() {
        Item item = new Item("Foo", 0, 0);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(new Item("Foo", -1, 0));
    }

    @Test
    void shouldDecreaseSellInAndDecreaseQualityBy2WhenAnyNameAndSellInLowerOrEqualTo0() {
        Item item = new Item("Foo", 0, 5);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(new Item("Foo", -1, 3));
    }

    @Test
    void shouldNotChangeItemWhenSulfuraAndSellInLowerOrEqualTo0() {
        Item item = createSulfura(5, -1);
        GildedRose app = buildGildedRose(item);
        app.updateQuality();
        assertThat(item).usingRecursiveComparison().isEqualTo(createSulfura(5, -1));
    }

    private GildedRose buildGildedRose(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }
}
