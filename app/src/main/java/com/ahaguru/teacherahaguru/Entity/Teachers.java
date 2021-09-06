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

    private String email;

    private String phone_number;

    private String subject;

    private int status;


    public Teachers(String name, String phone_number, String email, String subject, int status) {
        this.name = name;
        this.phone_number = phone_number;
        this.email = email;
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

    public String getSubject() {
        return subject;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
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

    //    public Teachers(@NonNull String teachers) {this.name = teachers;}
//
//    public String getTeachers(){return this.name;}

//    @ColumnInfo(name = "teacher_email")
//    private String email;
//
/*    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }*/
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    /*public Teachers(@NonNull String teachers) {this.mTeachers = teachers;}

    public String getTeachers(){return this.mTeachers;}*/
}

