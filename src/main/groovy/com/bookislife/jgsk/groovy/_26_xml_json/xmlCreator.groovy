package com.bookislife.jgsk.groovy._26_xml_json

import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder

/**
*  Created by SidneyXu on 2015/10/13.
*/
//---MarkupBuilder----
def sw = new StringWriter()
def xml = new MarkupBuilder(sw)
xml.langs(type: "current") {
    language("Java")
    language("Groovy")
    language("JavaScript")
}
println(sw)

//---StreamingMarkupBuilder---
//more powerful
def comment = "<![CDATA[<!-- address is new to this release -->]]>"
builder = new StreamingMarkupBuilder()
builder.encoding = "UTF-8"
def person = {
    mkp.xmlDeclaration()
    mkp.pi("xml-stylesheet": "type='text/xsl' href='myfile.xslt'")
    mkp.declareNamespace('': 'http://myDefaultNamespace')
    mkp.declareNamespace('location': 'http://someOtherNamespace')
    person(id: 100) {
        firstname("Jane")
        lastname("Doe")
        mkp.yieldUnescaped(comment)
        location.address("123 Main")
    }
}
def writer = new FileWriter("person.xml")
writer << builder.bind(person)