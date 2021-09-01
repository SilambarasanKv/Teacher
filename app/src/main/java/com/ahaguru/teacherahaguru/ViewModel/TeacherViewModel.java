package com.ahaguru.teacherahaguru.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Repository.TeachersRepository;

import java.util.List;

public class TeacherViewModel extends AndroidViewModel {


    public TeacherViewModel(@NonNull Application application, LiveData<List<Teachers>> mAllTeachers) {
        super(application);
        this.mAllTeachers = mAllTeachers;
    }

    private TeachersRepository mRepository;

    private final LiveData<List<Teachers>> mAllTeachers;

    public TeacherViewModel (Application application) {
        super(application);
        mRepository = new TeachersRepository(application);
        mAllTeachers = mRepository.getAllTeachers();
    }

    public LiveData<List<Teachers>> getAllTeachers() { return mAllTeachers; }

    public void insert(Teachers teachers) { mRepository.insert(teachers); }
}