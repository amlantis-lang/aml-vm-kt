package org.aml.vm.library.system.io

import arrow.core.Option
import org.aml.vm.library.system.Char

interface BufferedSourcePort : SourcePort {

    fun readChar(): Char

    fun peekChar(): Char

    fun readString(charCount: Long): String

    fun readLine(): Option<String>
}
