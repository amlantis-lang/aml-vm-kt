package org.aml.vm.library.system.lang

import arrow.core.Either
import org.aml.vm.library.system.io.Eof
import org.aml.vm.library.system.io.SourcePort

class RootReader : Reader {
    override fun read(sourcePort: SourcePort): Any {
        TODO("Not yet implemented")
    }

    override fun readSyntax(sourcePort: SourcePort): Either<Eof, SyntaxObject> {
        TODO("Not yet implemented")
    }
}
