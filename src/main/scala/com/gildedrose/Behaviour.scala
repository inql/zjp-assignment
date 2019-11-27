
/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

/**
 * Abstract class which create behaviour based on the item name.
 * @param item Item to create a behaviour for.
 */
abstract class Behaviour(item: Item) {

  val maxQuality = 50
  val minQuality = 0

  def update(): Unit = {
    updateQualityValue()
    updateSellInValue()

    item.quality = if (item.quality > maxQuality)  maxQuality
      else if (item.quality < minQuality) minQuality
        else item.quality
  }


  protected def updateQualityValue(): Unit

  protected def updateSellInValue(): Unit = item.sellIn -= 1

}
