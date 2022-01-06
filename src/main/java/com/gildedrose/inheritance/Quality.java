package com.gildedrose.inheritance;

public class Quality {

    private int value;

    public int getValue() {
        return value;
    }

    Quality(int value) {
        value = Math.min(value, 50);
        value = Math.max(value, 0);
        this.value = value;
    }

    Quality increaseBy(int increaseValue) {
        return new Quality(this.value + increaseValue);
    }

    public Quality decreaseBy(int decreaseValue) {
        return new Quality(this.value - decreaseValue);
    }
}
