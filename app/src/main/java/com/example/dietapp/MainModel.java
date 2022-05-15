package com.example.dietapp;

public class MainModel {

    String name, picture;
    int calories;

    MainModel()
    {

    }
    public MainModel(String name, String picture, int calories) {
        this.name = name;
        this.picture = picture;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
