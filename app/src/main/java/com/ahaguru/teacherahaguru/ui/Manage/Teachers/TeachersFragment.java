package com.ahaguru.teacherahaguru.ui.Manage.Teachers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.databinding.FragmentTeachersBinding;

import java.util.List;

public class TeachersFragment extends Fragment {

    FragmentTeachersBinding binding;
    TeachersViewModel teachersViewModel;
    TeachersAdapter teachersAdapter;
    Menu delete, suspend;

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

        teachersViewModel = new ViewModelProvider(getActivity()).get(TeachersViewModel.class);

        teachersViewModel.getAllApprovedTeachers().observe(getViewLifecycleOwner(), new Observer<List<Teachers>>() {
            @Override
            public void onChanged(List<Teachers> list) {
                teachersAdapter.setTeachers(list);
            }
        });
    }

    public void onDelete(Teachers teacher) {
        teachersViewModel.delete(teacher);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
