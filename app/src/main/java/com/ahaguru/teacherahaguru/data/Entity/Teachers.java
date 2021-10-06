package com.ahaguru.teacherahaguru.data.Entity;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.ahaguru.teacherahaguru.data.Model.TeacherRegistrationSubject;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "teacher_table")
public class Teachers {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phone_number;
    private String email;
    private String contactEmail;
    private String teacher_status;
//    private TeacherRegistrationSubject teacherRegistrationSubject;


    public Teachers(String name, String phone_number, String email, String contactEmail, String teacher_status) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.contactEmail = contactEmail;
        this.teacher_status = teacher_status;
//        this.teacherRegistrationSubject = teacherRegistrationSubject;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }


    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getTeacher_status() {
        return teacher_status;
    }

    public void setTeacher_status(String teacher_status) {
        this.teacher_status = teacher_status;
    }
    //    public TeacherRegistrationSubject getTeacherRegistrationSubject() {
//        return teacherRegistrationSubject;
//    }
//
//    public void setTeacherRegistrationSubject(TeacherRegistrationSubject teacherRegistrationSubject) {
//        this.teacherRegistrationSubject = teacherRegistrationSubject;
//    }
}

