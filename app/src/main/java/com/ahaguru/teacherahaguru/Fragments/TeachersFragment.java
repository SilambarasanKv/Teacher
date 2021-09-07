package com.ahaguru.teacherahaguru.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahaguru.teacherahaguru.Adapter.TeachersAdapter;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;

import java.util.List;

public class TeachersFragment extends Fragment {


    TeacherViewModel teacherViewModel;


    RecyclerView recyclerView;
    TeachersAdapter teachersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_teachers, container, false);


        recyclerView = v.findViewById(R.id.teachersRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        teachersAdapter = new TeachersAdapter();
        recyclerView.setAdapter(teachersAdapter);

        teacherViewModel = new ViewModelProvider(getActivity()).get(TeacherViewModel.class);
        teacherViewModel.getAllApprovedTeachers().observe(getViewLifecycleOwner(), new Observer<List<Teachers>>() {
            @Override
            public void onChanged(List<Teachers> list) {
                teachersAdapter.setTeachers(list);
            }
        });

        return v;
    }


}
