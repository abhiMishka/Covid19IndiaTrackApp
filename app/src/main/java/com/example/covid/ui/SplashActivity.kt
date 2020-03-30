package com.example.covid.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.covid.R
import com.example.covid.helper.UtilFunctions
import com.example.covid.network.DataManager
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.android.synthetic.main.layout_loading.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        inflateUI()
    }

    private fun inflateUI() {
        laodingTv.text = getString(R.string.loading)
        retryButton.visibility = View.GONE
        if (UtilFunctions.isNetworkAvailable()) {
            rotateClockwise(appIconIv)
            getData()
        } else {
            retryButton.visibility = View.VISIBLE
            laodingTv.text = getString(R.string.no_internet_connection)
            retryButton.setOnClickListener {
                inflateUI()
            }
        }
    }

    private fun getData() {
        GlobalScope.launch {
            DataManager.syncData()
            rotate?.pause()
            openMainActivity()
            finish()
        }
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}
