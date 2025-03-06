package com.gildedrose;

class ConjuredDecorator extends AbstractItem {
    private final AbstractItem decoratedItem;

    ConjuredDecorator(AbstractItem decoratedItem) {
        super(decoratedItem.item);
        this.decoratedItem = decoratedItem;
    }

    @Override
    protected void updateQuality() {
        decoratedItem.updateQuality();
        decoratedItem.updateQuality(); // Appliquer la dégradation deux fois
        decoratedItem.increaseSellIn();
    }
}