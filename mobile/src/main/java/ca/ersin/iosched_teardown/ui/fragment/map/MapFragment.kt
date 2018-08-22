package ca.ersin.iosched_teardown.ui.fragment.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.databinding.FragmentMapBinding
import ca.ersin.iosched_teardown.ui.MainNavigationFragment
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MapFragment : DaggerFragment(), MainNavigationFragment {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var mapFragmentViewModel: MapFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mapFragmentViewModel = viewModelProvider(viewModelFactory)

        return FragmentMapBinding.inflate(inflater, null, false)
                .apply { setLifecycleOwner(this@MapFragment) }
                .root
    }

}