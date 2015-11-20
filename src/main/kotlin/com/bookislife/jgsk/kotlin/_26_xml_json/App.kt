package com.bookislife.jgsk.kotlin._26_xml_json

import java.io.ByteArrayInputStream
import javax.xml.parsers.DocumentBuilderFactory

/**
 * Created by SidneyXu on 2015/10/13.
 */
fun main(args: Array<String>) {
    //  Create Xml
    val xml = """
<langs type='current' count='4' mainstream='true'>
  <language flavor='static' version='1.8.0_25'>Java</language>
  <language flavor='dynamic' version='2.4.4'>Groovy</language>
  <language flavor='static' version='2.11.5'>Scala</language>
  <language flavor='static' version='0.12.613'>Kotlin</language>
</langs>
"""

    val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    val doc = builder.parse(ByteArrayInputStream(xml.toByteArray()))
    //TODO
//    println(doc.toXmlString())

    //  Parse Xml
    val langs = doc.getElementsByTagName("langs").item(0)
    println(langs.getAttributes().getNamedItem("count").getNodeValue()) //  4
}