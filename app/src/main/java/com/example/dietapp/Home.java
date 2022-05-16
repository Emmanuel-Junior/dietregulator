package com.example.dietapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homenavbar();
    }


    /*Navbar Manipulations*/
    public void homenavbar(){
        //Initialize and assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.Home);
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
                        return true;
                    case R.id.Recipes:
                        startActivity(new Intent(getApplicationContext()
                                ,Recipes.class));
                        overridePendingTransition(0,0);
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
}