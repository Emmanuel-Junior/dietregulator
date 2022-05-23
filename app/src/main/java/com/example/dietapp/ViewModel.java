package com.example.dietapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.dietapp.roomdb.Meals;
import com.example.dietapp.roomdb.MealsRepository;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    private MealsRepository mealsRepository;
    private LiveData<List<Meals>> mealsList;

    public ViewModel(@NonNull Application application) {
        super(application);

        mealsRepository = new MealsRepository(application);
        mealsList = mealsRepository.getAllMeals();
    }

    public LiveData<List<Meals>> getAllMeals() {
        return mealsRepository.getAllMeals();
    }

    public void insertMeals(Meals meals){
        mealsRepository.insertMeal(meals);
    }
    public void updateMeals(Meals meals){
        mealsRepository.updateMeals(meals);
    }
    public void deleteMeals(Meals meals){
        mealsRepository.deleteMeals(meals);
    }
}
