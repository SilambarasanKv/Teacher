package com.ahaguru.teacherahaguru.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ahaguru.teacherahaguru.Entity.Teachers;

import java.util.List;

@Dao
public interface TeacherDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy

    @Insert
    public void addTeachers(Teachers teachers);

    /*@Query("DELETE FROM teacher_table")
    void deleteAll();*/

    @Query("SELECT * FROM teacher_table")
    public List<Teachers> getTeachers();
}