package com.gildedrose;

class Sulfuras extends AbstractItem {
    Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        return; // Sulfuras ne change pas de qualité
    }
}
