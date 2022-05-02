package com.example.dietapp;

public class Mealbtn {
    int Image;
    String Name;
    String Des;

    public Mealbtn(int image, String name, String des) {
        Image = image;
        Name = name;
        Des = des;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}
