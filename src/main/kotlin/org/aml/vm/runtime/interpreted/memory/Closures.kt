package org.aml.vm.runtime.interpreted.memory

interface Header {
    val psi: Any
}

class DataHeader(
    override val psi: Any
) : Header

class ThunkHeader(
    override val psi: Any,
    var updatedValue: Any? = null
) : Header

class Closure(
    val header: DataHeader,
    val payload: Array<Closure>
)

class Thunk(
    val header: ThunkHeader,
    val payload: Array<Closure>
)

class PartialFunctionApplication(
    val header: DataHeader,
    // TODO: add more fields
    val payload: Array<Closure>
)

class FunctionApplication(
    val header: ThunkHeader,
    // TODO: add more fields
    val payload: Array<Closure>
)

class Indirection(
    val header: DataHeader,
    var indirectee: Closure
)
