package org.aml.vm.library.system.text

import com.ibm.icu.lang.UCharacter
import org.aml.vm.library.system.ValueObject

inline class Character(val c: Int) : ValueObject {

    fun isWhitespace(): Boolean =
        UCharacter.isUWhiteSpace(c)
}
