package com.example.dietapp;

public class foodeaten {

    private String foodid;
    private String foodcalory;
    private String foodname;
    private String foodcarbs;
    private String foodfats;
    private String foodprotein;

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

    public String getFoodcarbs() {
        return foodcarbs;
    }

    public void setFoodcarbs(String foodcarbs) {
        this.foodcarbs = foodcarbs;
    }

    public String getFoodfats() {
        return foodfats;
    }

    public void setFoodfats(String foodfats) {
        this.foodfats = foodfats;
    }

    public String getFoodprotein() {
        return foodprotein;
    }

    public void setFoodprotein(String foodprotein) {
        this.foodprotein = foodprotein;
    }

    public foodeaten(String foodid, String foodcalory, String foodname, String foodcarbs, String foodfats, String foodprotein) {
        this.foodid = foodid;
        this.foodcalory = foodcalory;
        this.foodname = foodname;
        this.foodcarbs = foodcarbs;
        this.foodfats = foodfats;
        this.foodprotein = foodprotein;
    }
}
