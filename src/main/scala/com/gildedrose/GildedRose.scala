
/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

/**
 * A class to represent "Gilded Rose" system which is defined to update items.
 * @param items Arrays with defined items
 */
class GildedRose(val items: Array[Item]) {

  /**
   * Constants defined for pattern matching purposes.
   */
  val Sulfuras = "Sulfuras, Hand of Ragnaros"
  val AgedBrie = "Aged Brie"
  val Backstage = "Backstage passes to a TAFKAL80ETC concert"
  val Conjured = "conjured"

  /**
   * A function to avoid exceeding maximum quality of given item.
   * @param item Item to be checked
   * @param updateValue Value to be added to the item's quality.
   * @param maxQuality Maximum quality for given item.
   * @return
   */
  def setMaxQuality(item: Item, updateValue: Int, maxQuality: Int): Item = {
    item.quality += updateValue
    item.quality = item.quality min maxQuality
    item
  }

  /**
   * Main function which defines logic for specific items.
   */

  def updateQuality(): Unit = {
    items.foreach {
      case Item(Sulfuras, _, _) =>
      case item@Item(AgedBrie, sellIn, quality) if quality <= 50 & sellIn >= 0 =>
        item.sellIn -= 1
        setMaxQuality(item, 1, 50)
      case item@Item(AgedBrie, sellIn, quality) if quality <= 50 & sellIn < 0 =>
        item.sellIn -= 1
        setMaxQuality(item, 2, 50)
      case item@Item(Backstage, sellIn, quality) if quality < 50 && sellIn > 10 =>
        item.sellIn -= 1
        setMaxQuality(item, 1, 50)
      case item@Item(Backstage, sellIn, quality) if quality < 50 && sellIn > 5 =>
        item.sellIn -= 1
        setMaxQuality(item, 2, 50)
      case item@Item(Backstage, sellIn, quality) if quality < 50 && sellIn > 0 =>
        item.sellIn -= 1
        setMaxQuality(item, 3, 50)
      case item@Item(Backstage, sellIn, _) if sellIn <= 0 =>
        item.sellIn -= 1
        item.quality = 0
      case item@Item(Conjured, sellIn, quality) if quality > 0 && sellIn > 0 =>
        item.sellIn -= 1
        item.quality -=2
      case item@Item(Conjured, sellIn, quality) if quality > 0 && sellIn <= 0 =>
        item.sellIn -= 1
        item.quality -= 4
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