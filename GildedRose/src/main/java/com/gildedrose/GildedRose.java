package com.gildedrose;

class GildedRose {
    AbstractItem[] items;

    public GildedRose(Item[] items) {
        this.items = new AbstractItem[items.length];
        for (int i = 0; i < items.length; i++) {
            this.items[i] = createItem(items[i]);
        }
    }

    private AbstractItem createItem(Item item) {
        AbstractItem abstractItem;
        switch (item.name) {
            case "Aged Brie":
                abstractItem = new AgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                abstractItem = new BackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                abstractItem = new Sulfuras(item);
                break;
            default:
                abstractItem = new NormalItem(item);
                break;
        }
        if (item.name.startsWith("Conjured")) {
            abstractItem = new ConjuredDecorator(abstractItem);
        }
        return abstractItem;
    }

    public void updateQuality() {
        for (AbstractItem item : items) {
            item.updateQuality();
        }
    }
}