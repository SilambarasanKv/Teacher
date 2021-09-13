package com.ahaguru.teacherahaguru.ui.Signup.Code;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentCodeBinding;

import org.jetbrains.annotations.NotNull;

public class CodeFragment extends Fragment {

    NavController navController;
    FragmentCodeBinding binding;

    boolean isAllFieldsChecked = false;

    public CodeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_code, container, false);
        binding = FragmentCodeBinding.bind(v);

      //  code.setTransformationMethod(new AsteriskPasswordTransformationMethod());


        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.btnSubmit.setOnClickListener(v -> {

            isAllFieldsChecked = !validateCode();

            if (isAllFieldsChecked) {
                return;
            }
            else {
                navController.navigate(R.id.action_codeFragment_to_waitingFragment);
            }

        });
    }

    private boolean validateCode() {

        String codeInput = binding.etCode.getEditText().getText().toString();


        if (!codeInput.isEmpty() && !(codeInput.length() < 8)) {
            binding.etCode.setError(null);
            return true;
        } else {
            binding.etCode.setError("Enter the correct code");
            return false;
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}