package org.aml.vm.library.system.lang

import arrow.core.Either
import org.aml.vm.library.system.AnyObject
import org.aml.vm.library.system.io.BufferedSourcePort
import org.aml.vm.library.system.io.Eof

interface Reader : AnyObject {

    fun read(sourcePort: BufferedSourcePort): AnyObject

    fun readSyntax(sourceName: AnyObject?, sourcePort: BufferedSourcePort): Either<Eof, SyntaxObject>

}
