package org.aml.vm.library.system.io

import org.aml.vm.library.system.Char

interface BufferedSourcePort : SourcePort {

    fun readChar(): Char

    fun peekChar(): Char

}
