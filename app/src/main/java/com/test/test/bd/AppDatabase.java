package com.test.test.bd;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {DbNumber.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NumberDao numberDao();
}