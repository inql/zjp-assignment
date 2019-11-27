/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

import com.gildedrose.model.Item
import com.gildedrose.service.GildedRose
import org.scalatest._

class GildedRoseTest extends FunSpec with BeforeAndAfterEach {

  var regular, agedBrie, sulfuras, backstage, conjured: Item = _
  var gildedRose: GildedRose = _

  override def beforeEach(): Unit = {
    regular = Item("regular", 7, 7)
    agedBrie = Item("Aged Brie", 15, 15)
    sulfuras = Item("Sulfuras, Hand of Ragnaros", 30,80)
    backstage = Item("Backstage passes to a TAFKAL80ETC concert", 11, 9)
    conjured = Item("conjured", 12, 12)
    gildedRose = new GildedRose(Array(regular,agedBrie,sulfuras,backstage,conjured))
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

    it("should not increase item quality then it's 50"){
      agedBrie.quality = 50
      gildedRose.updateQuality()
      assertResult(50)(agedBrie.quality)
    }

    it("should not decrease sulfuras quality or sellIn value"){
      gildedRose.updateQuality()
      assert(sulfuras.quality == 80 && sulfuras.sellIn == 30)
    }

    it("should increase backstage quality when sellIn value is (10,inf]"){
      gildedRose.updateQuality()
      assertResult(10)(backstage.quality)
    }

    it("should increase backstage quality by 2 when sellIn value is greater than (5,10]"){
      backstage.sellIn = 10
      gildedRose.updateQuality()
      assertResult(11)(backstage.quality)
    }

    it("should increase backstage quality by 3 when sellIn value is greater than (0,5]"){
      backstage.sellIn = 5
      gildedRose.updateQuality()
      assertResult(12)(backstage.quality)
    }

    it("should not increase backstage quality when sellIn value is zero"){
      backstage.sellIn = 0
      gildedRose.updateQuality()
      assertResult(0)(backstage.quality)
    }

    it("should degrade conjured quality by two when the day ends"){
      gildedRose.updateQuality()
      assertResult(10)(conjured.quality)
    }

    it("should degrade conjured quality twice as normal if sellIn <=0"){
      conjured.sellIn = 0
      gildedRose.updateQuality()
      assertResult(8)(conjured.quality)
    }


  }


}