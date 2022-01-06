package com.gildedrose.composition;

public class SulfuraStrategy implements Strategy {
    @Override
    public boolean isApplicable(Item item) {
        return item.isSulfura();
    }

    @Override
    public void updateQuality(Item item) {
        // Do Nothing
    }
}
