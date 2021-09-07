package com.ahaguru.teacherahaguru.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ahaguru.teacherahaguru.Fragments.InviteFragment;
import com.ahaguru.teacherahaguru.Fragments.RequestsFragment;
import com.ahaguru.teacherahaguru.Fragments.TeachersFragment;

import org.jetbrains.annotations.NotNull;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:
                return new TeachersFragment();
            case 1:
                return new RequestsFragment();
            case 2:
                return new InviteFragment();
            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

//    @NonNull
//    @NotNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position) {
//
//            case 0:
//                return new TeachersFragment();
//            case 1:
//                return new RequestsFragment();
//            case 2:
//                return new InviteFragment();
//            default:
//                return null;
//
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return numOfTabs;
//    }
}
