package com.ahaguru.teacherahaguru.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.ahaguru.teacherahaguru.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;

import java.util.List;

public class TeachersRepository {

    private TeacherDao teacherDao;
    private LiveData<List<Teachers>> allTeachers;
    private LiveData<List<Teachers>> allTeachers2;

    public TeachersRepository(Application application) {

        TeacherRoomDatabase teacherRoomDatabase = TeacherRoomDatabase.getInstance(application);
        teacherDao = teacherRoomDatabase.teacherDao();

        allTeachers = teacherDao.getAllPendingTeachers();
        allTeachers2 = teacherDao.getAllApprovedTeachers();

    }

    public void insert(Teachers teachers) {
        new InsertTeacherAsyncTask(teacherDao).execute(teachers);
    }

    public void update(Teachers teachers) {
        new UpdateTeacherAsyncTask(teacherDao).execute(teachers);
    }

    public void delete(Teachers teachers) {
        new DeleteTeacherAsyncTask(teacherDao).execute(teachers);
    }

//    public void deleteAllTeachers(Teachers teachers) {
//        new DeleteAllTeacherAsyncTask(teacherDao).execute(teachers);
//    }

    public LiveData<List<Teachers>> getAllPendingTeachers() {
        return allTeachers;
    }

    public LiveData<List<Teachers>> getAllApprovedTeachers() {
        return allTeachers2;
    }

    private static class InsertTeacherAsyncTask extends AsyncTask<Teachers, Void, Void> {

        private TeacherDao teacherDao;

        private InsertTeacherAsyncTask(TeacherDao teacherDao) {

            this.teacherDao = teacherDao;

        }

        @Override
        protected Void doInBackground(Teachers... teachers) {

            teacherDao.insert(teachers[0]);

            return null;
        }

    }

    private static class UpdateTeacherAsyncTask extends AsyncTask<Teachers, Void, Void> {

        private TeacherDao teacherDao;

        private UpdateTeacherAsyncTask(TeacherDao teacherDao) {

            this.teacherDao = teacherDao;

        }

        @Override
        protected Void doInBackground(Teachers... teachers) {

            teacherDao.update(teachers[0]);

            return null;
        }

    }

    private static class DeleteTeacherAsyncTask extends AsyncTask<Teachers, Void, Void> {

        private TeacherDao teacherDao;

        private DeleteTeacherAsyncTask(TeacherDao teacherDao) {

            this.teacherDao = teacherDao;

        }

        @Override
        protected Void doInBackground(Teachers... teachers) {

            teacherDao.delete(teachers[0]);

            return null;
        }

    }

//    private static class DeleteAllTeacherAsyncTask extends AsyncTask<Void, Void, Void> {
//
//        private TeacherDao teacherDao;
//
//        private DeleteAllTeacherAsyncTask(TeacherDao teacherDao) {
//
//            this.teacherDao = teacherDao;
//
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//
//            teacherDao.deleteAllTeachers();
//
//            return null;
//        }
//
//    }
}