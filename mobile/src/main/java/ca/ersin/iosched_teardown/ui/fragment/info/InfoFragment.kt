package ca.ersin.iosched_teardown.ui.fragment.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import ca.ersin.iosched_teardown.R
import ca.ersin.iosched_teardown.databinding.FragmentInfoBinding
import ca.ersin.iosched_teardown.ui.MainNavigationFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.AboutFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.EventInfoFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.SettingsFragment
import ca.ersin.iosched_teardown.ui.fragment.info.event.TravelFragment
import dagger.android.support.DaggerFragment

class InfoFragment : DaggerFragment(), MainNavigationFragment {

    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(this@InfoFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            viewpager.offscreenPageLimit = INFO_PAGES.size
            viewpager.adapter = InfoAdapter(childFragmentManager)
            tabs.setupWithViewPager(binding.viewpager)

            trackInfoScreenView(0)
            viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) {}
                override fun onPageScrolled(position: Int, offset: Float, offsetPixels: Int) {}
                override fun onPageSelected(position: Int) {
                    trackInfoScreenView(position)
                }
            })
        }
    }

    private fun trackInfoScreenView(position: Int) {
        val pageName = getString(INFO_TITLES[position])
//        analyticsHelper.sendScreenView("Info - $pageName", requireActivity())
    }

    /**
     * Adapter that builds a page for each info screen.
     */
    inner class InfoAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getCount() = INFO_PAGES.size

        override fun getItem(position: Int) = INFO_PAGES[position]()

        override fun getPageTitle(position: Int): CharSequence {
            return resources.getString(INFO_TITLES[position])
        }
    }

    companion object {
        fun newInstance() = InfoFragment()

        private val TAG: String = InfoFragment::class.java.simpleName
        private val INFO_TITLES = arrayOf(
                R.string.event_title,
                R.string.travel_title,
                R.string.about_title,
                R.string.settings_title
        )
        private val INFO_PAGES = arrayOf(
                { EventInfoFragment() },
                { TravelFragment() },
                { AboutFragment() },
                { SettingsFragment() }
        )
    }
}