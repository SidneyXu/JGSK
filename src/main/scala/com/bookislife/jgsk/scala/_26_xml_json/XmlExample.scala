//package com.bookislife.jgsk.scala._26_xml_json
//
///**
//*  Created by SidneyXu on 2015/10/13.
//*/
//object XmlExample extends App {
//
//  def parseXml() {
//    val weather =
//      <rss>
//        <channel>
//          <title>Yahoo! Weather - Boulder, CO</title>
//          <item>
//            <title>Conditions for Boulder, CO at 2:54 pm MST</title>
//            <forecast day="Thu" date="10 Nov 2011" low="37" high="58" text="Partly Cloudy"
//                      code="29"/>
//            <forecast day="Fri" date="11 Nov 2011" low="39" high="58"
//                      text="Mostly Cloudy" code="28"/>
//            <forecast day="Sat" date="12 Nov 2011" low="32" high="49" text="Cloudy"
//                      code="27"/>
//          </item>
//        </channel>
//      </rss>
//
//    val forecast = (weather \ "channel" \ "item" \ "forecast")(0)
//    val day = forecast \ "@day"
//    val low = (weather \\ "forecast")(0) \ "@low"
//    println(forecast) //<forecast day="Thu" date="10 Nov 2011" low="37" high="58" text="Partly Cloudy" code="29"/>
//    println(day, day.getClass) //(Thu,class scala.xml.Group)
//    println(day.text, day.text.getClass) //(Thu,class java.lang.String)
//    println(low) //37
//
//
//    val forecastNodes = weather \\ "forecast"
//    forecastNodes.foreach { n =>
//      val day = (n \ "@day").text
//      val date = (n \ "@date").text
//      val low = (n \ "@low").text
//      println(s"$day, $date, Low: $low")
//    }
//  }
//
//  def serializeAndDeserialize(): Unit = {
//
//    //serialize
//    val aapl = new Stock("AAPL", "Apple", 600d)
//    println(aapl.toXml)
//    //outputs
//    /*
//      <stock>
//        <symbol>AAPL</symbol>
//        <businessName>Apple</businessName>
//        <price>600.0</price>
//      </stock>
//     */
//
//
//    //deserialize
//    val googXml = <stock>
//      <symbol>GOOG</symbol>
//      <businessName>Google</businessName>
//      <price>620.00</price>
//    </stock>
//    val goog = Stock.fromXml(googXml)
//    println(goog) //symbol: GOOG, businessName: Google, price: 620.0
//
//  }
//
//}
