package com.example.dietapp.roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meals")
public class Meals {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "mealname")
    private String mealname;


    @ColumnInfo(name = "calories")
    private int calories;

    @ColumnInfo(name =  "mealpicture")
    private String mealpictures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMealpictures() {
        return mealpictures;
    }

    public void setMealpictures(String mealpictures) {
        this.mealpictures = mealpictures;
    }
}
