package com.ahaguru.teacherahaguru.ui.Signup.Code;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ahaguru.teacherahaguru.AsteriskPassword.AsteriskPasswordTransformationMethod;
import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.data.Model.RegisterProfileInput;
import com.ahaguru.teacherahaguru.data.Model.TeacherInput;
import com.ahaguru.teacherahaguru.data.Model.TeacherOutput;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.ApiStatusResponse;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.Resource;
import com.ahaguru.teacherahaguru.databinding.FragmentCodeBinding;
import com.ahaguru.teacherahaguru.ui.Manage.Tabbed.TabbedFragment;
import com.ahaguru.teacherahaguru.utils.ConstantData;
import com.google.android.material.textfield.TextInputLayout;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CodeFragment extends Fragment {

    NavController navController;
    FragmentCodeBinding binding;
    CodeViewModel codeViewModel;
    boolean isAllFieldsChecked = false;
    TextInputLayout code;


    public CodeFragment() {

    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        codeViewModel = new ViewModelProvider(this).get(CodeViewModel.class);

        codeViewModel.registerTeacherProfile().observe(this, new Observer<Resource<ApiStatusResponse>>() {
            @Override
            public void onChanged(Resource<ApiStatusResponse> apiStatusResponseResource) {

                handleRegisterProfileApiResponse(apiStatusResponseResource);

            }
        });
    }

    private void handleRegisterProfileApiResponse(Resource<ApiStatusResponse> apiStatusResponseResource) {

        if (apiStatusResponseResource == null) {
            return;
        }

        switch (apiStatusResponseResource.status) {

            case SUCCESS:
                ApiStatusResponse apiStatusResponse = apiStatusResponseResource.data;

                if (apiStatusResponse.getStatus() == ConstantData.STATUS_CODE_SUCESS) {

                    // go to waiting screen
                    navController.navigate(R.id.action_codeFragment_to_waitingFragment);
                }
                else {
                    Log.e("registerProfile", apiStatusResponse.getMessage());
                }
                break;

            case ERROR:

                apiStatusResponse = apiStatusResponseResource.data;

                if (apiStatusResponse.getStatus() == ConstantData.STATUS_CODE_TOKEN_MISMATCH) {

                    // go to login screen
                    navController.navigate(R.id.action_codeFragment_to_signupFragment);

                    Toast.makeText(requireContext(), "Login expired", Toast.LENGTH_SHORT).show();

                }

                else {
                    Log.e("registerProfile", apiStatusResponse.getMessage());
                }


        }

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
            String subject = CodeFragmentArgs.fromBundle(getArguments()).getTeacherRegistrationSubject();

            // list of subjects
//
            isAllFieldsChecked = !validateCode();

            if (isAllFieldsChecked) {
                return;
            }

            else {

//                Teachers teachers = new Teachers(name, phone, email, contactEmail, ConstantData.REQUESTED);
//                codeViewModel.insert(teachers);

                TeacherInput teacherInput = new TeacherInput(name, phone, email, subject, contactEmail,ConstantData.REQUESTED);

                RegisterProfileInput registerProfileInput = new RegisterProfileInput(ConstantData.PROFILE_TYPE_TEACHER, "YIOPS", teacherInput  );

                codeViewModel.setRegisterProfileInput(registerProfileInput);
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