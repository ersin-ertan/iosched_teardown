package ca.ersin.iosched_teardown.ui

interface MainNavigationFragment {

    fun onBackPressed(): Boolean {
        return false
    }

    fun onUserInteraction() {}
}