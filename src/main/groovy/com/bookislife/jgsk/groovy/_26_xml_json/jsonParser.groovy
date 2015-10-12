package com.bookislife.jgsk.groovy._26_xml_json

import groovy.json.JsonSlurper

/**
*  Created by SidneyXu on 2015/10/13.
*/
def json = """
{
    "data": [
        {
            "code": "111",
            "value": "222"
        },
        {
            "code": "333",
            "value": "444"
        }
    ]
}
"""
def data = new JsonSlurper().parseText(json)
println data.data[0].code           //111