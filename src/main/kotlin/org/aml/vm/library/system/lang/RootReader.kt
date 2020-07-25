package org.aml.vm.library.system.lang

import arrow.core.Either
import okio.EOFException
import org.aml.vm.library.system.AnyObject
import org.aml.vm.library.system.io.BufferedSourcePort
import org.aml.vm.library.system.io.Eof

class RootReader : Reader {
    override fun read(sourcePort: BufferedSourcePort): AnyObject {
        TODO("Not yet implemented")
    }

    override fun readSyntax(source: AnyObject?, sourcePort: BufferedSourcePort): Either<Eof, SyntaxObject> {
        try {
            val firstChar = sourcePort.readChar()
            when (firstChar.c) {
                '#'.toInt() -> {
                    val secondChar = sourcePort.readChar()
                    when (secondChar.c) {
                        // #!comments
                        '!'.toInt() -> {
                            // consume the whole line and ignore it
                            sourcePort.readLine()
                            // TODO: do we want to support line ending with "\", thus ignoring the newline?

                            // recursively use the root reader again
                            return readSyntax(source, sourcePort)
                        }

                        // #reader maybe?
                        'r'.toInt() -> {
                            val formRemainder = sourcePort.readString(5)
                            if (formRemainder == "eader") {
                            }
                            TODO("Not yet implemented")
                        }

                        // #lang maybe?
                        'l'.toInt() -> {
                            val formRemainder = sourcePort.readString(3)
                            if (formRemainder == "ang") {
                            }
                            TODO("Not yet implemented")
                        }
                    }
                }
            }
            TODO("Not yet implemented")

        } catch (eof: EOFException) {
            return Either.left(Eof)
        }
    }
}
