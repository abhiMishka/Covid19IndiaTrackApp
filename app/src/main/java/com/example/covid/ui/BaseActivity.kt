package com.example.covid.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity(), CoroutineScope {
    protected lateinit var job: Job


    var rotate : ObjectAnimator? = null

    fun rotateClockwise(view: View?) {
        rotate = ObjectAnimator.ofFloat(view, "rotation", -360f, 0f)
        rotate?.repeatCount = 1000
        rotate?.duration = 5000
        rotate?.start()
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}