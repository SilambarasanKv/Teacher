package com.ahaguru.teacherahaguru.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ahaguru.teacherahaguru.MainActivity;
import com.ahaguru.teacherahaguru.R;


public class RejectedFragment extends Fragment {

    Button buttonStartAgain;

    EditText name, phone, email;

    public RejectedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rejected, container, false);

        buttonStartAgain = v.findViewById(R.id.btnStartAgain);

        name = v.findViewById(R.id.etFullName);
        phone = v.findViewById(R.id.etPhoneNumber);
        email = v.findViewById(R.id.etEmailAddress);

        setHasOptionsMenu(true);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

        buttonStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SignupFragment signupFragment = new SignupFragment();
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.mainLayout, signupFragment);
                    transaction.commit();

                    

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

                    WaitingFragment waitingFragment = new WaitingFragment();
//

                    ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(3);

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
            ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(3);
            return true;
        };
        return super.onOptionsItemSelected(item);
    }
}