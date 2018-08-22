package ca.ersin.iosched_teardown.ui.fragment.info.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ca.ersin.iosched_teardown.R
import dagger.android.support.DaggerFragment

class TravelFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info_travel, container, false)
    }
}