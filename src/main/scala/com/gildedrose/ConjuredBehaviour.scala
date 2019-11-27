/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

class ConjuredBehaviour(item: Item) extends Behaviour(item){
  override protected def updateQualityValue(): Unit = {
    item.quality = if (item.sellIn <= 0) item.quality - 4 else item.quality - 2
  }
}
