package org.aml.vm.library.system.lang

import arrow.core.Either
import org.aml.vm.library.system.AnyObject
import org.aml.vm.library.system.io.BufferedSourcePort
import org.aml.vm.library.system.io.Eof

class RootReader : Reader {
    override fun read(sourcePort: BufferedSourcePort): AnyObject {
        TODO("Not yet implemented")
    }

    override fun readSyntax(source: Any?, sourcePort: BufferedSourcePort): Either<Eof, SyntaxObject> {
        TODO("Not yet implemented")
    }
}
