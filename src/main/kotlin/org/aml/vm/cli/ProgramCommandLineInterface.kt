package org.aml.vm.cli

import org.aml.vm.Vm

typealias Arguments = List<String>

interface ProgramCommandLineInterface {
    fun handleArguments(args: Arguments)

    fun printAmlVersion(programName: String, args: Arguments) {
        println("$programName ${Vm.VERSION_NAME}")
    }
}
