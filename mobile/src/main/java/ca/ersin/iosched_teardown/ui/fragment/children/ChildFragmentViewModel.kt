package ca.ersin.iosched_teardown.ui.fragment.children

import androidx.lifecycle.ViewModel
import ca.ersin.shared.Analytics
import javax.inject.Inject

class ChildFragmentViewModel @Inject constructor(val analytics: Analytics):ViewModel(){
    init {
        analytics.inc(this::class.java)
    }
}