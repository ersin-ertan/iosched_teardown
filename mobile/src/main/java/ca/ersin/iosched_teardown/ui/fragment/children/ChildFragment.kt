package ca.ersin.iosched_teardown.ui.fragment.children

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.R
import ca.ersin.shared.Analytics
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ChildFragment : DaggerFragment() {

    @Inject
    lateinit var analytics: Analytics

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var childFragmentViewModel: ChildFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        analytics.inc(this::class.java)

        childFragmentViewModel = viewModelProvider(viewModelFactory)

        return inflater.inflate(R.layout.fragment_child, null, false)
    }

}