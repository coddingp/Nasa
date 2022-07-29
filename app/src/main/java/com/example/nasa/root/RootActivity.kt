package com.example.nasa.root

import android.os.Bundle
import android.view.WindowManager
import com.example.nasa.R
import com.example.nasa.common.mvp.BaseActivity
import com.example.nasa.main.ui.MainScreenFragment
import timber.log.Timber

class RootActivity() : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.root_activity)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        val mainScreenFragment = MainScreenFragment()
        try {
            changeFragment(mainScreenFragment, R.id.contentContainer)
        } catch (t: Throwable) {
            Timber.i("$t")
        }
    }
}