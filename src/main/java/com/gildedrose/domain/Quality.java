package com.gildedrose.domain;

public class Quality {

    private static final int MIN_DEFAULT_VALUE = 0;
    private static final int MAX_DEFAULT_VALUE = 50;
    private final int value;
    private final int minValue;
    private final int maxValue;

    static Quality immutableQualityOf(int value) {
        return new Quality(value, value, value);
    }

    Quality(int value) {
        this(value, MIN_DEFAULT_VALUE, MAX_DEFAULT_VALUE);
    }

    private Quality(int value, int minValue, int maxValue) {
        value = Math.min(value, maxValue);
        value = Math.max(value, minValue);
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getValue() {
        return value;
    }

    Quality increaseBy(int increaseValue) {
        return new Quality(this.value + increaseValue, this.minValue, this.maxValue);
    }

    public Quality decreaseBy(int decreaseValue) {
        return new Quality(this.value - decreaseValue, this.minValue, this.maxValue);
    }

    public Quality min() {
        return new Quality(this.minValue, this.minValue, this.maxValue);
    }
}
