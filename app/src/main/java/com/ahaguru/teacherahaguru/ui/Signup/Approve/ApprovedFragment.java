package com.ahaguru.teacherahaguru.ui.Signup.Approve;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentApprovedBinding;

import org.jetbrains.annotations.NotNull;

public class ApprovedFragment extends Fragment {

    FragmentApprovedBinding binding;
    NavController navController;
    AndroidViewModel androidViewModel;

    public ApprovedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_approved, container, false);
        binding = FragmentApprovedBinding.bind(v);

        androidViewModel = new ViewModelProvider(getActivity()).get(ApprovedViewModel.class);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}