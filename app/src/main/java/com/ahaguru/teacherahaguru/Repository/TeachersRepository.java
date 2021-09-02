/*
package com.ahaguru.teacherahaguru.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ahaguru.teacherahaguru.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;

import java.util.List;

public class TeachersRepository {

    private TeacherDao mTeacherDao;
    private LiveData<List<Teachers>> mAllTeachers;


    public TeachersRepository(Application application) {
        TeacherRoomDatabase db = TeacherRoomDatabase.getDatabase(application);
        mTeacherDao = db.teacherDao();
        mAllTeachers = mTeacherDao.getAlphabetizedTeachers();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.

    public LiveData<List<Teachers>> getAllTeachers() {
        return mAllTeachers;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.

    public void insert(Teachers teachers) {
        TeacherRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTeacherDao.insert(teachers);
        });
    }

}
*/
