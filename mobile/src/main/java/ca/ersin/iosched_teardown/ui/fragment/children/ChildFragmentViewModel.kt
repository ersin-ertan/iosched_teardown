package ca.ersin.iosched_teardown.ui.fragment.children

import android.content.Context
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ca.ersin.shared.Analytics
import javax.inject.Inject

class ChildFragmentViewModel @Inject constructor(val analytics: Analytics) : ViewModel() {

    val backgroundColor = MutableLiveData<Int>()

    init {
        analytics.inc(this::class.java)
    }

    fun setInitialColor(context: Context){
        backgroundColor.value = ContextCompat.getColor(context, android.R.color.holo_blue_bright)
    }

    fun clicked(v: View) {
        analytics.inc(this::class.java)
        Log.v("ChildFragmentViewModel", "clicked")
        with(backgroundColor) {
            value = if (value == ContextCompat.getColor(v.context, android.R.color.holo_blue_bright)) ContextCompat.getColor(v.context, android.R.color.holo_purple)
            else ContextCompat.getColor(v.context, android.R.color.holo_blue_bright)
        }
    }

}