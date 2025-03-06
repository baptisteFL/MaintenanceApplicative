package com.gildedrose;

class AgedBrie extends AbstractItem
{
    AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        increaseQuality();
        if (item.sellIn < 0) {
            increaseQuality();
        }
        decreaseSellIn();
    }
}