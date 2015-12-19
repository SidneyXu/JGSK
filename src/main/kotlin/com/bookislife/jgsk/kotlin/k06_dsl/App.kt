package com.bookislife.jgsk.kotlin.k06_dsl

/**
 * Created by SidneyXu on 2015/12/19.
 */
fun main(args: Array<String>) {
    email {
        from ("dsl-guru@mycompany.com")
        to ("john.doe@waitaminute.com")
        subject ("The pope has resigned!")
        body {
            p ("Really, the pope has resigned!")
        }
    }
}

fun email(init: EmailSpec.() -> Unit): EmailSpec {
    val email = EmailSpec()
    email.init()
    return email
}

class EmailSpec {
    fun from(from: String) = println("From: $from")
    fun to(to: String) = println("To: $to")
    fun subject(subject: String) = println("Subject: $subject")
    fun body(init: BodySpec.() -> Unit): BodySpec {
        val body = BodySpec()
        body.init()
        return body
    }
}

class BodySpec {
    fun p(p: String) = println("P: $p")
}