package com.ahaguru.teacherahaguru.ui.Signup.Code;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.Repository.TeachersRepository;

import org.jetbrains.annotations.NotNull;

public class CodeViewModel extends AndroidViewModel {
    private TeachersRepository repository;

    public CodeViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new TeachersRepository(application);
    }

    public void insert(Teachers teachers) {
        repository.insert(teachers);
    }
}
