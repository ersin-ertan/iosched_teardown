package ca.ersin.iosched_teardown.ui.fragment.info.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.databinding.FragmentInfoEventBinding
import ca.ersin.shared.util.viewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class EventInfoFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    //    @Inject lateinit var snackbarMessageManager: SnackbarMessageManager
    private lateinit var eventInfoViewModel: EventInfoFragmentViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        context ?: return null
        eventInfoViewModel = viewModelProvider(viewModelFactory)

        val binding = FragmentInfoEventBinding.inflate(inflater, container, false).apply {
            viewModel = eventInfoViewModel
            setLifecycleOwner(this@EventInfoFragment)
        }
//        val snackbarLayout = requireActivity().findViewById<FadingSnackbar>(R.id.snackbar)
//        setUpSnackbar(eventInfoViewModel.snackBarMessage, snackbarLayout, snackbarMessageManager)
//
//        // TODO: launch filtered schedule
//        // TODO: launch map
//        // TODO: launch codelabs
//        binding.eventSandbox.apply {
//            onViewSessionsClicked = { _, _ -> Unit }
//            onViewMapClicked = { _, _ -> Unit }
//            onViewCodelabsClicked = { _, _ -> Unit }
//        }
//        binding.eventCodelabs.apply {
//            onViewSessionsClicked = { _, _ -> Unit }
//            onViewMapClicked = { _, _ -> Unit }
//            onViewCodelabsClicked = { _, _ -> Unit }
//        }
//        binding.eventOfficehours.apply {
//            onViewSessionsClicked = { _, _ -> Unit }
//            onViewMapClicked = { _, _ -> Unit }
//            onViewCodelabsClicked = { _, _ -> Unit }
//        }
//        binding.eventAfterhours.apply {
//            onViewSessionsClicked = { _, _ -> Unit }
//            onViewMapClicked = { _, _ -> Unit }
//            onViewCodelabsClicked = { _, _ -> Unit }
//        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        eventInfoViewModel.openUrlEvent.observe(this, Observer {
//            val url = it?.getContentIfNotHandled() ?: return@Observer
//            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
//        })
    }
}

@BindingAdapter("countdownVisibility")
fun countdownVisibility(countdown: View, ignored: Boolean?) {
//    countdown.visibility = if (TimeUtils.conferenceHasStarted()) GONE else VISIBLE
}