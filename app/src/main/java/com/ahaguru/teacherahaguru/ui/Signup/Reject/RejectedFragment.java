package com.ahaguru.teacherahaguru.ui.Signup.Reject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentRejectedBinding;

import org.jetbrains.annotations.NotNull;


public class RejectedFragment extends Fragment {

    NavController navController;
    FragmentRejectedBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    RejectedViewModel rejectedViewModel;

    EditText name, phone, email;

    public RejectedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rejected, container, false);
        binding = FragmentRejectedBinding.bind(v);

        preferences = getActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE);

        rejectedViewModel = new ViewModelProvider(getActivity()).get(RejectedViewModel.class);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.btnStartAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor = preferences.edit();
                editor.clear();
                editor.apply();


                navController.navigate(R.id.action_rejectedFragment_to_mainFragment);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}