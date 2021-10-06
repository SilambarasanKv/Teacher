package com.ahaguru.teacherahaguru.data.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ahaguru.teacherahaguru.data.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.data.Entity.Teachers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Teachers.class}, version = 6, exportSchema = false)
public abstract class TeacherRoomDatabase extends RoomDatabase {

    private static TeacherRoomDatabase instance;

    public abstract TeacherDao teacherDao();

    public ExecutorService executorService =
            Executors.newSingleThreadExecutor();

    public static synchronized TeacherRoomDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TeacherRoomDatabase.class, "teacher_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }


}

