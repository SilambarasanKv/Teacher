package com.ahaguru.teacherahaguru.Fragments;

import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahaguru.teacherahaguru.Adapter.TeachersAdapter;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.databinding.FragmentTeachersBinding;

import java.util.List;

public class TeachersFragment extends Fragment {

    FragmentTeachersBinding binding;
    TeacherViewModel teacherViewModel;
    TeachersAdapter teachersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_teachers, container, false);
        binding = FragmentTeachersBinding.bind(v);


        binding.teachersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.teachersRecyclerView.setHasFixedSize(true);

        teachersAdapter = new TeachersAdapter();
        binding.teachersRecyclerView.setAdapter(teachersAdapter);
        binding.teachersRecyclerView.setItemAnimator(null);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherViewModel = new ViewModelProvider(getActivity()).get(TeacherViewModel.class);
        teacherViewModel.getAllApprovedTeachers().observe(getViewLifecycleOwner(), new Observer<List<Teachers>>() {
            @Override
            public void onChanged(List<Teachers> list) {
                teachersAdapter.setTeachers(list);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
