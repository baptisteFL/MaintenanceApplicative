package com.gildedrose;

class BackstagePasses extends AbstractItem
{
    BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }
        if (item.sellIn < 6) {
            increaseQuality();
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
        decreaseSellIn();
    }
}