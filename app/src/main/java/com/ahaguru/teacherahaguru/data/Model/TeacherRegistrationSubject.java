package com.ahaguru.teacherahaguru.data.Model;

import androidx.room.Embedded;

public class TeacherRegistrationSubject {

    private int status;
    private String message;
    private DataRegistrationSubject data;

    public TeacherRegistrationSubject(int status, String message, DataRegistrationSubject data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataRegistrationSubject getData() {
        return data;
    }

    public void setData(DataRegistrationSubject data) {
        this.data = data;
    }
}
