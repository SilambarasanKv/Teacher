package com.ahaguru.teacherahaguru;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

import com.ahaguru.teacherahaguru.Fragments.ApprovedFragment;
import com.ahaguru.teacherahaguru.Fragments.CodeFragment;
import com.ahaguru.teacherahaguru.Fragments.MainFragment;
import com.ahaguru.teacherahaguru.Fragments.RejectedFragment;
import com.ahaguru.teacherahaguru.Fragments.SignupFragment;
import com.ahaguru.teacherahaguru.Fragments.TabbedFragment;
import com.ahaguru.teacherahaguru.Fragments.WaitingFragment;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;
import com.ahaguru.teacherahaguru.utils.FragmentStateSaver;

public class MainActivity extends AppCompatActivity {
    public FragmentStateSaver fragmentStateSaver;
    Toolbar toolbar;

    NavController navController;

    NavHostFragment navHostFragment;

    public static TeacherRoomDatabase teacherRoomDatabase;

    MainFragment mainFragment;


    public FragmentStateSaver getFragmentStateSaver() {
        return fragmentStateSaver;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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