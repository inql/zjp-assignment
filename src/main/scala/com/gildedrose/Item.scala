
/*
 * Copyright (c) 2019 Dawid Bińkuś
 * All rights reserved.
 */

package com.gildedrose

/**
 * A case class which contains information about specific item.
 * @param name Name of the item.
 * @param sellIn Defines when the item should be sold.
 * @param quality Current quality value.
 */
final case class Item(name: String, var sellIn: Int, var quality: Int)