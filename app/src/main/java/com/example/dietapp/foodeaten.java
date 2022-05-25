package com.example.dietapp;

public class foodeaten {

    private String foodid;
    private String foodcalory;
    private String foodname;

    public foodeaten() {
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid;
    }

    public String getFoodcalory() {
        return foodcalory;
    }

    public void setFoodcalory(String foodcalory) {
        this.foodcalory = foodcalory;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public foodeaten(String foodid, String foodcalory, String foodname) {
        this.foodid = foodid;
        this.foodcalory = foodcalory;
        this.foodname = foodname;


    }
}
