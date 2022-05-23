package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Diary extends AppCompatActivity {


    RelativeLayout relativeLayout;
    RelativeLayout btnL;
    RelativeLayout btnD;
    ProgressBar progressBar;
    TextView cals;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diarynavbar();
        cals = findViewById(R.id.calories);

        new firsttake().execute();

        progressBar = findViewById(R.id.progressBar);
        RelativeLayout relativelayout = (RelativeLayout) findViewById(R.id.addB);
        RelativeLayout btnL = (RelativeLayout) findViewById(R.id.addL);
        RelativeLayout btnD = (RelativeLayout) findViewById(R.id.addDr);
        relativelayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Diary.this, ListFood.class));
            }
        });

        btnL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Diary.this, ListFood.class));
            }
        });

        btnD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Diary.this, ListFood.class));
            }
        });

    }
public class firsttake extends AsyncTask<String, String, MainModel> {

    @Override
    protected MainModel doInBackground(String... strings) {
        /*
        MainModel calories = getIntent().getParcelableExtra("calories");
        Toast.makeText(this, ""+calories, Toast.LENGTH_LONG).show();
        cals.setText(calories.getCalories());
        return calories;
        */
        return null;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}

public void diarynavbar(){
        //Initialize and assign Variables
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        //set Home selected
        bottomNavigationView.setSelectedItemId(R.id.Diary);
        //ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.Diary:
                        return true;
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext()
                                ,Home.class));
                        overridePendingTransition(0,0);
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