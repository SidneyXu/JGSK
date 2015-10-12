package com.bookislife.jgsk.groovy._26_xml_json

import groovy.json.JsonBuilder

/**
*  Created by SidneyXu on 2015/10/13.
*/
//json object
def json = new JsonBuilder()
json.call {
    results {
        result("x")
        result("y")
    }
}
println(json.toPrettyString())

//json array
def list = [
        [code: "111", value: "222"],
        [code: "333", value: "444"]
]
def builder = new JsonBuilder(list)
println builder.toPrettyString()

//json object with json array
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