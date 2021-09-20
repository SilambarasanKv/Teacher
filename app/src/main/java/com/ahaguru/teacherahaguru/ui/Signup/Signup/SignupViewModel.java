package com.ahaguru.teacherahaguru.ui.Signup.Signup;

import android.app.Application;
import android.util.Patterns;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.R;
import com.ahaguru.teacherahaguru.Repository.TeachersRepository;

import org.jetbrains.annotations.NotNull;

public class SignupViewModel extends AndroidViewModel {

    private String name;
    private String phone_number;
    private String email;
    private String contactEmail;
    private String subject;

    private Teachers teachers;

    public SignupViewModel(@NonNull @NotNull Application application) {
        super(application);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = email;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String name) {
        this.contactEmail = contactEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String name) {
        this.subject = subject;
    }

}
