package org.aml.vm.library.system.io

import arrow.core.Option
import arrow.core.toOption
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

    override fun readLine(): Option<String> {
        return wrappedSource.readUtf8Line().toOption()
    }

    override fun readString(charCount: Long): String {
        require(charCount >= 1) { "Requested character count must be at least 1" }
        val buffer = Buffer()
        for (i in 0 until charCount) {
            buffer.writeUtf8CodePoint(wrappedSource.readUtf8CodePoint())
        }
        return buffer.readUtf8()
    }

    override fun close() {
        wrappedSource.close()
    }
}
