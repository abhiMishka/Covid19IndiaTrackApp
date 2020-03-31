package com.example.covid.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.covid.R
import com.example.covid.databinding.ActivityMainBinding
import com.example.covid.extension.active
import com.example.covid.extension.attach
import com.example.covid.extension.detach
import com.example.covid.helper.*
import com.example.covid.network.DataManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    private var navPosition: BottomNavigationPosition = BottomNavigationPosition.HOME

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoreSavedInstanceState(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.toolbar.apply {
            setSupportActionBar(this)
        }

        binding.swipeRefresh.setOnRefreshListener {
            if (UtilFunctions.isNetworkAvailable()) {
                internetBarLayout.visibility = View.GONE
                launch {
                    withContext(Dispatchers.Default) {
                        DataManager.syncData()
                    }
                    binding.swipeRefresh.isRefreshing = false
                    notifyFragmentsDataRefreshed()
                }
            } else {
                internetBarLayout.visibility = View.VISIBLE
                binding.swipeRefresh.isRefreshing = false
            }
        }

        binding.bottomNavigation.apply {
            // This is required in Support Library 27 or lower:
            // bottomNavigation.disableShiftMode()
            active(navPosition.position) // Extension function
            setOnNavigationItemSelectedListener { item ->
                navPosition = findNavigationPositionById(item.itemId)
                switchFragment(navPosition)
            }
        }
        initFragment(savedInstanceState)
    }

    fun disableSwipe() {
        binding.swipeRefresh.setEnabled(false)
    }

    fun enableSwipe() {
        binding.swipeRefresh.setEnabled(true)
    }

    fun notifyFragmentsDataRefreshed() {
        for (fragment in supportFragmentManager.fragments) {
            (fragment as BaseFragment).onDataRefreshed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Store the current navigation position.
        outState.putInt(KEY_POSITION, navPosition.id)
        super.onSaveInstanceState(outState)
    }

    private fun restoreSavedInstanceState(savedInstanceState: Bundle?) {
        // Restore the current navigation position.
        savedInstanceState?.getInt(KEY_POSITION, BottomNavigationPosition.HOME.id)?.also {
            navPosition = findNavigationPositionById(it)
        }
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        savedInstanceState ?: switchFragment(BottomNavigationPosition.HOME)
    }

    /**
     * Immediately execute transactions with FragmentManager#executePendingTransactions.
     */
    private fun switchFragment(navPosition: BottomNavigationPosition): Boolean {
        return findFragment(navPosition).let {
            if (it.isAdded) return false
            supportFragmentManager.detach() // Extension function
            supportFragmentManager.attach(it, navPosition.getTag()) // Extension function
            supportFragmentManager.executePendingTransactions()
        }
    }

    private fun findFragment(position: BottomNavigationPosition): Fragment {
        return supportFragmentManager.findFragmentByTag(position.getTag())
                ?: position.createFragment()
    }


    companion object {
        const val KEY_POSITION = "keyPosition"
    }
}
