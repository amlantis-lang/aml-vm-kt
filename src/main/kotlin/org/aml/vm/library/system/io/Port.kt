package org.aml.vm.library.system.io

import org.aml.vm.library.system.AnyObject

interface Port : AnyObject {

    val name: Any

    fun close()
}
