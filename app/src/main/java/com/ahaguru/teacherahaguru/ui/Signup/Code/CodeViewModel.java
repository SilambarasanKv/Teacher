package com.ahaguru.teacherahaguru.ui.Signup.Code;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.data.Model.RegisterProfileInput;
import com.ahaguru.teacherahaguru.data.Repository.TeachersRepository;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.ApiStatusResponse;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.Resource;

import org.jetbrains.annotations.NotNull;

public class CodeViewModel extends AndroidViewModel {
    private TeachersRepository teachersRepository;

    private MutableLiveData<RegisterProfileInput> registerProfileInputML = new MutableLiveData<>();

    public void setRegisterProfileInput(RegisterProfileInput registerProfileInput) {
        this.registerProfileInputML.setValue(registerProfileInput);
    }

    public CodeViewModel(@NonNull @NotNull Application application) {
        super(application);
        teachersRepository = new TeachersRepository(application);
    }

    public void insert(Teachers teachers) {
        teachersRepository.insert(teachers);
    }

    public LiveData<Resource<ApiStatusResponse>> registerTeacherProfile() {

        return Transformations.switchMap(registerProfileInputML, new Function<RegisterProfileInput, LiveData<Resource<ApiStatusResponse>>>() {
            @Override
            public LiveData<Resource<ApiStatusResponse>> apply(RegisterProfileInput registerProfileInput) {
                return teachersRepository.registerTeacherProfile(registerProfileInput);
            }
        });
    }


}
