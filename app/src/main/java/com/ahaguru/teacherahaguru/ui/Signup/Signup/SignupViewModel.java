package com.ahaguru.teacherahaguru.ui.Signup.Signup;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.data.Model.RegisterProfileInput;
import com.ahaguru.teacherahaguru.data.Model.TeacherRegistrationSubject;
import com.ahaguru.teacherahaguru.data.Repository.TeachersRepository;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.ApiStatusResponse;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.Resource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SignupViewModel extends AndroidViewModel {

    private TeachersRepository teachersRepository;
    private LiveData<List<Teachers>> alLSubjects;
    private MutableLiveData<TeacherRegistrationSubject> teacherRegistrationSubjectML = new MutableLiveData<>();

    public void setRegisterProfileInput(TeacherRegistrationSubject teacherRegistrationSubject) {
        this.teacherRegistrationSubjectML.setValue(teacherRegistrationSubject);
    }

    public SignupViewModel(@NonNull @NotNull Application application) {
        super(application);

        teachersRepository = new TeachersRepository(application);
        alLSubjects = teachersRepository.getAllApprovedTeachers();

    }

    public LiveData<Resource<ApiStatusResponse>> getSubjectsList() {

        return Transformations.switchMap(teacherRegistrationSubjectML, new Function<TeacherRegistrationSubject, LiveData<Resource<ApiStatusResponse>>>() {
            @Override
            public LiveData<Resource<ApiStatusResponse>> apply(TeacherRegistrationSubject teacherRegistrationSubject) {
                return teachersRepository.subjectsRequest(teacherRegistrationSubject);
            }
        });

    }

    public LiveData<List<Teachers>> alLSubjects()
    {
        return alLSubjects;
    }


}
