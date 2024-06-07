package com.sparklingcup;

public class SparklingCup {
    private static final int LEGENDARY_QUALITY = 80;

    Item[] items;

    public SparklingCup(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            QualityManager.decrementSellIn(item);
            if (item.sellIn < 0) {
                handleExpiredItem(item);
            }
        }
    }

    /**
     * Gère la mise à jour de la qualité en fonction du type d'article.
     */
    private void updateItemQuality(Item item) {
        switch (Item.getItemType(item.name)) {
            case "aged brie":
                QualityManager.increaseQuality(item, 1);
                break;
            case "backstage pass":
                updateBackstagePass(item);
                break;
            case "sulfuras":
                item.quality = LEGENDARY_QUALITY; // La qualité de Sulfuras ne change jamais et reste à 80
                break;
            case "conjured":
                QualityManager.decreaseQuality(item, 2);
                break;
            default:
                QualityManager.decreaseQuality(item, 1);
                break;
        }
    }

    /**
     * Gère la mise à jour de la qualité lorsque la date de péremption est passée.
     */
    private void handleExpiredItem(Item item) {
        switch (Item.getItemType(item.name)) {
            case "aged brie":
                QualityManager.increaseQuality(item, 1);
                break;
            case "backstage pass":
                item.quality = 0;
                break;
            case "sulfuras":
                item.quality = LEGENDARY_QUALITY; // La qualité de Sulfuras ne change jamais et reste à 80
                break;
            case "conjured":
                QualityManager.decreaseQuality(item, 2);
                break;
            default:
                QualityManager.decreaseQuality(item, 1);
                break;
        }
    }

    /**
     * Gère la mise à jour spécifique pour les articles "Backstage pass".
     */
    private void updateBackstagePass(Item item) {
        if (item.sellIn <= 5) {
            QualityManager.increaseQuality(item, 3);
        } else if (item.sellIn <= 10) {
            QualityManager.increaseQuality(item, 2);
        } else {
            QualityManager.increaseQuality(item, 1);
        }
    }
}
