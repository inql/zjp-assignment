
/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

class LegendaryItemBehaviour(item: Item) extends Behaviour(item){

  override def update():Unit = {
    updateQualityValue()
  }

  override protected def updateQualityValue(): Unit = {
    //Legendary item never changes it's value so this implementation is empty.
  }
}
