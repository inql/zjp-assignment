
/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose.model

import com.gildedrose.behaviours._

/**
 * A case class which contains information about specific item.
 *
 * @param name Name of the item.
 * @param sellIn Defines when the item should be sold.
 * @param quality Current quality value.
 */
final case class Item(name: String, var sellIn: Int, var quality: Int)

object ItemFactory {
  def create(item: Item): Behaviour = item.name match {
    case "Sulfuras, Hand of Ragnaros" => new LegendaryItemBehaviour(item)
    case "Aged Brie" => new AgedBrieBehaviour(item)
    case "Backstage passes to a TAFKAL80ETC concert" => new BackstageBehaviour(item)
    case "conjured" => new ConjuredBehaviour(item)
    case _ => new DefaultBehaviour(item)
  }
}