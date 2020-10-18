package org.aml.vm.library.system.io

import arrow.core.Option
import arrow.core.toOption
import okio.Buffer
import okio.buffer
import okio.source
import org.aml.vm.library.system.text.Character
import java.io.ByteArrayInputStream
import java.io.IOException

class StringSourcePort(source: String, override val name: Any) : BufferedSourcePort {

    private val wrappedSource = ByteArrayInputStream(source.toByteArray())
        .source().buffer()

    @Throws(IOException::class)
    override fun read(sink: Buffer, byteCount: Long): Long = wrappedSource.read(sink, byteCount)

    @Throws(IOException::class)
    override fun readChar(): Character {
        return Character(wrappedSource.readUtf8CodePoint())
    }

    @Throws(IOException::class)
    override fun peekChar(): Character {
        return wrappedSource.peek().use { peekSource ->
            Character(peekSource.readUtf8CodePoint())
        }
    }

    @Throws(IOException::class)
    override fun readLine(): Option<String> {
        return wrappedSource.readUtf8Line().toOption()
    }

    @Throws(IOException::class)
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
