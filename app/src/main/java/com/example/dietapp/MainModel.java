package com.example.dietapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MainModel implements Parcelable {

    String name, picture;
    String calories;

    @Override
    public String toString() {
        return "MainModel{" +
                "name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", calories='" + calories + '\'' +
                '}';
    }

    public MainModel()
    {

    }
    public MainModel(String name, String picture, String calories) {
        this.name = name;
        this.picture = picture;
        this.calories = calories;
    }

    protected MainModel(Parcel in) {
        name = in.readString();
        picture = in.readString();
        calories = in.readString();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(picture);
        parcel.writeString(calories);
    }
}
