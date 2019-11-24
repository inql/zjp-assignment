package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FunSpec with BeforeAndAfterEach {

  var regular, agedBrie, sulfuras, backstage: Item = Nil
  var gildedRose: GildedRose = _

  override def beforeEach(): Unit = {
    regular = new Item("regular", 7, 7)
    agedBrie = new Item("Aged Brie", 15, 15)
    sulfuras = new Item("Sulfuras, Hand of Ragnaros", 30,80)
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 8)

    gildedRose = new GildedRose(Array(regular,agedBrie,sulfuras,backstage))
  }


}