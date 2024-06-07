package com.sparklingcup.steps;

import com.sparklingcup.Item;
import com.sparklingcup.SparklingCup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private Item[] items;
    private SparklingCup sparklingCup;

    @Given("an item {string} with sellIn {int} and quality {int}")
    public void an_item_with_sellIn_and_quality(String name, int sellIn, int quality) {
        items = new Item[]{new Item(name, sellIn, quality)};
        sparklingCup = new SparklingCup(items);
    }

    @When("the quality is updated")
    public void the_quality_is_updated() {
        sparklingCup.updateQuality();
    }

    @Then("the item should have sellIn {int} and quality {int}")
    public void the_item_should_have_sellIn_and_quality(int expectedSellIn, int expectedQuality) {
        assertEquals(expectedSellIn, items[0].sellIn);
        assertEquals(expectedQuality, items[0].quality);
    }
}
