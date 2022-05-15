package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ListFood extends AppCompatActivity {

    RecyclerView recyclerview;
    MealAdpater mealAdpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_food);

        recyclerview = (RecyclerView) findViewById(R.id.rv);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Meals"), MainModel.class)
                        .build();

        mealAdpater = new MealAdpater(options);
        recyclerview.setAdapter(mealAdpater);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mealAdpater.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mealAdpater.stopListening();
    }
}