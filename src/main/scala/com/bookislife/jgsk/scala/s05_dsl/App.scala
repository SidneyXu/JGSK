package com.bookislife.jgsk.scala.s05_dsl

/**
  * Created by SidneyXu on 2015/12/17.
  */
object App {

    def main(args: Array[String]): Unit = {
        implicit def int2CpuInt(i: Int): CpuInt = new CpuInt(i)

        val m1 = machine having (8 cores "64bit") os "Linux"
        val m2 = machine having (4 cores "32bit") os "Windows"
        println(m1)
        println(m2)
    }

    def machine() = new Machine()
}


case class Cpu(core: Int, arch: String)

class CpuInt(core: Int) {
    def cores(arch: String): Cpu = {
        Cpu(core, arch)
    }
}

class Machine {
    var cpu: Cpu = null
    var os: String = null

    def having(cpu: Cpu): Machine = {
        this.cpu = cpu
        this
    }

    def os(os: String): Machine = {
        this.os = os
        this
    }

    override def toString = s"Machine($cpu, $os)"
}
