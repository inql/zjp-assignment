package com.gildedrose

import org.scalatest._

class GildedRoseTest extends FunSpec with BeforeAndAfterEach {

  var regular, agedBrie, sulfuras, backstage: Item = _
  var gildedRose: GildedRose = _

  override def beforeEach(): Unit = {
    regular = new Item("regular", 7, 7)
    agedBrie = new Item("Aged Brie", 15, 15)
    sulfuras = new Item("Sulfuras, Hand of Ragnaros", 30,80)
    backstage = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 8)

    gildedRose = new GildedRose(Array(regular,agedBrie,sulfuras,backstage))
  }

  describe("GildedRose"){

    it("should degrade item's quality by one when the day ends"){
      gildedRose.updateQuality()
      assertResult(6)(regular.quality)
    }

    it("should reduce item's sellIn by one then the day ends"){
      gildedRose.updateQuality()
      assertResult(6)(regular.sellIn)
    }

    it("should degrade item's quality twice when sellIn reached zero"){
      regular.sellIn = 0
      gildedRose.updateQuality()
      assertResult(5)(regular.quality)
    }

    it("should item's quality never reach zero"){
      regular.quality = 0
      gildedRose.updateQuality()
      assertResult(0)(regular.quality)
    }

    it("should increase aged brie quality when the day ends"){
      gildedRose.updateQuality()
      assertResult(16)(agedBrie.quality)
    }

    it("should increase aged brie quality twice when sellIn value is lower than zero"){
      agedBrie.sellIn = -1
      gildedRose.updateQuality()
      assertResult(17)(agedBrie.quality)
    }




  }


}