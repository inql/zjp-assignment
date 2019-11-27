/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

class AgedBrieBehaviour(item: Item) extends Behaviour(item){
  override protected def updateQualityValue: Unit = item.quality += 1

  override protected def updateSellInValue: Unit =
    item.sellIn -= 1
    item.quality = if (item.sellIn < 0) item.quality + 1 else item.quality
}
