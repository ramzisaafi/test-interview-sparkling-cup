Feature: Update Quality
  Scenario: Update quality of a normal item
    Given an item "Normal Item" with sellIn 5 and quality 10
    When the quality is updated
    Then the item should have sellIn 4 and quality 9

  Scenario: Update quality of an aged brie
    Given an item "Aged Brie" with sellIn 5 and quality 10
    When the quality is updated
    Then the item should have sellIn 4 and quality 11

  Scenario: Update quality of a backstage pass within 10 days of the concert
    Given an item "Backstage passes to a TAFKAL80ETC concert" with sellIn 10 and quality 10
    When the quality is updated
    Then the item should have sellIn 9 and quality 12

  Scenario: Update quality of a backstage pass within 5 days of the concert
    Given an item "Backstage passes to a TAFKAL80ETC concert" with sellIn 5 and quality 10
    When the quality is updated
    Then the item should have sellIn 4 and quality 13

  Scenario: Update quality of a backstage pass after the concert
    Given an item "Backstage passes to a TAFKAL80ETC concert" with sellIn 0 and quality 10
    When the quality is updated
    Then the item should have sellIn -1 and quality 0

  Scenario: Update quality of Sulfuras
    Given an item "Sulfuras, Hand of Ragnaros" with sellIn 5 and quality 80
    When the quality is updated
    Then the item should have sellIn 5 and quality 80

  Scenario: Update quality of a conjured item
    Given an item "Conjured Mana Cake" with sellIn 3 and quality 6
    When the quality is updated
    Then the item should have sellIn 2 and quality 4

  Scenario: Update quality of a conjured item after sellIn date
    Given an item "Conjured Mana Cake" with sellIn 0 and quality 10
    When the quality is updated
    Then the item should have sellIn -1 and quality 6
