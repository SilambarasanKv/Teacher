package com.ahaguru.teacherahaguru.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_table")
public class Teachers {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "teacher_name")
    private String name;

    @ColumnInfo(name = "teacher_email")
    private String email;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public Teachers(@NonNull String teachers) {this.mTeachers = teachers;}

    public String getTeachers(){return this.mTeachers;}*/
}

