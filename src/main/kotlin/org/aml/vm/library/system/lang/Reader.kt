package org.aml.vm.library.system.lang

import arrow.core.Either
import org.aml.vm.library.system.io.Eof
import org.aml.vm.library.system.io.SourcePort

interface Reader {

    fun read(sourcePort: SourcePort): Any

    fun readSyntax(sourcePort: SourcePort): Either<Eof, SyntaxObject>

}
