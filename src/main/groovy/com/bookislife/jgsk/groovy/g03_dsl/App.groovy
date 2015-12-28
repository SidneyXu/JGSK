package com.bookislife.jgsk.groovy.g03_dsl

/**
 * Created by SidneyXu on 2015/12/19.
 */
class App {

    public static void main(String[] args) {
        def m1 = machine() having(8, "64bits") os "Linux"
        def m2 = machine() having(4, "32bits") os "Windows"
        println(m1)
        println(m2)

        email {
            from 'dsl-guru@mycompany.com'
            to 'john.doe@waitaminute.com'
            subject 'The pope has resigned!'
            body {
                p 'Really, the pope has resigned!'
            }
        }
    }

    static def email(Closure closure) {
        def email = new EmailSpec()
        closure.delegate = email
        closure()
    }

    static def machine() {
        new Machine()
    }
}

class Cpu {
    int core
    String arch

    @Override
    public String toString() {
        return "Cpu{" +
                "core=" + core +
                ", arch='" + arch + '\'' +
                '}';
    }
}

class Machine {
    Cpu cpu
    String os

    def having(int cores, String arch) {
        cpu = new Cpu(core: cores, arch: arch)
        this
    }

    def os(String os) {
        this.os = os
        this
    }


    @Override
    public String toString() {
        return "Machine{" +
                "cpu=" + cpu +
                ", os='" + os + '\'' +
                '}';
    }
}

class EmailSpec {
    void from(String from) { println "From: $from" }

    void to(String... to) { println "To: $to" }

    void subject(String subject) { println "Subject: $subject" }

    void body(Closure closure) {
        def bodySpec = new BodySpec()
        closure.delegate = bodySpec
        closure()
    }
}

class BodySpec {
    void p(String p) {
        println("P: $p")
    }
}
