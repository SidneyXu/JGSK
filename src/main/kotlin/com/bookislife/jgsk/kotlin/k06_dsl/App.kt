package com.bookislife.jgsk.kotlin.k06_dsl

/**
 * Created by SidneyXu on 2015/12/19.
 */
fun main(args: Array<String>) {
    val m1 = Machine().having(8, "64 bits").os("linux")
    val m2 = Machine().having(4, "32 bits").os("Windows")
    println(m1)
    println(m2)

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

data class Cpu(val core: Int, val arch: String)

class Machine {
    var cpu: Cpu? = null
    var os: String? = null

    fun having(cores: Int, arch: String): Machine {
        cpu = Cpu(cores, arch)
        return this
    }

    fun os(os: String): Machine {
        this.os = os
        return this
    }

    override fun toString(): String {
        return "Machine{cpu=$cpu, os='$os'"
    }

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