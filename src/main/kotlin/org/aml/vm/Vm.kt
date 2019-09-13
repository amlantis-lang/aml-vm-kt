package org.aml.vm

class Vm {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    println(Vm().greeting)
}
