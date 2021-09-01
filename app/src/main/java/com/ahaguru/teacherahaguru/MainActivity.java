package com.ahaguru.teacherahaguru;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.ahaguru.teacherahaguru.Fragments.ApprovedFragment;
import com.ahaguru.teacherahaguru.Fragments.CodeFragment;
import com.ahaguru.teacherahaguru.Fragments.MainFragment;
import com.ahaguru.teacherahaguru.Fragments.RejectedFragment;
import com.ahaguru.teacherahaguru.Fragments.SignupFragment;
import com.ahaguru.teacherahaguru.Fragments.TabbedFragment;
import com.ahaguru.teacherahaguru.Fragments.WaitingFragment;
import com.ahaguru.teacherahaguru.utils.FragmentStateSaver;

public class MainActivity extends AppCompatActivity {
    public FragmentStateSaver fragmentStateSaver;
    Toolbar toolbar;

   // SignupFragment signupFragment;

    MainFragment mainFragment;


    public FragmentStateSaver getFragmentStateSaver() {
        return fragmentStateSaver;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Teacher");

        fragmentStateSaver = new FragmentStateSaver(findViewById(R.id.mainLayout), getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {

                    case 0:
                        return new MainFragment();
                    case 1:
                        return new SignupFragment();
                    case 2:
                        return new CodeFragment();

                    case 3:
                        return new WaitingFragment();

                    case 4:
                        return new ApprovedFragment();

                    case 5:
                        return new RejectedFragment();

                    case 6:
                        return new TabbedFragment();

                    default:
                        return new MainFragment();
                }
            }
        };
        fragmentStateSaver.changeFragment(0);

//        signupFragment = new SignupFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//
//        fragmentManager.beginTransaction().add(R.id.mainLayout, signupFragment).commit();



    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //Save the fragment's instance
        getSupportFragmentManager().putFragment(outState, "mainFragment", mainFragment);
    }



}