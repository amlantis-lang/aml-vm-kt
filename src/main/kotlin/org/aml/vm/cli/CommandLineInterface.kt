package org.aml.vm.cli

object CommandLineInterface {
    internal fun handleCommandLine(args: Array<String>) {
        val arguments: Arguments = listOfNotNull(*args)
        if (arguments.isNotEmpty()) {
            val cli = when (arguments[0]) {
                AmlCommandLineInterface.PROGRAM_NAME -> AmlCommandLineInterface
                AmlCompilerCommandLineInterface.PROGRAM_NAME -> AmlCompilerCommandLineInterface
                AmlRunCommandLineInterface.PROGRAM_NAME -> AmlRunCommandLineInterface
                AmlDebuggerCommandLineInterface.PROGRAM_NAME -> AmlDebuggerCommandLineInterface
                AmlProfilerCommandLineInterface.PROGRAM_NAME -> AmlProfilerCommandLineInterface
                AmlBuilderCommandLineInterface.PROGRAM_NAME -> AmlBuilderCommandLineInterface
                AmlBookCommandLineInterface.PROGRAM_NAME -> AmlBookCommandLineInterface

                // maybe?
                "amldoc" -> TODO("Not yet implemented")
                "amlopt" -> TODO("Not yet implemented")

                else -> TODO("Not yet implemented")
            }
            cli.handleArguments(arguments.drop(1))
        }
    }
}
