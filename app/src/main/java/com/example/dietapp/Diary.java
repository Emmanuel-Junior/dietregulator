package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Diary extends AppCompatActivity {

    RelativeLayout relativeLayout;
    RelativeLayout btnL;
    RelativeLayout btnD;
    ProgressBar progressBar;
    TextView cals,Carbohydrate, Fats, Protein;
    TextView progresstext;

    double calorySum=0, carbsSum=0,fatsSum=0,proteinSum=0;
    double progresslevel = 0;
    double valueProgress= 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diarynavbar();
        cals = findViewById(R.id.calories);
        Carbohydrate = findViewById(R.id.carbs);
        Fats = findViewById(R.id.fats);
        Protein = findViewById(R.id.protein);
        progresstext = findViewById(R.id.text_view_progress);
        //updateProgress();

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
        getcalories();

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

    public void getcalories(){
        FirebaseDatabase fb = FirebaseDatabase.getInstance();
        DatabaseReference mRef=fb.getReference("FoodEaten");
        mRef.addValueEventListener(new ValueEventListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                   foodeaten fe= ds.getValue( foodeaten.class);
                    String calory= fe.getFoodcalory().replace("kcal","").trim();
                    String carbs= fe.getFoodcarbs().replace("g","").trim();
                    String fats= fe.getFoodfats().replace("g","").trim();
                    String protein= fe.getFoodprotein().replace("g","").trim();
                    double caloryData=Double.parseDouble(calory);
                    double carbsData=Double.parseDouble(carbs);
                    double fatsData=Double.parseDouble(fats);
                    double proteinData=Double.parseDouble(protein);
                    calorySum+=caloryData;
                    carbsSum+=carbsData;
                    fatsSum+=fatsData;
                    proteinSum+=proteinData;

                    valueProgress=2000-calorySum;
                }
                cals.setText(""+calorySum);
                Carbohydrate.setText(""+carbsSum);
                Fats.setText(""+fatsSum);
                Protein.setText(""+proteinSum);
                progresstext.setText(new StringBuilder().append("").append((int) valueProgress).toString());
                progressBar.setProgress((int) valueProgress);
                progressBar.setMin(0);
                progressBar.setMax(2000);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { }
        });
    }

}