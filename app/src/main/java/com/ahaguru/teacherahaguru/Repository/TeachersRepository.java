package com.ahaguru.teacherahaguru.Repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.ahaguru.teacherahaguru.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.Entity.Teachers;
import com.ahaguru.teacherahaguru.Room.TeacherRoomDatabase;
import com.ahaguru.teacherahaguru.utils.ConstantData;

import java.util.List;

public class TeachersRepository {

    private TeacherDao teacherDao;
//    private LiveData<List<Teachers>> allTeachers;
//    private LiveData<List<Teachers>> allTeachers2;

    public TeachersRepository(Application application) {

        TeacherRoomDatabase teacherRoomDatabase = TeacherRoomDatabase.getInstance(application);
        teacherDao = teacherRoomDatabase.teacherDao();

    }

    public void insert(Teachers teachers) {
   //     new InsertTeacherExecutor(teacherDao).execute(teachers);

        TeacherRoomDatabase.executorService.execute(() -> {
            teacherDao.insert(teachers);
        });
    }

    public void update(Teachers teachers) {
        TeacherRoomDatabase.executorService.execute(() -> {
            teacherDao.update(teachers);
        });
    }

    public void delete(Teachers teachers) {
        TeacherRoomDatabase.executorService.execute(() -> {
            teacherDao.delete(teachers);
        });
    }

//    public void deleteAllTeachers(Teachers teachers) {
//        new DeleteAllTeacherAsyncTask(teacherDao).execute(teachers);
//    }

    public LiveData<List<Teachers>> getAllPendingTeachers() {
        return teacherDao.getAllPendingTeachers(ConstantData.REQUESTED);
    }

    public LiveData<List<Teachers>> getAllApprovedTeachers() {
        return teacherDao.getAllApprovedTeachers(ConstantData.APPROVED);
    }

//    private static class InsertTeacherExecutor extends AsyncTask<Teachers, Void, Void>  {
//
//        private TeacherDao teacherDao;
//
//        private InsertTeacherExecutor(TeacherDao teacherDao) {
//
//            this.teacherDao = teacherDao;
//
//        }
//
//        @Override
//        protected Void doInBackground(Teachers... teachers) {
//
//            teacherDao.insert(teachers[0]);
//
//            return null;
//        }
//
//    }
//
//    private static class UpdateTeacherExecutor extends AsyncTask<Teachers, Void, Void> {
//
//        private TeacherDao teacherDao;
//
//        private UpdateTeacherExecutor(TeacherDao teacherDao) {
//
//            this.teacherDao = teacherDao;
//
//        }
//
//        @Override
//        protected Void doInBackground(Teachers... teachers) {
//
//            teacherDao.update(teachers[0]);
//
//            return null;
//        }
//
//    }
//
//    private static class DeleteTeacherExecutor extends AsyncTask<Teachers, Void, Void> {
//
//        private TeacherDao teacherDao;
//
//        private DeleteTeacherExecutor(TeacherDao teacherDao) {
//
//            this.teacherDao = teacherDao;
//
//        }
//
//        @Override
//        protected Void doInBackground(Teachers... teachers) {
//
//            teacherDao.delete(teachers[0]);
//
//            return null;
//        }
//
//    }

}