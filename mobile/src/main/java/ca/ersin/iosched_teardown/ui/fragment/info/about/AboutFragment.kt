package ca.ersin.iosched_teardown.ui.fragment.info.event

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import ca.ersin.iosched_teardown.R
import ca.ersin.iosched_teardown.databinding.FragmentInfoAboutBinding
import dagger.android.support.DaggerFragment

const val SERVICE_ACTION = "android.support.customtabs.action.CustomTabsService"
const val CHROME_PACKAGE = "com.android.chrome"


@BindingAdapter("websiteLink")
fun websiteLink(button: Button, url: String?) {
    url ?: return button.setOnClickListener {
        val context = it.context
        if (context.isChromeCustomTabsSupported()) {
            CustomTabsIntent.Builder().apply {
                setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
                setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            }.build().launchUrl(context, Uri.parse(url))
        } else {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(url)
            }
            context.startActivity(intent, null)
        }
    }
}

@BindingAdapter(value = ["dialogTitle", "fileLink"], requireAll = true)
fun createDialogForFile(button: Button, dialogTitle: String, fileLink: String) {
    val context = button.context
    button.setOnClickListener {
        val webView = WebView(context).apply { loadUrl(fileLink) }
        AlertDialog.Builder(context)
                .setTitle(dialogTitle)
                .setView(webView)
                .create()
                .show()
    }
}

private fun Context.isChromeCustomTabsSupported(): Boolean {
    val serviceIntent = Intent(SERVICE_ACTION)
    serviceIntent.setPackage(CHROME_PACKAGE)
    val resolveInfos = packageManager.queryIntentServices(serviceIntent, 0)
    return !(resolveInfos == null || resolveInfos.isEmpty())
}


class AboutFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            FragmentInfoAboutBinding.inflate(inflater, null, false).apply {
                setLifecycleOwner(this@AboutFragment)
            }.root


}