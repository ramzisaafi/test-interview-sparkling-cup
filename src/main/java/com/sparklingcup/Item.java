package com.sparklingcup;

import java.util.Date;

public class Item {
	public String name;

	public int sellIn;

	public int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.sellIn = sellIn;
		this.quality = quality;
	}

	public static String getItemType(String name) {
		if (name.equals("Aged Brie")) {
			return "aged brie";
		} else if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
			return "backstage pass";
		} else if (name.equals("Sulfuras, Hand of Ragnaros")) {
			return "sulfuras";
		} else if (name.startsWith("Conjured")) {
			return "conjured";
		} else {
			return "normal";
		}
	}

	@Override
	public String toString() {
		return this.name + ", " + this.sellIn + ", " + this.quality;

	}
}