package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class GildedRoseGoldenMasterTest {

    @Test
    void shouldDecreaseSellInWhenAnyNameAndQualityIsZero() {
        OriginalItem[] items = generateItems().toArray(new OriginalItem[0]);
        GildedRoseOriginal app = new GildedRoseOriginal(items);

        for (int i = 0; i < 50; i++) {
            app.updateQuality();
        }

        Approvals.verify(Arrays.stream(items).map(OriginalItem::toString).collect(Collectors.toList()));
    }

    private List<OriginalItem> generateItems() {
        Random random = new Random(50);
        List<OriginalItem> items = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            items.addAll(createItemsOfEachType(random.nextInt(), random.nextInt()));
        }

        return items;
    }

    private List<OriginalItem> createItemsOfEachType(int sellIn, int quality) {
        return List.of(
                new OriginalItem("Foo", sellIn, quality),
                new OriginalItem("Aged Brie", sellIn, quality),
                new OriginalItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality),
                new OriginalItem("Sulfuras, Hand of Ragnaros", sellIn, quality)
        );
    }
}
