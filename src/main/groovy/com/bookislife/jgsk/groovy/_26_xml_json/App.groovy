package com.bookislife.jgsk.groovy._26_xml_json

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder

/**
 * Created by SidneyXu on 2015/10/13.
 */
class App {

    public static void main(String[] args) {
        createJson()
        parseJson()
        createXml()
        parseXml()
    }

    static def createJson() {
        println('========invoke createJson()========')

        //  JSON Object
        def json = new JsonBuilder()
        json.call {
            results {
                result("x")
                result("y")
            }
        }
        println(json.toPrettyString())

        //  JSON Array
        def list = [
                [code: "404", value: "not found"],
                [code: "302", value: "redirect"]
        ]
        def builder = new JsonBuilder(list)
        println builder.toPrettyString()

        //  JSON Object with JSON Array
        def root = new JsonBuilder()
        root {
            data(
                    list.collect {
                        [
                                code : it.code,
                                value: it.value
                        ]
                    }
            )
        }
        println root.toPrettyString()
    }

    static def parseJson() {
        println('========invoke parseJson()========')

        def json = """
{
    "data": [
        {
            "code": "404",
            "value": "not found"
        },
        {
            "code": "302",
            "value": "redirect"
        }
    ]
}
"""
        def result = new JsonSlurper().parseText(json)
        println result.data[0].code     //  404
        println result.data[1].value    //  redirect
    }

    static def createXml() {
        println('========invoke createXml()========')

        //  MarkupBuilder
        def sw = new StringWriter()
        def xml = new MarkupBuilder(sw)
        xml.langs(type: "current") {
            language("Java")
            language("Groovy")
            language("Scala")
            language("Kotlin")
        }
        println(sw)

        //  StreamingMarkupBuilder
        def comment = "<![CDATA[<!-- address is new to this release -->]]>"
        def builder = new StreamingMarkupBuilder()
        builder.encoding = "UTF-8"
        xml = {
            mkp.xmlDeclaration()
            mkp.pi("xml-stylesheet": "type='text/xsl' href='myfile.xslt'")
            mkp.declareNamespace('': 'http://myDefaultNamespace')
            mkp.declareNamespace('app': 'http://someOtherNamespace')
            langs(type: "current") {
                language("Java", flavor: 'static', "app:version": '1.8.0_25')
                language("Groovy", flavor: 'dynamic', "app:version": '2.4.4')
                language("Scala", flavor: 'static', "app:version": '2.11.5')
                language("Kotlin", flavor: 'static', "app:version": '0.12.613')
            }
        }
        def writer = new StringWriter()
        writer << builder.bind(xml)
        println(writer)
    }

    static def parseXml() {
        println('========invoke parseXml()========')

        //  XmlSlurper vs XmlParser
        //  http://stackoverflow.com/questions/7558019/groovy-xmlslurper-vs-xmlparser

        //  XmlParser Sax
        def xml = """
<langs type='current' count='4' mainstream='true'>
  <language flavor='static' version='1.8.0_25'>Java</language>
  <language flavor='dynamic' version='2.4.4'>Groovy</language>
  <language flavor='static' version='2.11.5'>Scala</language>
  <language flavor='static' version='0.12.613'>Kotlin</language>
</langs>
"""
        def langs = new XmlParser().parseText(xml)
        println "count = ${langs.attribute("count")}" //  count=4
        println "count = ${langs.@count}"
        langs.language.each {
            println it.text()
        }
        println()

        //  XmlSlurper Sax Lazy
        def langs2 = new XmlSlurper().parseText(xml)
        println "count = ${langs2.@count}" //  count=4
        langs2.language.each {
            println it.text()
        }
        println langs2.language[1].@flavor   //  dynamic
    }
}
