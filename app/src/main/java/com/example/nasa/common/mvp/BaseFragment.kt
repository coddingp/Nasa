package com.example.nasa.common.mvp

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes),
    BaseFragmentContract {
    fun changeFragment(fragment: Fragment, id: Int) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction1: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction1.addToBackStack(null)
            .replace(id, fragment)
            .commit()
    }

    // реализация Change fragment from Maxim
    fun hideAndAddFragment(hideFragment: Fragment, addFragment: Fragment, id: Int) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.addToBackStack(null)
            .hide(hideFragment)
            .add(id, addFragment)
            .commit()
    }

    fun clearBackStack() {
        val manager: FragmentManager = requireActivity().supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first = manager.getBackStackEntryAt(0)
            manager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}