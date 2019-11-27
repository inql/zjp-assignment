/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

class DefaultBehaviour(item: Item) extends Behaviour(item){
  override protected def updateQualityValue(): Unit = {
    item.quality = if (item.sellIn <= 0) item.quality - 2 else item.quality - 1
  }
}
