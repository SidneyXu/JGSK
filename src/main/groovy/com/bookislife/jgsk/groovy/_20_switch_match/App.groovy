package com.bookislife.jgsk.groovy._20_switch_match

/**
 * Created by SidneyXu on 2015/09/24.
 */
class App {

    public static void main(String[] args) {
        def i = 5 + 5
        def j = 20
        switch (i) {
            case 1:
                println("i is 1")
            case 10:
                println("i is 10")
            case j:
                println("i is 20")
            case 100:
                println("i is 100")
            case 1000:
                println("i is 1000")
                break;
            case 10000:
                println("i is 10000")
            default:
                println("default")
        }

        assert "Object equals" == testSwitch(0)
        assert "Range contains" == testSwitch(15)
        assert "List contains" == testSwitch(3)
        assert "Class instance" == testSwitch(4.5f)
        assert "Closure" == testSwitch(21)
        assert "Pattern match" == testSwitch(910)
    }

    static def testSwitch(var) {
        def result
        switch (var) {
            case 0:
                result = "Object equals"
                break
            case 11..20:
                result = "Range contains"
                break
            case [1, 2, 3]:
                result = "List contains"
                break
            case Float:
                result = "Class instance"
                break
            case { it % 3 == 0 }:
                result = "Closure"
                break
            case ~'[0-9]{3}':
                result = "Pattern match"
                break
            default:
                result = "Default"
                break
        }
        result
    }
}
