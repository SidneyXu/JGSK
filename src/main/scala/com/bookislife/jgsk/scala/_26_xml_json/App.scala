package com.bookislife.jgsk.scala._26_xml_json

import scala.xml.dtd.{DocType, PublicID}
import scala.xml.{NodeBuffer, PrettyPrinter, XML}

/**
 * Created by SidneyXu on 2015/10/13.
 */
object App {

    def main(args: Array[String]) {
        createXml()
        parseXml()
    }

    def createXml(): Unit = {
        println("========invoke createXml()========")

        //  Simple Creator
        val langType = "current"
        val langs =
            <langs type={langType}>
                <language>Java</language>
                <language>Groovy</language>
                <language>Scala</language>
                <language>Kotlin</language>
            </langs>
        val printer = new PrettyPrinter(80, 4)
        println(printer.format(langs))
        println(scala.xml.Utility.trim(langs))

        val langLst = List("Java", "Groovy", "Scala", "kotlin")
        val xml =
            <langs type={langType}>
                {langLst.map(l =>
                <language>
                    {l}
                </language>
            )}
            </langs>
        println(printer.format(xml))

        //  NodeBuffer
        var nb = new NodeBuffer
        nb += <language>Java</language>
        nb += <language>Groovy</language>
        nb = nb &+ <language>Scala</language> &+ <language>Kotlin</language>
        val langs3 =
            <langs>
                {nb}
            </langs>
        println(printer.format(xml))

        //  Output
        val doctype = DocType("html",
            PublicID("-//W3C//DTD XHTML 1.0 Strict//EN",
                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"),
            Nil)
        XML.save("files/langs.xml", langs3,
            "utf-8", xmlDecl = true, doctype)

        //        val doctype = DocType("html",
        //              PublicID("-//W3C//DTD XHTML 1.0 Strict//EN",
        //                "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"),
        //              Nil)
        //    scala.xml.XML.save("coffeetime-scala/outputs/portfolio.xml", portfolio, "utf-8", true, doctype)
        //
    }

    def parseXml(): Unit = {
        println("========invoke parseXml()========")

        val langs =
            <langs type='current' count='4' mainstream='true'>
                <language flavor='static' version='1.8.0_25'>Java</language>
                <language flavor='dynamic' version='2.4.4'>Groovy</language>
                <language flavor='static' version='2.11.5'>Scala</language>
                <language flavor='static' version='0.12.613'>Kotlin</language>
            </langs>

        

        //        val weather =
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
    }
}
