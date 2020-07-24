package org.aml.vm.library.system.io

import okio.Buffer

interface SourcePort : Port {

    fun read(sink: Buffer, byteCount: Long): Long

}
