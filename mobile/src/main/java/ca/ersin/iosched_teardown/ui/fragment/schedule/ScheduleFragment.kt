package ca.ersin.iosched_teardown.ui.fragment.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ca.ersin.iosched_teardown.databinding.FragmentScheduleBinding
import ca.ersin.iosched_teardown.ui.MainNavigationFragment
import ca.ersin.shared.util.activityViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ScheduleFragment : DaggerFragment(), MainNavigationFragment {

    //    companion object {
//        private val COUNT = ConferenceDays.size + 1 // Agenda
//        private val AGENDA_POSITION = COUNT - 1
//        private const val DIALOG_NEED_TO_SIGN_IN = "dialog_need_to_sign_in"
//        private const val DIALOG_CONFIRM_SIGN_OUT = "dialog_confirm_sign_out"
//        private const val DIALOG_SCHEDULE_HINTS = "dialog_schedule_hints"
//    }
//
//    @Inject lateinit var analyticsHelper: AnalyticsHelper
//
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    //
    private lateinit var scheduleViewModel: ScheduleFragmentViewModel

    //    private lateinit var coordinatorLayout: CoordinatorLayout
//
//    @Inject lateinit var snackbarMessageManager: SnackbarMessageManager
//
//    private lateinit var filtersFab: FloatingActionButton
//    private lateinit var viewPager: ViewPager
//    private lateinit var bottomSheetBehavior: BottomSheetBehavior<*>
//    private lateinit var snackbar: FadingSnackbar
//
//    // Stores the labels of the viewpager to avoid unnecessary recreation
//    private var labelsForDays: List<Int>? = null
//
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        scheduleViewModel = activityViewModelProvider(viewModelFactory)
        val binding = FragmentScheduleBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@ScheduleFragment)
//            viewModel = this@ScheduleFragment.scheduleViewModel
        }
        return binding.root
    }
