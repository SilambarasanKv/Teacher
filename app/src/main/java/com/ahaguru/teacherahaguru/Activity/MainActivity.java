package com.ahaguru.teacherahaguru.Activity;

import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;

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
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();
        NavigationUI.setupActionBarWithNavController(this, navController);

        getSupportActionBar().setElevation(0f);

        preferences = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        editor = preferences.edit();
        editor.clear();
        editor.apply();

    }
}