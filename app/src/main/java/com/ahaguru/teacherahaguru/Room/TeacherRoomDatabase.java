package com.ahaguru.teacherahaguru.Room;

import android.content.Context;
import android.os.AsyncTask;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ahaguru.teacherahaguru.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.Entity.Teachers;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Database(entities = {Teachers.class}, version = 3, exportSchema = false)
public abstract class TeacherRoomDatabase extends RoomDatabase {

    private static TeacherRoomDatabase instance;

    public abstract TeacherDao teacherDao();

    private static volatile TeacherRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService executorService =
            Executors.newSingleThreadExecutor();

    public static synchronized TeacherRoomDatabase getInstance(Context context) {

        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TeacherRoomDatabase.class, "teacher_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;

    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NotNull SupportSQLiteDatabase db) {
            super.onCreate(db);
    //        new PopulateExecutor(instance).execute();

            executorService.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                TeacherDao dao = INSTANCE.teacherDao();

            });

            executorService.shutdown();
        }
    };

//    private static class PopulateAsyncTask extends AsyncTask<Void, Void, Void> {
//        private TeacherDao teacherDao;
//
//        private PopulateAsyncTask(TeacherRoomDatabase db) {
//            teacherDao = db.teacherDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            return null;
//        }
//    }

}

