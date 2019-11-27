/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

class BackstageBehaviour(item: Item) extends Behaviour(item){
  override protected def updateQualityValue: Unit = {
    item.quality = if (item.sellIn < 6) item.quality + 3
      else if (item.sellIn < 11) item.quality + 2
        else item.quality + 1
  }

  override protected def updateSellInValue: Unit = {
    super.updateSellInValue()
    item.quality = if (item.sellIn < 0) 0 else item.quality
  }
}
