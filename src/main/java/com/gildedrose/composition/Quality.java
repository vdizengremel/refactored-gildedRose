package com.gildedrose.composition;

public class Quality {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 50;
    public static Quality MIN = new Quality(MIN_VALUE);
    private final int value;

    public int getValue() {
        return value;
    }

    Quality(int value) {
        value = Math.min(value, MAX_VALUE);
        value = Math.max(value, MIN_VALUE);
        this.value = value;
    }

    Quality increaseBy(int increaseValue) {
        return new Quality(this.value + increaseValue);
    }

    public Quality decreaseBy(int decreaseValue) {
        return new Quality(this.value - decreaseValue);
    }
}
