package com.gildedrose

class GildedRose(val items: Array[Item]) {

  def setMaxQuality(item: Item, updateValue: Int, maxQuality: Int): Item = {
    item.quality += updateValue
    item.quality = item.quality min maxQuality
    item
  }

  def updateQuality(): Unit = {
    items.foreach {
      case Item("Sulfuras, Hand of Ragnaros", _, _) =>
      case item@Item("Aged Brie", sellIn, quality) if quality <= 50 & sellIn >= 0 =>
        item.sellIn -= 1
        setMaxQuality(item, 1, 50)
      case item@Item("Aged Brie", sellIn, quality) if quality <= 50 & sellIn < 0 =>
        item.sellIn -= 1
        setMaxQuality(item, 2, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 10 =>
        item.sellIn -= 1
        setMaxQuality(item, 1, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 5 =>
        item.sellIn -= 1
        setMaxQuality(item, 2, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 0 =>
        item.sellIn -= 1
        setMaxQuality(item, 3, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, _) if sellIn <= 0 =>
        item.sellIn -= 1
        item.quality = 0
      case item@Item(_, sellIn, quality) if sellIn > 0 && quality > 0 =>
        item.sellIn -= 1
        item.quality -= 1
      case item@Item(_, sellIn, quality) if sellIn <= 0 && quality > 0 =>
        item.sellIn -= 1
        item.quality -= 2
      case _ =>
    }
  }
}