package com.bookislife.jgsk.groovy._26_xml_json

/**
*  Created by SidneyXu on 2015/10/13.
*/
//---XmlParser---
//parse xml file
def langs = new XmlParser().parse("langs.xml")
println "type = ${langs.attribute("type")}"         //type = current
langs.language.each {
    println it.text()
}
println()

//parse xml string
def xml = """
<langs type="current">
  <language>Java</language>
  <language>Groovy</language>
  <language>JavaScript</language>
</langs>
"""
langs = new XmlParser().parseText(xml)
println "type = ${langs.attribute("type")}"
langs.language.each {
    println it.text()
}
println()

xml = """
<langs type='current' count='3' mainstream='true'>
  <language flavor='static' version='1.5'>Java</language>
  <language flavor='dynamic' version='1.6.0'>Groovy</language>
  <language flavor='dynamic' version='1.9'>JavaScript</language>
</langs>
"""
langs = new XmlParser().parseText(xml)
println langs.attribute("count")
langs.language.each {
    println it.text()
}
println()

//---XmlSlurper---
langs = new XmlSlurper().parseText(xml)
println langs.@count //@ like XPATH
langs.language.each {
    println it
}
println langs.language[1].@flavor               //dynamic