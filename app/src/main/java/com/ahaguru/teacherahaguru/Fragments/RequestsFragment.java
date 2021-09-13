package com.ahaguru.teacherahaguru.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahaguru.teacherahaguru.Adapter.RequestsAdapter;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.ViewModel.TeacherViewModel;
import com.ahaguru.teacherahaguru.databinding.FragmentRequestsBinding;
import com.ahaguru.teacherahaguru.utils.TeacherRequestListener;

import java.util.ArrayList;
import java.util.List;


public class RequestsFragment extends Fragment implements TeacherRequestListener {
    private List<Teachers> teachers = new ArrayList<>();
    TeacherViewModel teacherViewModel;
    RequestsAdapter requestsAdapter;
    FragmentRequestsBinding binding;
    NavController navController;



    //   List<TeacherViewModel> list = new ArrayList<>();

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_requests, container, false);
        binding = FragmentRequestsBinding.bind(v);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setHasFixedSize(true);

        requestsAdapter = new RequestsAdapter(this);
        binding.recyclerView.setAdapter(requestsAdapter);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teacherViewModel = new ViewModelProvider(getActivity()).get(TeacherViewModel.class);
        teacherViewModel.getAllPendingTeachers().observe(getViewLifecycleOwner(), new Observer<List<Teachers>>() {
            @Override
            public void onChanged(List<Teachers> list) {
                requestsAdapter.setTeachers(list);
            }
        });
    }

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    public void onApprove(Teachers teacher) {
        teacher.setStatus(1);
        teacherViewModel.update(teacher);

        teacherViewModel.getAllPendingTeachers().observe(getViewLifecycleOwner(), new Observer<List<Teachers>>() {
            @Override
            public void onChanged(List<Teachers> list) {
                requestsAdapter.setTeachers(list);
            }
        });

    }

    @Override
    public void onReject(Teachers teacher) {
        teacher.setStatus(2);
        teacherViewModel.update(teacher);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
