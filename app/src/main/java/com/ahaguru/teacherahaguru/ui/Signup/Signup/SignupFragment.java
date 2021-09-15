package com.ahaguru.teacherahaguru.ui.Signup.Signup;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentSignupBinding;
import com.ahaguru.teacherahaguru.ui.Manage.Requests.RequestsViewModel;
import com.ahaguru.teacherahaguru.utils.ConstantData;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Collections;

public class SignupFragment extends Fragment {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    NavController navController;
    FragmentSignupBinding binding;
    RequestsViewModel requestsViewModel;
    MultiAutoCompleteTextView multiAutoCompleteTextView;
    ArrayAdapter adapter;

    TextInputLayout fullName, emailAddress, phoneNumber, subject;
    boolean[] selectedSubject;
    ArrayList<Integer> subList = new ArrayList<>();
    String[] selectSub = {"English", "Chemistry", "Mathematics", "Biology"};

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
        binding.getRoot();

        fullName = binding.etFullName;
        phoneNumber = binding.etPhoneNumber;
        emailAddress = binding.etEmailAddress;
        subject = binding.etSubject;

        multiAutoCompleteTextView = binding.multiAutoComplete;

        adapter = new ArrayAdapter(requireContext(), R.layout.dropdown_item, selectSub);

        multiAutoCompleteTextView.setAdapter(adapter);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        preferences = getActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);
        editor = preferences.edit();
        checkSharedPreferences();

        requestsViewModel = new ViewModelProvider(getActivity()).get(RequestsViewModel.class);

        return v;

    }

    private void checkSharedPreferences() {
        String mName = preferences.getString(getString(R.string.mName), "");
        String mPhone = preferences.getString(getString(R.string.mPhone), "");
        String mEmail = preferences.getString(getString(R.string.mEmail), "");
        String mSubject = preferences.getString(getString(R.string.mSubject), "");

        fullName.getEditText().setText(mName);
        phoneNumber.getEditText().setText(mPhone);
        emailAddress.getEditText().setText(mEmail);
        subject.getEditText().setText(mSubject);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        selectedSubject = new boolean[selectSub.length];

        binding.btnNext.setOnClickListener(v -> {

            isAllFieldsChecked = !validateName() | !validatePhone() | !validateEmail() | !validateSubject();

            if (isAllFieldsChecked) {
                return;
            } else {
                String teacherName = fullName.getEditText().getText().toString();
                String teacherPhone = phoneNumber.getEditText().getText().toString();
                String teacherMail = emailAddress.getEditText().getText().toString();

                Teachers teachers = new Teachers(teacherName,teacherPhone, teacherMail, ConstantData.PENDING);
                requestsViewModel.insert(teachers);

                navController.navigate(R.id.action_signupFragment_to_codeFragment);
            }

            // To save name
            String mName = fullName.getEditText().getText().toString();
            editor.putString(getString(R.string.mName), mName);
            editor.commit();

            // To save phone number
            String mPhone = phoneNumber.getEditText().getText().toString();
            editor.putString(getString(R.string.mPhone), mPhone);
            editor.commit();

            // To save email address
            String mEmail = emailAddress.getEditText().getText().toString();
            editor.putString(getString(R.string.mEmail), mEmail);
            editor.commit();

            // To save subject
            String mSubject = subject.getEditText().getText().toString();
            editor.putString(getString(R.string.mSubject), mSubject);
            editor.commit();


        });

        edtListenerValidation();

     }

     private void edtListenerValidation(){
         fullName.getEditText().addTextChangedListener(new TextWatcher() {

             @Override
             public void afterTextChanged(Editable s) {}

             @Override
             public void beforeTextChanged(CharSequence s, int start,
                                           int count, int after) {
             }

             @Override
             public void onTextChanged(CharSequence s, int start,
                                       int before, int count) {
                 validateName();
             }
         });

         phoneNumber.getEditText().addTextChangedListener(new TextWatcher() {

             @Override
             public void afterTextChanged(Editable s) {}

             @Override
             public void beforeTextChanged(CharSequence s, int start,
                                           int count, int after) {
             }

             @Override
             public void onTextChanged(CharSequence s, int start,
                                       int before, int count) {
                 validatePhone();
             }
         });

         emailAddress.getEditText().addTextChangedListener(new TextWatcher() {

             @Override
             public void afterTextChanged(Editable s) {}

             @Override
             public void beforeTextChanged(CharSequence s, int start,
                                           int count, int after) {
             }

             @Override
             public void onTextChanged(CharSequence s, int start,
                                       int before, int count) {
                 validateEmail();
             }
         });

     }

    private boolean validateName() {

        String nameInput = fullName.getEditText().getText().toString();


        if (!nameInput.isEmpty()) {
            fullName.setError(null);
            return true;
        }
        else {
            fullName.setError("Enter your full name");
            return false;
        }
    }

    private boolean validatePhone() {
        String phoneInput = phoneNumber.getEditText().getText().toString();

        if (!phoneInput.isEmpty() && (phoneInput.length() > 5) && (phoneInput.length() <= 10)) {
            phoneNumber.setError(null);
            return true;
        }
        else {
            phoneNumber.setError("Enter the correct phone number");
            return false;
        }
    }


    private boolean validateEmail() {

        String emailInput = emailAddress.getEditText().getText().toString();


        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            emailAddress.setError(null);
            return true;
        } else {
            emailAddress.setError("Enter the valid email address");
            return false;
        }

    }

    private boolean validateSubject() {

        String subjectInput =  subject.getEditText().getText().toString();


        if (!subjectInput.isEmpty()) {
            subject.setError(null);
            return true;
        } else {
            subject.setError("Select the subject");
            return false;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}