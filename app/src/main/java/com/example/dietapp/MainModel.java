package com.example.dietapp;

public class MainModel {

    String name, picture;
    String calories;

    MainModel()
    {

    }
    public MainModel(String name, String picture, String calories) {
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

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
