package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class Diary extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        diarynavbar();

        listView = (ListView) findViewById(R.id.listview);

        int[] image = {R.drawable.frenchtoast, R.drawable.lunch, R.drawable.dinner};
        String[] name = {"Add Breakfast", "Add Lunch", "Add Dinner"};
        String[] des ={"Recommended 830-1170 kcal", "Recommended 830-1170 kcal", "Recommended 830-1170 kcal"};
        //create data
        ArrayList<Mealbtn> arrayList = new ArrayList<>();

      for ( int i = 0; i<image.length; i++){

          Mealbtn mealbtn = new Mealbtn(image[i], name[i],des[i]);
          arrayList.add(mealbtn);
      }

        MealbtnAdapter mealbtnAdapter = new MealbtnAdapter(this,R.layout.list_items, arrayList);

        listView.setAdapter(mealbtnAdapter);

        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(Diary.this, ListofFood.class);
                intent.putExtra("name",name[position]);
                intent.putExtra("des",name[position]);
                intent.putExtra("image",name[position]);
                startActivity(intent);

            }

        });

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