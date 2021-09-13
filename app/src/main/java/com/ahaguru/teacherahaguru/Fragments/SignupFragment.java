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
import com.ahaguru.teacherahaguru.databinding.FragmentSignupBinding;
import com.ahaguru.teacherahaguru.utils.ConstantData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

public class SignupFragment extends Fragment {

    NavController navController;
    ArrayAdapter arrayAdapter;
    FragmentSignupBinding binding;
    TeacherViewModel teacherViewModel;

    public static final String EXTRA_NAME =
            "com.ahaguru.teacherahaguru.Fragments.EXTRA_NAME";
    public static final String EXTRA_EMAIL =
            "com.ahaguru.teacherahaguru.Fragments.EXTRA_EMAIL";

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
        binding = FragmentSignupBinding.bind(v);

        String[] subjects;
        subjects = getResources().getStringArray(R.array.subjects);
        arrayAdapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, subjects);
        binding.autoCompleteTextView.setAdapter(arrayAdapter);

        teacherViewModel = new ViewModelProvider(getActivity()).get(TeacherViewModel.class);

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);


        binding.btnNext.setOnClickListener(v -> {

            isAllFieldsChecked = !validateName() | !validatePhone() | !validateEmail() | !validateSubject();

            if (isAllFieldsChecked) {
                return;
            } else {
                String teacherName = binding.etFullName.getEditText().getText().toString();
                String teacherPhone = binding.etPhoneNumber.getEditText().getText().toString();
                String teacherMail = binding.etEmailAddress.getEditText().getText().toString();

                Teachers teachers = new Teachers(teacherName,teacherPhone, teacherMail, ConstantData.PENDING);
                teacherViewModel.insert(teachers);

                navController.navigate(R.id.action_signupFragment_to_codeFragment);
            }

        });
    }

    private boolean validateName() {

        String nameInput = binding.etFullName.getEditText().getText().toString();


        if (!nameInput.isEmpty()) {
            binding.etFullName.setError(null);
            return true;
        }
        else {
               binding.etFullName.setError("Enter your full name");
               return false;
        }
    }

    private boolean validatePhone() {
        String phoneInput = binding.etPhoneNumber.getEditText().getText().toString();

        if (!phoneInput.isEmpty() && !(phoneInput.length() < 10)) {
            binding.etPhoneNumber.setError(null);
            return true;
        }
        else {
            binding.etPhoneNumber.setError("Enter the correct phone number");
            return false;
        }
    }


    private boolean validateEmail() {

        String emailInput = binding.etEmailAddress.getEditText().getText().toString();


        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            binding.etEmailAddress.setError(null);
            return true;
        } else {
            binding.etEmailAddress.setError("Enter the valid email address");
            return false;
        }

    }

    private boolean validateSubject() {

        String subjectInput =  binding.etSubject.getEditText().getText().toString();


        if (!subjectInput.isEmpty()) {
            binding.etSubject.setError(null);
            return true;
        } else {
            binding.etSubject.setError("Select the subject");
            return false;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}