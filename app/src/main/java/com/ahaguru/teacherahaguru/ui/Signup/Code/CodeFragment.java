package com.ahaguru.teacherahaguru.ui.Signup.Code;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ahaguru.teacherahaguru.AsteriskPassword.AsteriskPasswordTransformationMethod;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentCodeBinding;
import com.ahaguru.teacherahaguru.ui.Signup.Signup.SignupViewModel;
import com.ahaguru.teacherahaguru.utils.ConstantData;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

public class CodeFragment extends Fragment {

    NavController navController;
    FragmentCodeBinding binding;
    CodeViewModel codeViewModel;
    boolean isAllFieldsChecked = false;

    TextInputLayout code;


    public CodeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_code, container, false);
        binding = FragmentCodeBinding.bind(v);

        code = binding.etCode;

        code.getEditText().setTransformationMethod(new AsteriskPasswordTransformationMethod());

//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Teacher");

        codeViewModel = new ViewModelProvider(getActivity()).get(CodeViewModel.class);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.btnSubmit.setOnClickListener(v -> {

            String name = CodeFragmentArgs.fromBundle(getArguments()).getName();
            String phone = CodeFragmentArgs.fromBundle(getArguments()).getPhone();
            String email = CodeFragmentArgs.fromBundle(getArguments()).getEmail();
            String contactEmail = CodeFragmentArgs.fromBundle(getArguments()).getContactEmail();
            String subject = CodeFragmentArgs.fromBundle(getArguments()).getSubjects();

            isAllFieldsChecked = !validateCode();

            if (isAllFieldsChecked) {
                return;
            }
            else {

                Teachers teachers = new Teachers(name, phone, email, contactEmail, subject, ConstantData.REQUESTED);
                codeViewModel.insert(teachers);

                navController.navigate(R.id.action_codeFragment_to_waitingFragment);
            }

        });

    }

    private boolean validateCode() {

        String codeInput = binding.etCode.getEditText().getText().toString();


        if (!codeInput.isEmpty() && !(codeInput.length() < 8)) {
            code.setError(null);
            return true;
        } else {
            code.setError("Enter the correct code");
            return false;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}