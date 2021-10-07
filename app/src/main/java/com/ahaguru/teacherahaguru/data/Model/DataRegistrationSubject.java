package com.ahaguru.teacherahaguru.data.Model;

import androidx.room.Embedded;

import java.util.ArrayList;
import java.util.List;

public class DataRegistrationSubject {

    private List<String> teacher_registration_subject = new ArrayList<String>();

    public DataRegistrationSubject(List<String> teacher_registration_subject) {
        this.teacher_registration_subject = teacher_registration_subject;
    }

    public List<String> getTeacher_registration_subject() {
        return teacher_registration_subject;
    }

    public void setTeacher_registration_subject(List<String> teacher_registration_subject) {
        this.teacher_registration_subject = teacher_registration_subject;
    }
}
