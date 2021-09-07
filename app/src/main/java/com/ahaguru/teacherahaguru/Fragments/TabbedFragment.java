package com.ahaguru.teacherahaguru.Fragments;

import android.os.Bundle;


import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;


import com.ahaguru.teacherahaguru.Adapter.PagerAdapter;
import com.ahaguru.teacherahaguru.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;


public class TabbedFragment extends Fragment {


    public TabbedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tabbed, container, false);

        TabLayout tabLayout = v.findViewById(R.id.tabLayout);
        TabItem tabTeachers = v.findViewById(R.id.tabTeachers);
        TabItem tabRequests = v.findViewById(R.id.tabRequests);
        TabItem tabInvite = v.findViewById(R.id.tabInvite);
        ViewPager viewPager = v.findViewById(R.id.viewPager);

//         PagerAdapter pagerAdapter = new
//                PagerAdapter(this.getParentFragmentManager(), this.getLifecycle(),
//                tabLayout.getTabCount());
        PagerAdapter pagerAdapter = new PagerAdapter(this.getParentFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        // To change the tab views

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//                viewPager.setCurrentItem(position);
                tabLayout.setScrollPosition(position,0f,true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return v;
    }

}