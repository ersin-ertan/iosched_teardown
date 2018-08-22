package ca.ersin.iosched_teardown.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.doOnLayout
import androidx.fragment.app.Fragment
import ca.ersin.iosched_teardown.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        // Transition the logo animation (roughly) from the preview window background.
        view.findViewById<ImageView>(R.id.logo).apply {
            val interpolator =
                    AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in)
            alpha = 0.4f
            scaleX = 0.8f
            scaleY = 0.8f
            doOnLayout {
                translationY = height / 3f
                animate()
                        .alpha(1f)
                        .translationY(0f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .interpolator = interpolator
//                playAnimation()
            }
        }
        return view
    }
}