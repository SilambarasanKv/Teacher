package com.ahaguru.teacherahaguru.Fragments;


import android.os.Bundle;

import android.util.Patterns;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.utils.ConstantData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class SignupFragment extends Fragment {

    NavController navController;
    ArrayAdapter arrayAdapter;

    public static final String EXTRA_NAME =
            "com.ahaguru.teacherahaguru.Fragments.EXTRA_NAME";
    public static final String EXTRA_EMAIL =
            "com.ahaguru.teacherahaguru.Fragments.EXTRA_EMAIL";

    Button buttonNext;
    TeacherViewModel teacherViewModel;
    EditText name, phone, email;
    AutoCompleteTextView autoCompleteTextView;

    boolean isAllFieldsChecked = false;

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
        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        buttonNext = v.findViewById(R.id.btnNext);


        name = v.findViewById(R.id.etFullName);
        phone = v.findViewById(R.id.etPhoneNumber);
        email = v.findViewById(R.id.etEmailAddress);

        autoCompleteTextView = v.findViewById(R.id.autoCompleteTextView);

        String[] subjects;
        subjects = getResources().getStringArray(R.array.subjects);
        arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, subjects);
        autoCompleteTextView.setAdapter(arrayAdapter);

        teacherViewModel = new ViewModelProvider(getActivity()).get(TeacherViewModel.class);

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        buttonNext.setOnClickListener(v -> {

            isAllFieldsChecked = CheckAllFields();

            if (isAllFieldsChecked) {

                String teacherName = name.getText().toString();
                String teacherPhone = phone.getText().toString();
                String teacherMail = email.getText().toString();

                Teachers teachers = new Teachers(teacherName,teacherPhone, teacherMail, ConstantData.PENDING);
                teacherViewModel.insert(teachers);

                navController.navigate(R.id.action_signupFragment_to_codeFragment);

            }

        });
    }



    private boolean CheckAllFields() {

        String emailInput = email.getText().toString();

        if (name.length() == 0) {
            name.setError("Your name is required");
            return false;
        }

        if (phone.length() < 10) {
            phone.setError("Enter the correct mobile number");
            return false;
        }

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return true;
        } else {
            email.setError("Please enter the valid email address");
            return false;
        }

    }


}