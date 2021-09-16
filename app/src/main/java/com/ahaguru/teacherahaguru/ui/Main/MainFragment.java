package com.ahaguru.teacherahaguru.ui.Main;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahaguru.teacherahaguru.Activity.MainActivity;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {

    NavController navController;

    FragmentMainBinding binding;


    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        binding = FragmentMainBinding.bind(v);

        v.setFocusableInTouchMode(true);
        v.requestFocus();
        v.setOnKeyListener((v1, keyCode, event) -> {

            getActivity().finish();

            return true;
        });

        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.btnSignup.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_signupFragment));

        binding.btnManageTeachers.setOnClickListener(v ->
                navController.navigate(R.id.action_mainFragment_to_tabbedFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}