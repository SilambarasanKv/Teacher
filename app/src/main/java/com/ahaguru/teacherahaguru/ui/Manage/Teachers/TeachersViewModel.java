package com.ahaguru.teacherahaguru.ui.Manage.Teachers;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Repository.TeachersRepository;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TeachersViewModel extends AndroidViewModel {

    private TeachersRepository repository;

    private LiveData<List<Teachers>> allTeachers2;

    public TeachersViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new TeachersRepository(application);
        allTeachers2 = repository.getAllApprovedTeachers();
    }

    public void delete(Teachers teachers) {
        repository.delete(teachers);
    }

    public LiveData<List<Teachers>> getAllApprovedTeachers() {
        return allTeachers2;
    }
}
