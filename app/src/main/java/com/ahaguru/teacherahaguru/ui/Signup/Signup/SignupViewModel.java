package com.ahaguru.teacherahaguru.ui.Signup.Signup;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Repository.TeachersRepository;

import org.jetbrains.annotations.NotNull;

public class SignupViewModel extends AndroidViewModel {
    private TeachersRepository repository;

    public SignupViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new TeachersRepository(application);
    }

    public void insert(Teachers teachers) {
        repository.insert(teachers);
    }
}
