package org.aml.vm.library.aml.base

import arrow.core.Either
import arrow.core.right
import okio.EOFException
import org.aml.vm.library.system.AnyObject
import org.aml.vm.library.system.Cons
import org.aml.vm.library.system.io.BufferedSourcePort
import org.aml.vm.library.system.io.Eof
import org.aml.vm.library.system.lang.SyntaxObject
import org.aml.vm.library.system.text.Character
import org.aml.vm.library.system.lang.Reader as LangReader

object Lang {

    class Reader : LangReader {

        override fun read(sourcePort: BufferedSourcePort): AnyObject {
            TODO("Not yet implemented")
        }

        override fun readSyntax(
            sourceName: AnyObject?,
            sourcePort: BufferedSourcePort
        ): Either<Eof, SyntaxObject> {
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
                                return readSyntax(sourceName, sourcePort)
                            }

                            // #reader maybe?
                            'r'.toInt() -> {
                                val formRemainder = sourcePort.readString(5)
                                if (formRemainder == "eader" && consumeSingleWhitespace(sourcePort)) {

                                }
                                TODO("Not yet implemented")
                            }

                            // #lang maybe?
                            'l'.toInt() -> {
                                val formRemainder = sourcePort.readString(3)
                                if (formRemainder == "ang" && consumeSingleWhitespace(sourcePort)) {
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

        // TODO: move sourceName to some "Config" object (and decide what it is, a hash map?)
        private fun readOne(
            sourceName: AnyObject?,
            sourcePort: BufferedSourcePort
        ): Either<Eof, SyntaxObject> {
            val char = readCharSkippingWhitespace(sourcePort)

            // TODO: *THIS* is the default readtable!!! it really does not exist as a separate structure, and readtables are just extra behaviour mappings
            when (char.c) {
                '#'.toInt() -> {
                    // readDispatch(sourceName, sourcePort)
                }
                '('.toInt() -> {
                    return readSequence(sourceName, sourcePort, char, Character(')'.toInt())).right()
                }
                '['.toInt() -> {
                    return readSequence(sourceName, sourcePort, char, Character(']'.toInt())).right()
                }
                '{'.toInt() -> {
                    // readStructure(sourceName, sourcePort)
                }
                '"'.toInt() -> {
                    // readString(sourceName, sourcePort)
                }
                '\''.toInt() -> {
                    // readQuoteOrTypeVariable(sourceName, sourcePort)
                }
                '`'.toInt() -> {
                    // readTagOrSymbol(sourceName, sourcePort)
                }
                '~'.toInt() -> {
                    // readLabel(sourceName, sourcePort)
                }
                else -> {
                    // readSymbolOrNumber(sourceName, sourcePort)
                }
                // ... check specs for more
            }
            TODO("Not yet implemented")
        }

        private fun readSequence(
            sourceName: AnyObject?,
            sourcePort: BufferedSourcePort,
            opener: Character,
            closer: Character
        ): SyntaxObject {
            TODO("Not yet implemented")
        }

        private fun readCharSkippingWhitespace(sourcePort: BufferedSourcePort): Character {
            consumeWhitespace(sourcePort)
            return sourcePort.readChar()
        }

        private fun consumeSingleWhitespace(sourcePort: BufferedSourcePort): Boolean {
            return if (sourcePort.peekChar().isWhitespace()) {
                sourcePort.readChar()
                true
            } else {
                false
            }
        }

        private fun consumeWhitespace(sourcePort: BufferedSourcePort) {
            while (sourcePort.peekChar().isWhitespace()) {
                sourcePort.readChar()
            }
        }
    }
}
