package com.example.bottomnavigation.ui

import android.content.Intent
import android.os.Bundle
import com.example.bottomnavigation.R
import com.example.bottomnavigation.network.DataManager
import kotlinx.android.synthetic.main.layout_loading.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        rotateClockwise(appIconIv)
        GlobalScope.launch {
            DataManager.syncData()
            rotate?.pause()
            openMainActivity()
            finish()
        }
    }

    fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

}
