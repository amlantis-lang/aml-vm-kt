package org.aml.vm.library.system.io

import arrow.core.Option
import org.aml.vm.library.system.text.Character
import java.io.IOException

interface BufferedSourcePort : SourcePort {

    @Throws(IOException::class)
    fun readChar(): Character

    @Throws(IOException::class)
    fun peekChar(): Character

    @Throws(IOException::class)
    fun readString(charCount: Long): String

    @Throws(IOException::class)
    fun readLine(): Option<String>
}
