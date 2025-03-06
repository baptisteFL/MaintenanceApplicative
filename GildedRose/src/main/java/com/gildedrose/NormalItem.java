package com.gildedrose;

class NormalItem extends AbstractItem {
    NormalItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        decreaseQuality();
        if (item.sellIn < 1) {
            decreaseQuality();
        }
        decreaseSellIn();
    }
}
