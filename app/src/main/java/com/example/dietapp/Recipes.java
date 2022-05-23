package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dietapp.roomdb.Meals;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Recipes extends AppCompatActivity {

    ViewModel mealViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipesnavbar();
        addMeal();

        mealViewModel = ViewModelProviders.of(this).get(ViewModel.class);
    }

    public void recipesnavbar(){
        //Initialize and assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.Recipes);
        //ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.Diary:
                        startActivity(new Intent(getApplicationContext()
                                ,Diary.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext()
                                ,Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Recipes:
                        return true;
                    case R.id.Settings:
                        startActivity(new Intent(getApplicationContext()
                                ,Settings.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    public void addMeal(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.activity_recipes, null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        Button btnaddmMeal= view.findViewById(R.id.addfood);
        final EditText foodname = view.findViewById(R.id.nameoffood);
        final EditText foodcalory = view.findViewById(R.id.foodcalory);
        TextView createMeal = view.findViewById(R.id.createmeal);

        btnaddmMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (foodname.getText()!=null && foodcalory.getText() != null){
                    String mealname = foodname.getText().toString().trim();
                    String mealcalory = foodcalory.getText().toString().trim();

                    Meals meals =  new Meals();
                    meals.setMealname(mealname);

                    mealViewModel.insertMeals(meals);

                    Intent i = new Intent(Recipes.this, ListFood.class);
                    startActivity(i);
                    //alertDialog.dismiss();
                }
            }
        });
    }
}