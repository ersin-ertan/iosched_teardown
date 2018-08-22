package ca.ersin.iosched_teardown.ui.fragment.info.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.databinding.FragmentInfoSettingsBinding
import ca.ersin.shared.Analytics
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SettingsFragment : DaggerFragment() {

    @Inject
    lateinit var analytics: Analytics

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var settingsFragmentViewModel: SettingsFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        analytics.inc(this::class.java)

        settingsFragmentViewModel = viewModelProvider(viewModelFactory)

        return FragmentInfoSettingsBinding.inflate(inflater, null, false).apply {
            viewModel = this@SettingsFragment.settingsFragmentViewModel
            setLifecycleOwner(this@SettingsFragment)
        }.root
    }

}