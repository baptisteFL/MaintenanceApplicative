package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest
{

    @Test
    public void testNormalItem()
    {
        Item[] items = new Item[]{new Item("Normal Item", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(19, app.items[0].getQuality());
    }

    @Test
    public void testAgedBrie()
    {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(21, app.items[0].getQuality());
    }

    @Test
    public void testSulfuras()
    {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].getSellIn());
        assertEquals(80, app.items[0].getQuality());
    }

    @Test
    public void testBackstagePasses()
    {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].getSellIn());
        assertEquals(21, app.items[0].getQuality());
    }

    @Test
    public void testBackstagePassesWith10DaysOrLess()
    {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(22, app.items[0].getQuality());
    }

    @Test
    public void testBackstagePassesWith5DaysOrLess()
    {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].getSellIn());
        assertEquals(23, app.items[0].getQuality());
    }

    @Test
    public void testBackstagePassesAfterConcert()
    {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    public void testConjuredItem()
    {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].getSellIn());
        assertEquals(18, app.items[0].getQuality());
    }

    @Test
    public void testConjuredItemAfterSellIn()
    {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 0, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(16, app.items[0].getQuality());
    }
}
