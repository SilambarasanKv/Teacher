package com.ahaguru.teacherahaguru.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_table")
public class Teachers {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String phone_number;

    private String email;

    private String contactEmail;

    private String subject;

    private String status;


    public Teachers(String name, String phone_number, String email, String contactEmail, String subject, String status) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
        this.contactEmail = contactEmail;
        this.subject = subject;
        this.status = status;
    }


//    public Teachers(int id) {
//        this.id = id;
//    }


    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }


    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }



    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}

