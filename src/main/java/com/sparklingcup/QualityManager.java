package com.sparklingcup;

public class QualityManager {
    private static final int MAX_QUALITY = 50;
    private static final int MIN_QUALITY = 0;

    public static void increaseQuality(Item item, int amount) {
        item.quality = Math.min(MAX_QUALITY, item.quality + amount);
    }

    public static void decreaseQuality(Item item, int amount) {
        item.quality = Math.max(MIN_QUALITY, item.quality - amount);
    }

    public static void decrementSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn -= 1;
        }
    }
}
