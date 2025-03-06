package com.gildedrose;

public abstract class AbstractItem {
    Item item;

    AbstractItem(Item item) {
        this.item = item;
    }

    protected abstract void updateQuality();

    protected void decreaseSellIn() {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public String getName() {
        return item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public int getQuality() {
        return item.quality;
    }
}