//
//        coordinatorLayout = binding.coordinatorLayout
//        filtersFab = binding.filterFab
//        snackbar = binding.snackbar
//        viewPager = binding.viewpager
//        // We can't lookup bottomSheetBehavior here since it's on a <fragment> tag
//
//        val snackbarPrefViewModel: SnackbarPreferenceViewModel = viewModelProvider(viewModelFactory)
//        setUpSnackbar(scheduleViewModel.snackBarMessage, snackbar, snackbarMessageManager,
//                actionClickListener = {
//                    snackbarPrefViewModel.onStopClicked()
//                })
//
//        scheduleViewModel.navigateToSessionAction.observe(this, EventObserver { sessionId ->
//            openSessionDetail(sessionId)
//        })
//
//        scheduleViewModel.navigateToSignInDialogAction.observe(this, EventObserver {
//            openSignInDialog()
//        })
//
//        scheduleViewModel.navigateToSignOutDialogAction.observe(this, EventObserver {
//            openSignOutDialog()
//        })
//        scheduleViewModel.scheduleUiHintsShown.observe(this, EventObserver {
//            if (!it) {
//                openScheduleUiHintsDialog()
//            }
//        })
//        scheduleViewModel.shouldShowNotificationsPrefAction.observe(this, EventObserver {
//            if (it) {
//                openNotificationsPreferenceDialog()
//            }
//        })
//        scheduleViewModel.transientUiState.observe(this, Observer {
//            updateFiltersUi(it ?: return@Observer)
//        })
//
//        if (savedInstanceState == null) {
//            // VM outlives the UI, so reset this flag when a new Schedule page is shown
//            scheduleViewModel.userHasInteracted = false
//        }
//        scheduleViewModel.currentEvent.observe(this, Observer { eventLocation ->
//            if (!scheduleViewModel.userHasInteracted) {
//                if (eventLocation != null) {
//                    // switch to the current day
//                    binding.viewpager.run {
//                        post {
//                            // this will trigger onPageChanged and log the page view
//                            currentItem = eventLocation.day
//                        }
//                    }
//                } else {
//                    // Showing the default page. Log it.
//                    logAnalyticsPageView(binding.viewpager.currentItem)
//                }
//            }
//        })
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        viewPager.offscreenPageLimit = COUNT - 1
//
//        val appbar: View = view.findViewById(R.id.appbar)
//        val tabs: TabLayout = view.findViewById(R.id.tabs)
//        tabs.setupWithViewPager(viewPager)
//
//        viewPager.addOnPageChangeListener(object : SimpleOnPageChangeListener() {
//            override fun onPageSelected(position: Int) {
//                scheduleViewModel.setIsAgendaPage(position == AGENDA_POSITION)
//                logAnalyticsPageView(position)
//            }
//        })
//
//        bottomSheetBehavior = BottomSheetBehavior.from(view.findViewById(R.id.filter_sheet))
//        filtersFab.setOnClickListener {
//            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//        }
//        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback {
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                val a11yState = if (newState == STATE_EXPANDED) {
//                    View.IMPORTANT_FOR_ACCESSIBILITY_NO_HIDE_DESCENDANTS
//                } else {
//                    View.IMPORTANT_FOR_ACCESSIBILITY_AUTO
//                }
//                viewPager.importantForAccessibility = a11yState
//                appbar.importantForAccessibility = a11yState
//            }
//        })
//
//        scheduleViewModel.labelsForDays.observe(this, Observer<List<Int>> {
//            it ?: return@Observer
//            if (it != labelsForDays) { // Avoid unnecessary recreation.
//                viewPager.adapter = ScheduleAdapter(childFragmentManager, it)
//                labelsForDays = it
//            }
//        })
//
//        if (savedInstanceState == null) {
//            scheduleViewModel.setIsAgendaPage(false)
//        }
//    }
//
//    private fun updateFiltersUi(uiState: TransientUiState) {
//        val showFab = !uiState.isAgendaPage && !uiState.hasAnyFilters
//        val hideable = uiState.isAgendaPage || !uiState.hasAnyFilters
//
//        fabVisibility(filtersFab, showFab)
//        // Set snackbar position depending whether fab/filters show.
//        snackbar.updateLayoutParams<CoordinatorLayout.LayoutParams> {
//            bottomMargin = resources.getDimensionPixelSize(
//                    if (showFab) {
//                        R.dimen.snackbar_margin_bottom_fab
//                    } else {
//                        R.dimen.bottom_sheet_peek_height
//                    }
//            )
//        }
//        bottomSheetBehavior.isHideable = hideable
//        bottomSheetBehavior.skipCollapsed = !uiState.hasAnyFilters
//        if (hideable && bottomSheetBehavior.state == STATE_COLLAPSED) {
//            bottomSheetBehavior.state = STATE_HIDDEN
//        }
//    }
//
//    override fun onBackPressed(): Boolean {
//        if (::bottomSheetBehavior.isInitialized && bottomSheetBehavior.state == STATE_EXPANDED) {
//            // collapse or hide the sheet
//            if (bottomSheetBehavior.isHideable && bottomSheetBehavior.skipCollapsed) {
//                bottomSheetBehavior.state = STATE_HIDDEN
//            } else {
//                bottomSheetBehavior.state = STATE_COLLAPSED
//            }
//            return true
//        }
//        return super.onBackPressed()
//    }
//
//    override fun onUserInteraction() {
//        // Guard against a crash.
//        // Rarely observed the method was called before the ViewModel was initialized.
//        if (::scheduleViewModel.isInitialized) {
//            scheduleViewModel.userHasInteracted = true
//        }
//    }
//
//    private fun openSessionDetail(id: SessionId) {
//        startActivity(SessionDetailActivity.starterIntent(requireContext(), id))
//    }
//
//    private fun openSignInDialog() {
//        val dialog = SignInDialogFragment()
//        dialog.show(requireActivity().supportFragmentManager, DIALOG_NEED_TO_SIGN_IN)
//    }
//
//    private fun openSignOutDialog() {
//        val dialog = SignOutDialogFragment()
//        dialog.show(requireActivity().supportFragmentManager, DIALOG_CONFIRM_SIGN_OUT)
//    }
//
//    private fun openScheduleUiHintsDialog() {
//        val dialog = ScheduleUiHintsDialogFragment()
//        dialog.show(requireActivity().supportFragmentManager, DIALOG_SCHEDULE_HINTS)
//    }
//
//    private fun openNotificationsPreferenceDialog() {
//        val dialog = NotificationsPreferenceDialogFragment()
//        dialog.show(requireActivity().supportFragmentManager, DIALOG_NOTIFICATIONS_PREFERENCE)
//    }
//
//    override fun onStart() {
//        super.onStart()
//        scheduleViewModel.initializeTimeZone()
//    }
//
//    private fun logAnalyticsPageView(position: Int) {
//        val page = if (position == AGENDA_POSITION) "agenda" else "Day ${position + 1}"
//        analyticsHelper.sendScreenView("Schedule - $page", requireActivity())
//    }
//
//    /**
//     * Adapter that builds a page for each conference day.
//     */
//    inner class ScheduleAdapter(fm: FragmentManager, private val labelsForDays: List<Int>) :
//            FragmentPagerAdapter(fm) {
//
//        override fun getCount() = COUNT
//
//        override fun getItem(position: Int): Fragment {
//            return when (position) {
//                AGENDA_POSITION -> ScheduleAgendaFragment()
//                else -> ScheduleDayFragment.newInstance(position)
//            }
//        }
//
//        override fun getPageTitle(position: Int): CharSequence {
//            return when (position) {
//                AGENDA_POSITION -> getString(R.string.agenda)
//                else -> getString(labelsForDays[position])
//            }
//        }
//    }
}