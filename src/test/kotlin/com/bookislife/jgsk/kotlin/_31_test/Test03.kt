package com.bookislife.jgsk.kotlin._31_test

import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals

/**
 * Created by SidneyXu on 2016/08/19.
 */
class Test03 : Spek({

    describe("Spek Showcase") {
        val calculator: Calculator = Calculator()

        context("Arithmetic") {
            afterEach {
                println("Do after a test")
            }

            context("sum") {
                beforeEach {
                    println("Do before sum context")
                }
                it("two numbers") {
                    assertEquals(3, calculator.sum(1, 2))
                }
            }

            xcontext("x for ignoring some test") {
                it("two numbers") {
                    assertEquals(3, calculator.sum(1, 2))
                }
            }

            fcontext("f for testing only specified test") {
                it("two numbers") {
                    assertEquals(3, calculator.sum(1, 2))
                }
            }
        }
    }
})