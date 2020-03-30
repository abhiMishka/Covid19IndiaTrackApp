package com.example.covid.ui

import android.animation.ObjectAnimator
import android.view.View
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    var rotate : ObjectAnimator? = null

    fun rotateClockwise(view: View?) {
        rotate = ObjectAnimator.ofFloat(view, "rotation", -360f, 0f)
        rotate?.repeatCount = 1000
        rotate?.duration = 5000
        rotate?.start()
    }

}