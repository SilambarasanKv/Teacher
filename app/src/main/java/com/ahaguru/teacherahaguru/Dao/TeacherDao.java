package com.ahaguru.teacherahaguru.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ahaguru.teacherahaguru.Entity.Teachers;

import java.util.List;

@Dao
public interface TeacherDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy

    @Insert
    void insert(Teachers teachers);

    @Update
    void update(Teachers teachers);

    @Delete
    void delete(Teachers teachers);

//    @Query("DELETE FROM teacher_table")
//    void deleteAllteachers();

    @Query("SELECT * FROM teacher_table where status=0")
    LiveData<List<Teachers>> getAllPendingTeachers();

    @Query("SELECT * FROM teacher_table where status=1")
    LiveData<List<Teachers>> getAllApprovedTeachers();
}