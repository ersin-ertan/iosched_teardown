package ca.ersin.shared

import android.content.Context
import android.util.Log
import kotlin.properties.Delegates

class Analytics(val context: Context) {

    val listeners: MutableList<CounterListener> = mutableListOf()
    var counter: Long by Delegates.observable(0L) { prop, old, new ->
        listeners.forEach {
            it.onCounterChanged(new) }
    }

    fun addListener(l: CounterListener) {
        listeners.add(l)
    }

    fun removeListener(l:CounterListener) {
        listeners.remove(l)
    }

    fun inc(c: Class<*>) {
        counter++
        Log.v("Analytics", "Counter:$counter at ${c.simpleName}")
    }

    interface CounterListener {
        fun onCounterChanged(counter: Long)
    }
}