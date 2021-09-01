package com.ahaguru.teacherahaguru.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "teacher_table")
public class Teachers {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "teachers")
    private String mTeachers;

    public Teachers(@NonNull String teachers) {this.mTeachers = teachers;}

    public String getTeachers(){return this.mTeachers;}
}

