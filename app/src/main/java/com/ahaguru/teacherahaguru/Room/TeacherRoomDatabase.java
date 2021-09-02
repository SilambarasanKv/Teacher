package com.ahaguru.teacherahaguru.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ahaguru.teacherahaguru.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.Entity.Teachers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Teachers.class}, version = 1, exportSchema = false)
public abstract class TeacherRoomDatabase extends RoomDatabase {

    public abstract TeacherDao teacherDao();

   /* private static volatile TeacherRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static TeacherRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TeacherRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TeacherRoomDatabase.class, "teacher_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            databaseWriteExecutor.execute(() -> {

                TeacherDao dao = INSTANCE.teacherDao();
                dao.deleteAll();

                Teachers teachers = new Teachers();
                dao.insert(teachers);
                teachers = new Teachers();
                dao.insert(teachers);
            });
        }
    };*/
}

