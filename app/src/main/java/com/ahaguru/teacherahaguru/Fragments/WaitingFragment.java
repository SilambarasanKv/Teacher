package com.ahaguru.teacherahaguru.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ahaguru.teacherahaguru.MainActivity;
import com.ahaguru.teacherahaguru.R;


public class WaitingFragment extends Fragment {

    Button buttonApproved, buttonRejected;

    public WaitingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_waiting, container, false);

        buttonApproved = v.findViewById(R.id.btnApproved);
        buttonRejected = v.findViewById(R.id.btnRejected);

        setHasOptionsMenu(true);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

        buttonApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(4);

            }
        });

        buttonRejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(5);

            }
        });

        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.i("tag", "keyCode: " + keyCode);
                if( keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    Log.i("", "onKey Back listener is working!!!");

                    CodeFragment codeFragment = new CodeFragment();
//

                    ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(2);

                    return true;
                }
                return false;
            }
        });


        return v;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(2);
            return true;
        };
        return super.onOptionsItemSelected(item);
    }
}