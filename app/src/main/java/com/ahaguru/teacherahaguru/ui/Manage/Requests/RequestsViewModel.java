
package com.ahaguru.teacherahaguru.ui.Manage.Requests;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Repository.TeachersRepository;

import java.util.List;

public class RequestsViewModel extends AndroidViewModel {


    private TeachersRepository repository;

    private LiveData<List<Teachers>> allTeachers;
    private LiveData<List<Teachers>> allTeachers2;

    public RequestsViewModel(@NonNull Application application) {
        super(application);
        repository = new TeachersRepository(application);
        allTeachers = repository.getAllPendingTeachers();
        allTeachers2 = repository.getAllApprovedTeachers();
    }

    public void insert(Teachers teachers) {
        repository.insert(teachers);
    }

    public void update(Teachers teachers) {
        repository.update(teachers);
    }

    public void delete(Teachers teachers) {
        repository.delete(teachers);
    }

    public LiveData<List<Teachers>> getAllPendingTeachers() {
        return allTeachers;
    }


    public LiveData<List<Teachers>> getAllApprovedTeachers() {
        return allTeachers2;
    }
}
