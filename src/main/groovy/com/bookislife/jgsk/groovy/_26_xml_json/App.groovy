package com.bookislife.jgsk.groovy._26_xml_json

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper

/**
 * Created by SidneyXu on 2015/10/13.
 */
class App {

    public static void main(String[] args) {
        createJson()
        parseJson()
    }

    static def createJson() {
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
}
