package com.bookislife.jgsk.scala._26_xml_json

/**
*  Created by SidneyXu on 2015/10/13.
*/
object XmlExample extends App {

  def parseXml() {
    val weather =
      <rss>
        <channel>
          <title>Yahoo! Weather - Boulder, CO</title>
          <item>
            <title>Conditions for Boulder, CO at 2:54 pm MST</title>
            <forecast day="Thu" date="10 Nov 2011" low="37" high="58" text="Partly Cloudy"
                      code="29"/>
            <forecast day="Fri" date="11 Nov 2011" low="39" high="58"
                      text="Mostly Cloudy" code="28"/>
            <forecast day="Sat" date="12 Nov 2011" low="32" high="49" text="Cloudy"
                      code="27"/>
          </item>
        </channel>
      </rss>

    val forecast = (weather \ "channel" \ "item" \ "forecast")(0)
    val day = forecast \ "@day"
    val low = (weather \\ "forecast")(0) \ "@low"
    println(forecast) //<forecast day="Thu" date="10 Nov 2011" low="37" high="58" text="Partly Cloudy" code="29"/>
    println(day, day.getClass) //(Thu,class scala.xml.Group)
    println(day.text, day.text.getClass) //(Thu,class java.lang.String)
    println(low) //37


    val forecastNodes = weather \\ "forecast"
    forecastNodes.foreach { n =>
      val day = (n \ "@day").text
      val date = (n \ "@date").text
      val low = (n \ "@low").text
      println(s"$day, $date, Low: $low")
    }
  }

  def createSimpleXml() {
    val langs = <langs>
      <lang>Java</lang> <lang>Groovy</lang> <lang>Scala</lang>
    </langs>
    val p = new PrettyPrinter(80, 4)
    println(p.format(langs))
    //outputs
    /*
    <langs>
      <lang>Java</lang>
      <lang>Groovy</lang>
      <lang>Scala</lang>
    </langs>
     */

    println(scala.xml.Utility.trim(langs))
    //<langs><lang>Java</lang><lang>Groovy</lang><lang>Scala</lang></langs>
  }

  def createXmlWithPlaceHolder() {
    //simple place holder
    val name = "Bill"
    val age = 42
    val person = <person>
      <name>
        {name}
      </name> <age>
        {age}
      </age>
    </person>
    val p = new PrettyPrinter(80, 4)
    println(p.format(person))
    //outputs
    /*
    <person>
      <name> Bill </name>
      <age> 42 </age>
    </person>
     */

    //list
    val fruits = List("apple", "banana", "orange")
    val ul = <ul>
      {fruits.map(i => <li>
        {i}
      </li>)}
    </ul>
    println(p.format(ul))
    //outputs
    /*
    <ul>
      <li> apple </li>
      <li> banana </li>
      <li> orange </li>
    </ul>
     */
  }

  def createXmlWithNodeBuf() {
    //nodeBuffer
    val x = new xml.NodeBuffer
    x += <li>apple</li>
    x += <li>banana</li>
    val ul2 = <ul>
      {x}
    </ul>
    val p = new PrettyPrinter(80, 4)
    println(p.format(ul2))
    //outputs
    /*
    <ul>
      <li>apple</li>
      <li>banana</li>
    </ul>
     */

    val nb = new xml.NodeBuffer
    val nb2 = nb &+ <li>apple</li> &+ <li>banana</li> &+ <li>cherry</li>
    val ul3 = <ul>
      {nb2}
    </ul>
    println(p.format(ul3))
    //outputs
    /*
    <ul>
      <li>apple</li>
      <li>banana</li>
      <li>cherry</li>
    </ul>
     */
  }

  def saveXmlToFile(): Unit = {
    val portfolio =
      <portfolio>
        <stocks>
          <stock>AAPL</stock>
          <stock>AMZN</stock>
          <stock>GOOG</stock>
        </stocks>
        <reits>
          <reit>Super REIT 1</reit>
        </reits>
      </portfolio>
    val doctype = DocType("html",
      PublicID("-//W3C//DTD XHTML 1.0 Strict//EN",
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"),
      Nil)
    scala.xml.XML.save("coffeetime-scala/outputs/portfolio.xml", portfolio, "utf-8", true, doctype)
  }

  def serializeAndDeserialize(): Unit = {

    //serialize
    val aapl = new Stock("AAPL", "Apple", 600d)
    println(aapl.toXml)
    //outputs
    /*
      <stock>
        <symbol>AAPL</symbol>
        <businessName>Apple</businessName>
        <price>600.0</price>
      </stock>
     */


    //deserialize
    val googXml = <stock>
      <symbol>GOOG</symbol>
      <businessName>Google</businessName>
      <price>620.00</price>
    </stock>
    val goog = Stock.fromXml(googXml)
    println(goog) //symbol: GOOG, businessName: Google, price: 620.0

  }

}
