package org.aml.vm.cli

object AmlProfilerCommandLineInterface : ProgramCommandLineInterface {

    const val PROGRAM_NAME: String = "amlprof"

    override fun handleArguments(args: Arguments) {
        if (args.isNotEmpty()) {
            when (args[0]) {
                "--help" -> printHelp(args.drop(1))
                "--version" -> printAmlVersion(PROGRAM_NAME, args.drop(1))
            }
        }
    }

    private fun printHelp(args: Arguments) {
        println("Usage: $PROGRAM_NAME [options] input")
    }
}
