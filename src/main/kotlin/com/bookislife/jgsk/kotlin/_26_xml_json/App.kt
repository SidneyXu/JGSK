package com.bookislife.jgsk.kotlin._26_xml_json

import java.io.ByteArrayInputStream
import java.io.InputStream
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.dom.toXmlString

/**
 * Created by SidneyXu on 2015/10/13.
 */
fun main(args: Array<String>) {
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
    println(doc.toXmlString())

//    println(doc.getElementsByTagName("langs").item(0).getAttributes().getNamedItem("count").getNodeValue())
}