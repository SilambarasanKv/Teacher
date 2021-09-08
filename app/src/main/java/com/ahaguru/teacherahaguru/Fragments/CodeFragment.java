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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.MainActivity;
import com.ahaguru.teacherahaguru.AsteriskPassword.AsteriskPasswordTransformationMethod;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.utils.ConstantData;

import org.jetbrains.annotations.NotNull;

public class CodeFragment extends Fragment {

    NavController navController;
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

        buttonSubmit = v.findViewById(R.id.btnSubmit);
        code = v.findViewById(R.id.etCode);

        code.setTransformationMethod(new AsteriskPasswordTransformationMethod());


        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        buttonSubmit.setOnClickListener(v -> {

            isAllFieldsChecked = CheckAllFields();

            if (isAllFieldsChecked) {

                navController.navigate(R.id.action_codeFragment_to_waitingFragment);
            }

        });
    }

    private boolean CheckAllFields() {

        if(code.length() < 8) {
            code.setError("Enter the correct code");
            return false;
        }

        return true;
    }

}