package com.ahaguru.teacherahaguru.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.MainActivity;
import com.ahaguru.teacherahaguru.R;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class SignupFragment extends Fragment {

    Button buttonNext;

    TextView fullName, phoneNumber, emailAddress, subjects;

    EditText name, phone, email;

    boolean isAllFieldsChecked = false;

    String[] subLists = { "English","Chemistry","Mathematics","Biology"};

    private String bundleFullname;
    private final String bundleFullnameVAL = "bundleFullnameVAL";

    public static final String EXTRA_REPLY = "com.com.ahaguru.teacherahaguru.teacherlistsql.REPLY";

    public SignupFragment() {

    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    public static SignupFragment newInstance(String param1, String param2) {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_signup, container, false);

        buttonNext = v.findViewById(R.id.btnNext);

        /*fullName = v.findViewById(R.id.tvFullname);
        phoneNumber = v.findViewById(R.id.tvPhoneNumber);
        emailAddress = v.findViewById(R.id.tvEmailAddress);
        subjects = v.findViewById(R.id.tvSubjects);*/

        name = v.findViewById(R.id.etFullName);
        phone = v.findViewById(R.id.etPhoneNumber);
        email = v.findViewById(R.id.etEmailAddress);

        Spinner spin = (Spinner) v.findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, subLists);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(arrayAdapter);

        setHasOptionsMenu(true);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = CheckAllFields();


                if (isAllFieldsChecked) {

                    String teacherName = name.getText().toString();
                    String teacherMail = email.getText().toString();

                    Teachers teachers = new Teachers();
                    teachers.setName(teacherName);
                    teachers.setEmail(teacherMail);

                    MainActivity.teacherRoomDatabase.teacherDao().addTeachers(teachers);

                    ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(2);

                }



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

                    ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(0);

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
            ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(0);
            return true;
        };
        return super.onOptionsItemSelected(item);
    }

    private boolean CheckAllFields() {

        if(name.length() == 0) {
            name.setError("Your name is required");
            return false;
        }

        if(phone.length() < 10) {
            phone.setError("Enter the correct mobile number");
            return false;
        }

        else if(email.length() == 0) {
            email.setError("Your email address is required");
            return false;
        }


        return true;

    }


}