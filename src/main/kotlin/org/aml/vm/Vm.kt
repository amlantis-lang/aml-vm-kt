package org.aml.vm

import org.aml.vm.cli.CommandLineInterface

class Vm {
    companion object {
        const val VERSION_NAME: String = "1.0.0-alpha01"
    }
}

fun main(args: Array<String>) {
    CommandLineInterface.handleCommandLine(args)
}
