package com.sparklingcup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TexttestFixture {

    Item[] items = new Item[] {
        new Item("+5 Dexterity Vest", 10, 20), 
        new Item("Aged Brie", 2, 0), 
        new Item("Elixir of the Mongoose", 5, 7), 
        new Item("Sulfuras, Hand of Ragnaros", 0, 80), 
        new Item("Sulfuras, Hand of Ragnaros", -1, 80),
        new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        new Item("Conjured Mana Cake", 3, 6)
    };

    SparklingCup app = new SparklingCup(items);

    public static void main(String[] args) {
        TexttestFixture testFixture = new TexttestFixture();
        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : testFixture.items) {
                System.out.println(item);
            }
            System.out.println();
            testFixture.app.updateQuality();
        }

        // Print final state
        System.out.println("-------- final state --------");
        System.out.println("name, sellIn, quality");
        for (Item item : testFixture.items) {
            System.out.println(item);
        }
    }

    @Test
    void testItemsAfterTwoDays() {
        // Run the update for 2 days
        int days = 2;

        for (int i = 0; i < days; i++) {
            app.updateQuality();
        }

        // Assertions for all items after 2 days
        assertEquals(8, items[0].sellIn); // +5 Dexterity Vest
        assertEquals(18, items[0].quality);

        assertEquals(0, items[1].sellIn); // Aged Brie
        assertEquals(2, items[1].quality);

        assertEquals(3, items[2].sellIn); // Elixir of the Mongoose
        assertEquals(5, items[2].quality);

        assertEquals(0, items[3].sellIn); // Sulfuras, Hand of Ragnaros
        assertEquals(80, items[3].quality);

        assertEquals(-1, items[4].sellIn); // Sulfuras, Hand of Ragnaros
        assertEquals(80, items[4].quality);

        assertEquals(13, items[5].sellIn); // Backstage passes to a TAFKAL80ETC concert
        assertEquals(22, items[5].quality);

        assertEquals(8, items[6].sellIn); // Backstage passes to a TAFKAL80ETC concert
        assertEquals(50, items[6].quality);

        assertEquals(3, items[7].sellIn); // Backstage passes to a TAFKAL80ETC concert
        assertEquals(50, items[7].quality);

        assertEquals(1, items[8].sellIn); // Conjured Mana Cake
        assertEquals(2, items[8].quality);
    }

}
