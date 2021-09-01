package com.ahaguru.teacherahaguru.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ahaguru.teacherahaguru.MainActivity;
import com.ahaguru.teacherahaguru.R;

public class MainFragment extends Fragment {

    Button btnSignup, btnManageTeachers;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        btnSignup = v.findViewById(R.id.btnSignup);
        btnManageTeachers = v.findViewById(R.id.btnManageTeachers);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(1);

            }
        });

        btnManageTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(6);

            }
        });

        return v;
    }
}