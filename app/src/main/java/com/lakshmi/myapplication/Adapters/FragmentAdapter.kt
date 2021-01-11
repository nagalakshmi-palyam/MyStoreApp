package com.lakshmi.myapplication.Adapters

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.lakshmi.myapplication.Fragmets.ViewPagerSecondFragment
import com.lakshmi.myapplication.Fragmets.ViewPagerThirdFragment
import com.lakshmi.myapplication.Fragmets.ViewPagerfirstFragment

class FragmentAdapter(@NonNull fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return ViewPagerfirstFragment()
            }
            1 -> {
                return ViewPagerSecondFragment()

            }
            2 -> {
                return ViewPagerThirdFragment()

            }
        }
        return ViewPagerfirstFragment()
    }

}