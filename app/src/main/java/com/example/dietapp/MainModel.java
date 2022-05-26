package com.example.dietapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel implements Parcelable {

    String name, picture;
    String calories;
    String fats;
    String carbs;
    String protein;

    @Override
    public String toString() {
        return "MainModel{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", calories='" + calories + '\'' +
                ", fats='" + fats + '\'' +
                ", carbs='" + carbs + '\'' +
                ", protein='" + protein + '\'' +
                '}';
    }

    public MainModel()
    {

    }
    public MainModel(String name, String picture, String calories, String fats, String carbs, String protein) {
        this.name = name;
        this.picture = picture;
        this.calories = calories;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
    }

    protected MainModel(Parcel in) {
        name = in.readString();
        picture = in.readString();
        calories = in.readString();
        fats = in.readString();
        carbs = in.readString();
        protein = in.readString();
    }

    public static final Creator<MainModel> CREATOR = new Creator<MainModel>() {
        @Override
        public MainModel createFromParcel(Parcel in) {
            return new MainModel(in);
        }

        @Override
        public MainModel[] newArray(int size) {
            return new MainModel[size];
        }
    };

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

    public String getFats() { return fats; }

    public void setFats(String fats) { this.fats = fats; }

    public String getCarbs() { return carbs; }

    public void setCarbs(String carbs) { this.carbs = carbs; }

    public String getProtein() { return protein; }

    public void setProtein(String protein) { this.protein = protein; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(picture);
        parcel.writeString(calories);
        parcel.writeString(fats);
        parcel.writeString(carbs);
        parcel.writeString(protein);
    }
}
