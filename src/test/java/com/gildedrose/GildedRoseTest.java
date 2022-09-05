package com.gildedrose;

import com.gildedrose.domain.Item;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Nested
    class WhenSulfura {
        @Test
        void shouldNotChangeItemWhenSellInIsSuperiorToZero() {
            Item item = createSulfura(1);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(createSulfura(1));
        }

        @Test
        void shouldNotChangeItemWhenSellInLowerOrEqualTo0() {
            Item item = createSulfura(-1);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(createSulfura(-1));
        }

        @Test
        void shouldHaveQualityOf80() {
            Item item = createSulfura(-1);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item.getQuality()).isEqualTo(80);
        }

        private Item createSulfura(int sellIn) {
            return new Item("Sulfuras, Hand of Ragnaros", sellIn, 80);
        }
    }

    @Nested
    class WhenClassicItem {
        @Test
        void shouldOnlyDecreaseSellInWhenQualityIsZero() {
            Item item = buildClassicItem(1, 0);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildClassicItem(0, 0));
        }

        @Test
        void shouldDecreaseSellInAndQualityWhenQualityIsSuperiorToZero() {
            Item item = buildClassicItem(1, 1);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildClassicItem(0, 0));
        }

        @Test
        void shouldOnlyDecreaseSellInWhenSellInLowerOrEqualTo0AndQualityIs0() {
            Item item = buildClassicItem(0, 0);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildClassicItem(-1, 0));
        }

        @Test
        void shouldDecreaseSellInAndDecreaseQualityBy2WhenSellInLowerOrEqualTo0() {
            Item item = buildClassicItem(0, 5);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildClassicItem(-1, 3));
        }

        private Item buildClassicItem(int sellIn, int quality) {
            return new Item("Foo", sellIn, quality);
        }
    }

    @Nested
    class WhenAgedBrie {
        @Test
        void shouldOnlyDecreaseSellInWhenQualityIs50() {
            Item item = buildAgedBrie(1, 50);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(0, 50));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityWhenQualityIsLessThan50() {
            Item item = buildAgedBrie(1, 49);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(0, 50));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityByOneWhenSellInLowerOrEqualTo0AndQualityAlmost50() {
            Item item = buildAgedBrie(0, 49);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(-1, 50));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityBy2WhenSellInLowerOrEqualTo0() {
            int sellIn = 0;
            int quality = 48;
            Item item = buildAgedBrie(sellIn, quality);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildAgedBrie(-1, 50));
        }

        private Item buildAgedBrie(int sellIn, int quality) {
            return new Item("Aged Brie", sellIn, quality);
        }
    }


    @Nested
    class WhenBackstage {
        @Test
        void shouldDecreaseSellInAndIncreaseQualityBy1WhenSellInGreaterThan10() {
            Item item = buildBackstage(11, 0);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(10, 1));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityBy1WhenSellInLowerOrEqualTo10AndQualityAlmost50() {
            Item item = buildBackstage(10, 49);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(9, 50));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityBy2WhenSellInLowerOrEqualTo10() {
            Item item = buildBackstage(10, 48);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(9, 50));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityBy1WhenSellInLowerOrEqualTo5AndQualityAlmost50() {
            Item item = buildBackstage(5, 49);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(4, 50));
        }

        @Test
        void shouldDecreaseSellInAndIncreaseQualityBy3WhenSellInLowerOrEqualTo5() {
            Item item = buildBackstage(5, 47);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(4, 50));
        }


        @Test
        void shouldDecreaseSellInAndPutQualityTo0WhenSellInLowerOrEqualTo0() {
            Item item = buildBackstage(0, 48);
            GildedRose app = buildGildedRose(item);
            app.makeItemsAging();
            assertThat(item).usingRecursiveComparison().isEqualTo(buildBackstage(-1, 0));
        }

        private Item buildBackstage(int sellIn, int quality) {
            return new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
        }
    }

    private GildedRose buildGildedRose(Item item) {
        Item[] items = new Item[]{item};
        return new GildedRose(items);
    }
}
