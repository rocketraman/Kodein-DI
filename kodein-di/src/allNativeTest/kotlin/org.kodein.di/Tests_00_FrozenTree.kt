package org.kodein.di

import kotlin.native.concurrent.freeze
import kotlin.native.concurrent.FreezingException
import kotlin.test.Test
import kotlin.test.assertFailsWith

class Tests_00_FrozenTree {
    class FrozenConstructor(val block: () -> Unit) {
        init { freeze() }
    }

    @Test
    fun test_00_accessSingletonAttemptToFrozeContainer() {
        val di = DI {
            bind<String>() with singleton { "toto" }

            bind<FrozenConstructor>() with singleton {
                FrozenConstructor { instance<String>() }
            }
        }

//        assertFailsWith<FreezingException> {
            di.direct.instance<FrozenConstructor>()
//        }
    }

    @Test
    fun test_01_accessProviderAttemptToFrozeContainer() {
        val di = DI {
            bind<String>() with singleton { "toto" }

            bind<FrozenConstructor>() with provider {
                FrozenConstructor { instance<String>() }
            }
        }

        println(di.direct.instance<FrozenConstructor>())
    }

}