package com.example.dietapp.roomdb;

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MealsDao {

    @Insert
    void insertMeal(Meals meals);

    @Update
    void updateMeals(Meals meals);

    @Delete
    void deleteMeals(Meals meals);


    @Query("SELECT * from meals")
    LiveData<List<Meals>> getAllMeals();
}
