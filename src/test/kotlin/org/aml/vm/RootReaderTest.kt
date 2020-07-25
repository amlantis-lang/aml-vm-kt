/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.aml.vm

import com.google.common.truth.Truth.assertThat
import org.aml.vm.library.system.io.StringSourcePort
import org.aml.vm.library.system.lang.RootReader
import kotlin.test.Test

class RootReaderTest {

    @Test
    fun testRootReaderCanIgnoreShebangComment() {
        val rootReader = RootReader()
        val result = rootReader.readSyntax(null, StringSourcePort("#!/usb/bin/env aml\n", "string"))
        assertThat(result)
                .isNotNull()
        assertThat(result.isLeft())
                .isTrue()
    }

    @Test
    fun testRootReaderCanDispatchReaderSwitch() {
        val rootReader = RootReader()
        val result = rootReader.readSyntax(null, StringSourcePort("#reader \"test-reader\"\n", "string"))
        assertThat(result)
                .isNotNull()
    }

}
