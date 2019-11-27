
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
   * A function which maps all given items into Behaviour wrapper and updates its values.
   */
  def updateQuality(): Unit = {
    items.map(ItemFactory.create).foreach(_.update())
  }
}