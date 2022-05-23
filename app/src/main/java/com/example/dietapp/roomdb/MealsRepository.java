package com.example.dietapp.roomdb;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MealsRepository {

    private Database database;
    private MealsDao mealsDao;
    private LiveData<List<Meals>> mealsList;

    public MealsRepository(Application application) {

        database = Database.getDatabase(application);
        mealsDao = database.mealsDao();
        mealsList = mealsDao.getAllMeals();

    }

    public LiveData<List<Meals>> getAllMeals(){
        return database.mealsDao().getAllMeals();
    }

    public void insertMeal(final Meals meals){
        new AsyncTask<Void, Void, Void>(

        ) {
            @Override
            protected Void doInBackground(Void... voids) {
                database.mealsDao().insertMeal(meals);

                return null;
            }
        }.execute();

    }

    public void updateMeals(final Meals meals){
        new AsyncTask<Void, Void, Void>(

        ) {
            @Override
            protected Void doInBackground(Void... voids) {
                database.mealsDao().updateMeals(meals);
                return null;
            }
        }.execute();
    }

    public void deleteMeals(final Meals meals){
        new AsyncTask<Void, Void, Void>(

        ) {
            @Override
            protected Void doInBackground(Void... voids) {
                database.mealsDao().deleteMeals(meals);
                return null;
            }
        }.execute();
    }
}
