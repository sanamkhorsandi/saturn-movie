package com.saturn.movie.features.core.util.common

import android.os.Looper

object Utils {


    fun checkMainThread() {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Expected to be called on the main thread but was " + Thread.currentThread().name
        }
    }
}