package com.bookislife.jgsk.scala._26_xml_json

import scala.xml.dtd.{DocType, PublicID}
import scala.xml.transform.{RewriteRule, RuleTransformer}
import scala.xml.{Node, NodeBuffer, PrettyPrinter, XML}

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
        <language>Groovy</language>{scala.xml.PCData("<!-- Support Android-->")}<language>Scala</language>
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
    XML.save("files/langs.xml", langs,
      "utf-8", xmlDecl = true, doctype)

    val rewrite = new RuleTransformer(new RewriteRule {
      override def transform(n: Node): Node =
        n match {
          case <language>{l}</language> =>
            <language>{l}!!!</language>
          case other => other
        }
    }
    )
    val result = rewrite.transform(langs)
    println(printer.format(result.head))
  }

  def parseXml(): Unit = {
    println("========invoke parseXml()========")

    val langs =
      <langs type='current' count='4' mainstream='true'>
        <language flavor='static' version='1.8.0_25'>
          <title>Java</title>
        </language>
        <language flavor='dynamic' version='2.4.4'>
          <title>Groovy</title>
        </language>
        <language flavor='static' version='2.11.5'>
          <title>Scala</title>
        </language>
        <language flavor='static' version='0.12.613'>
          <title>Kotlin</title>
        </language>
      </langs>

    val java = (langs \ "language")(0)
    val javaVersion = java \ "@version"
    val javaTitle = (langs \\ "title")(0)
    (langs \ "language" \ "title").foreach(n =>
      println(n.text)
    )
    println(javaVersion)    //  1.8.0_25
    println(javaTitle.text) //  Java

  }
}
