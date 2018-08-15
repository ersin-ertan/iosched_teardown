package ca.ersin.shared

import android.content.Context
import android.util.Log

class Analytics(val context: Context) {
    var counter: Long = 0L
    fun inc(c: Class<*>) {
        counter++
        Log.v("Analytics", "Counter:$counter at ${c.simpleName}")
    }
}