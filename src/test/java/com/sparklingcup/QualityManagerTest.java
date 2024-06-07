package com.sparklingcup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QualityManagerTest {

    @Test
    public void testIncreaseQuality() {
        Item item = new Item("Test", 5, 40);
        QualityManager.increaseQuality(item, 5);
        assertEquals(45, item.quality);
    }

    @Test
    public void testIncreaseQuality_MaxQuality() {
        Item item = new Item("Test", 5, 50);
        QualityManager.increaseQuality(item, 5);
        assertEquals(50, item.quality);
    }

    @Test
    public void testDecreaseQuality() {
        Item item = new Item("Test", 5, 40);
        QualityManager.decreaseQuality(item, 5);
        assertEquals(35, item.quality);
    }

    @Test
    public void testDecreaseQuality_MinQuality() {
        Item item = new Item("Test", 5, 0);
        QualityManager.decreaseQuality(item, 5);
        assertEquals(0, item.quality);
    }

    @Test
    public void testDecrementSellIn_NotSulfuras() {
        Item item = new Item("Test", 5, 40);
        QualityManager.decrementSellIn(item);
        assertEquals(4, item.sellIn);
    }

    @Test
    public void testDecrementSellIn_Sulfuras() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 5, 40);
        QualityManager.decrementSellIn(item);
        assertEquals(5, item.sellIn);
    }
}
