package com.ahaguru.teacherahaguru.ui.Signup.Waiting;

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

import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentWaitingBinding;
import com.ahaguru.teacherahaguru.ui.Signup.Signup.SignupViewModel;

import org.jetbrains.annotations.NotNull;


public class WaitingFragment extends Fragment {

    NavController navController;
    FragmentWaitingBinding binding;
    WaitingViewModel waitingViewModel;

    public WaitingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_waiting, container, false);
        binding = FragmentWaitingBinding.bind(v);

//        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Teacher");

        waitingViewModel = new ViewModelProvider(getActivity()).get(WaitingViewModel.class);


        return v;

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.btnApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_waitingFragment_to_approvedFragment);

            }
        });

        binding.btnRejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_waitingFragment_to_rejectedFragment);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}