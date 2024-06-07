package com.sparklingcup;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SparklingCupTest {
	@Test
	void foo() {
		Item[] items = new Item[] { new Item("foo", 0, 0) };
		SparklingCup app = new SparklingCup(items);
		app.updateQuality();
		assertEquals("foo", app.items[0].name);
	}
	
	@Test
	void testAgedBrie() {
	    Item[] items = new Item[] { new Item("Aged Brie", 10, 20) };
	    SparklingCup app = new SparklingCup(items);
	    app.updateQuality();
	    assertEquals("Aged Brie", app.items[0].name);
	    assertEquals(9, app.items[0].sellIn);
	    assertEquals(21, app.items[0].quality);
	}
	
    @Test
    public void testAgedBrieQualityIncreaseMax() {
        Item[] items = {new Item("Aged Brie", 10, 50)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }
    
    @Test
    public void testAgedBriehandleExpiredItem() {
        Item[] items = {new Item("Aged Brie", 0, 12)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(14, items[0].quality);
    }
	/**
	 * Teste la mise à jour de la qualité et de la date de péremption d'un article de type "Conjured"
	 * avec une date de péremption de 3 jours et une qualité de 6.
	 */
	@Test
	void testConjuredItem() {
	    Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
	    SparklingCup app = new SparklingCup(items);
	    app.updateQuality();
	    assertEquals("Conjured Mana Cake", app.items[0].name);
	    assertEquals(2, app.items[0].sellIn);
	    assertEquals(4, app.items[0].quality);
	}
	
	   @Test
	    public void testConjuredhandleExpiredItem() {
	        Item[] items = {new Item("Conjured Mana Cake", 0, 10)};
	        SparklingCup sparklingCup = new SparklingCup(items);
	        sparklingCup.updateQuality();
	        assertEquals(-1, items[0].sellIn);
	        assertEquals(6, items[0].quality);
	    }

	    @Test
	    public void testConjuredQualityDecreaseToZero() {
	        Item[] items = {new Item("Conjured Mana Cake", 10, 0)};
	        SparklingCup sparklingCup = new SparklingCup(items);
	        sparklingCup.updateQuality();
	        assertEquals(9, items[0].sellIn);
	        assertEquals(0, items[0].quality);
	    }



    @Test
    public void testBackstagePassQualityIncrease() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(13, items[0].quality);
    }

    @Test
    public void testBackstagePassQualityIncreaseMax() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }
    
    @Test
    public void testBackstagePassQualityIncreaselastElse() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 13, 40)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(12, items[0].sellIn);
        assertEquals(41, items[0].quality);
    }
    
    @Test
    public void testBackstagePasshandleExpiredItem() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    public void testSulfurasQualityUnchanged() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(10, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }
    
    @Test
    public void testSulfurashandleExpiredItem() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", -1, 70)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

 

    @Test
    public void testNormalItemQualityDecrease() {
        Item[] items = {new Item("Normal Item", 10, 10)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(9, items[0].quality);
    }

    @Test
    public void testExpiredItemQualityDegradesTwiceAsFast() {
        Item[] items = {new Item("Normal Item", -1, 10)};
        SparklingCup sparklingCup = new SparklingCup(items);
        sparklingCup.updateQuality();
        assertEquals(8, items[0].quality);
    }

}