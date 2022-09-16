package com.android.roomdbinjava.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version  = 2)
public abstract class AppDatabase extends RoomDatabase {
    public static final String Database_name = "NAME.db";
    public static final int VERSION = 1;
    public abstract UserDao userDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, Database_name)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return INSTANCE;
    }
}
