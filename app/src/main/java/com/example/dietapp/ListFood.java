package com.example.dietapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietapp.roomdb.Meals;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ListFood extends AppCompatActivity implements MealAdpater.OnNoteListener {

    RecyclerView recyclerview;
    //MealsAdapterII mealsAdapterII;
    //ViewModel mealViewModel;
    MealAdpater mealAdpater;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_food);

        //mealViewModel = ViewModelProviders.of(this).get(ViewModel.class);

        fab = findViewById(R.id.barcode_btn);
        recyclerview = findViewById(R.id.rv);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        recyclerview.setHasFixedSize(true);
//
//        mealsAdapterII = new MealsAdapterII();
//
//        mealViewModel.getAllMeals().observe(this, new Observer<List<Meals>>() {
//            @Override
//            public void onChanged(List<Meals> meals) {
//                if (meals.size() > 0){
//                    mealsAdapterII.setData(meals);
//                    recyclerview.setAdapter(mealsAdapterII);
//                }
//            }
//        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListFood.this, "You clicked on FLOATBTN", Toast.LENGTH_SHORT).show();
            }
        });

 FirebaseRecyclerOptions<MainModel> options =
         new FirebaseRecyclerOptions.Builder<MainModel>()
                 .setQuery(FirebaseDatabase.getInstance().getReference().child("Meals"), MainModel.class)
                 .build();
 mealAdpater = new MealAdpater(options, this);
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



    @Override
    public void onNoteClick(int position) {

        // Log.d(TAG, "onNoteClick: clicked");
        Intent intent = new Intent(this, selectmeal.class);
        intent.putExtra("Name", (Parcelable) mealAdpater.getItem(position));
        startActivity(intent);
    }

}