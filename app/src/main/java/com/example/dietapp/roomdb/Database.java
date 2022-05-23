package com.example.dietapp.roomdb;


import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Meals.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {


    public abstract MealsDao mealsDao();
    public static volatile Database INSTANCE;

    static Database getDatabase(Context context) {
        if(INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, Database.class, "meals.db").build();
                }
            }
        }

        return INSTANCE;
    }


}
