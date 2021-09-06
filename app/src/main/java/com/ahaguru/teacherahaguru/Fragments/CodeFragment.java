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
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.MainActivity;
import com.ahaguru.teacherahaguru.AsteriskPassword.AsteriskPasswordTransformationMethod;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.utils.ConstantData;

public class CodeFragment extends Fragment {

 //   TeacherViewModel teacherViewModel;
    Button buttonSubmit;

    EditText code;
    Spinner spin;

    boolean isAllFieldsChecked = false;

    public CodeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_code, container, false);

        spin = (Spinner) v.findViewById(R.id.spinner);

        buttonSubmit = v.findViewById(R.id.btnSubmit);
        code = v.findViewById(R.id.etCode);

        code.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        setHasOptionsMenu(true);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);

//        teacherViewModel = new ViewModelProvider(getActivity()).get(TeacherViewModel.class);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = CheckAllFields();

                if(isAllFieldsChecked) {


                    ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(3);
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


                    ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(1);

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
            ((MainActivity) getActivity()).getFragmentStateSaver().changeFragment(1);
            return true;
        };
        return super.onOptionsItemSelected(item);
    }

    private boolean CheckAllFields() {

        if(code.length() < 8) {
            code.setError("Enter the correct code");
            return false;
        }

        return true;
    }

}