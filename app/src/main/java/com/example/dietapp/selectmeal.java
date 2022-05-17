package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class selectmeal extends AppCompatActivity {

    ImageView imageview;
    TextView food;
    TextView calory;
    Button add, delete;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectmeal);

        imageview = findViewById(R.id.foodpicture);
        food = findViewById(R.id.foodname);
        calory = findViewById(R.id.caloryvalue);
        add = findViewById(R.id.save);
        delete = findViewById(R.id.cancel);
        ref = FirebaseDatabase.getInstance().getReference().child("Meals");


        String Name = getIntent().getStringExtra("Name");


    }
}