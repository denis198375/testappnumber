package com.test.test;

import android.app.Application;


import androidx.navigation.NavController;
import androidx.room.Room;

import com.test.test.bd.AppDatabase;

public class MyApp extends Application {
  public static   NavController controller;
    public AppDatabase db;
    public static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return db;
    }
    @Override
    public void onCreate() {

        super.onCreate();
        instance = this;
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database").allowMainThreadQueries().build();
    }
}
