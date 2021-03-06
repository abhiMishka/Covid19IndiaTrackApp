package com.example.covid.helper

import androidx.fragment.app.Fragment
import com.example.covid.R
import com.example.covid.ui.StateWiseFragment
import com.example.covid.ui.HomeFragment
import com.example.covid.ui.TravelHistoryFragment
import com.example.covid.ui.ProfileFragment

enum class BottomNavigationPosition(val position: Int, val id: Int) {
    HOME(0, R.id.home),
    DASHBOARD(1, R.id.dashboard),
    NOTIFICATIONS(2, R.id.notifications),
    PROFILE(3, R.id.profile);
}

fun findNavigationPositionById(id: Int): BottomNavigationPosition = when (id) {
    BottomNavigationPosition.HOME.id -> BottomNavigationPosition.HOME
    BottomNavigationPosition.DASHBOARD.id -> BottomNavigationPosition.DASHBOARD
    BottomNavigationPosition.NOTIFICATIONS.id -> BottomNavigationPosition.NOTIFICATIONS
    BottomNavigationPosition.PROFILE.id -> BottomNavigationPosition.PROFILE
    else -> BottomNavigationPosition.HOME
}

fun BottomNavigationPosition.createFragment(): Fragment = when (this) {
    BottomNavigationPosition.HOME -> HomeFragment.newInstance()
    BottomNavigationPosition.DASHBOARD -> StateWiseFragment.newInstance()
    BottomNavigationPosition.NOTIFICATIONS -> TravelHistoryFragment.newInstance()
    BottomNavigationPosition.PROFILE -> ProfileFragment.newInstance()
}

fun BottomNavigationPosition.getTag(): String = when (this) {
    BottomNavigationPosition.HOME -> HomeFragment.TAG
    BottomNavigationPosition.DASHBOARD -> StateWiseFragment.TAG
    BottomNavigationPosition.NOTIFICATIONS -> TravelHistoryFragment.TAG
    BottomNavigationPosition.PROFILE -> ProfileFragment.TAG
}

