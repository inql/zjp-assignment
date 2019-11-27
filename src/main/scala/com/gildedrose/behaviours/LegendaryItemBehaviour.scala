/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose.behaviours

import com.gildedrose.model.Item

class LegendaryItemBehaviour(item: Item) extends Behaviour(item){
  override def update():Unit = {}

  override protected def updateQualityValue(): Unit = {}

  override protected def updateSellInValue(): Unit = {}
}