package org.kodein.di.utils

import kotlin.native.concurrent.ensureNeverFrozen as nativeEnsureNeverFrozen

internal actual fun <T : Any> T.ensureNeverFrozen() = nativeEnsureNeverFrozen()
