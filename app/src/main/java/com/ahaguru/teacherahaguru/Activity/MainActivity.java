package com.ahaguru.teacherahaguru.Activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.utils.FragmentStateSaver;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    public FragmentStateSaver fragmentStateSaver;
    NavController navController;
    NavHostFragment navHostFragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }
}