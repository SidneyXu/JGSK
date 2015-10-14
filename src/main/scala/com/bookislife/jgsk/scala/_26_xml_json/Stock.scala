//package com.bookislife.jgsk.scala._26_xml_json
//
///**
//*  Created by SidneyXu on 2015/10/13.
//*/
//class Stock(var symbol: String, var businessName: String, var price: Double) {
//
//  // (a) convert Stock fields to XML
//  def toXml = {
//    <stock>
//      <symbol>{symbol}</symbol>
//      <businessName>{businessName}</businessName>
//      <price>{price}</price>
//    </stock>
//  }
//
//  override def toString =
//    s"symbol: $symbol, businessName: $businessName, price: $price"
//
//}
//
//object Stock {
//
//  // (b) convert XML to a Stock
//  def fromXml(node: scala.xml.Node):Stock = {
//    val symbol = (node \ "symbol").text
//    val businessName = (node \ "businessName").text
//    val price = (node \ "price").text.toDouble
//    new Stock(symbol, businessName, price)
//  }
//
//}