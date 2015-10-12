package com.bookislife.jgsk.kotlin._26_xml_json

import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.dom.toXmlString

/**
 * Created by SidneyXu on 2015/10/13.
 */
fun main(args: Array<String>) {
    val f = File("coffeetime-kotlin/src/main/resources/weather.xml")

    val builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
    println(builder.parse(f).toXmlString())
}