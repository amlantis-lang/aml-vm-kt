package org.aml.vm.library.system.io

import okio.Buffer
import okio.buffer
import okio.source
import org.aml.vm.library.system.Char
import java.io.ByteArrayInputStream

class StringSourcePort(source: String, override val name: Any) : BufferedSourcePort {

    private val wrappedSource = ByteArrayInputStream(source.toByteArray())
            .source().buffer()

    override fun read(sink: Buffer, byteCount: Long): Long = wrappedSource.read(sink, byteCount)

    override fun readChar(): Char {
        return Char(wrappedSource.readUtf8CodePoint())
    }

    override fun peekChar(): Char {
        return wrappedSource.peek().use { peekSource ->
            Char(peekSource.readUtf8CodePoint())
        }
    }

    override fun close() {
        wrappedSource.close()
    }
}
