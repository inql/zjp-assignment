
/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

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
