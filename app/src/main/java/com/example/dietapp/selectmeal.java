package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class selectmeal extends AppCompatActivity {

    ImageView imageview;
    TextView food;
    TextView calory;
    TextView Fats, Carbs, Protein;
    Button add, delete;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectmeal);

        imageview = findViewById(R.id.foodpicture);
        food = findViewById(R.id.foodname);
        calory = findViewById(R.id.caloryvalue);
        Fats = findViewById(R.id.fatsvalue);
        Carbs = findViewById(R.id.carbsvalue);
        Protein = findViewById(R.id.proteinvalue);
        add = findViewById(R.id.save);
        delete = findViewById(R.id.cancel);

        ref = FirebaseDatabase.getInstance().getReference("FoodEaten");

        MainModel name = getIntent().getParcelableExtra("Name");
        Glide.with(this).load(name.getPicture()).into(imageview);
        food.setText(name.getName());
        Fats.setText(String.format("%s g", name.getFats()));
        Carbs.setText(String.format("%s g", name.getCarbs()));
        Protein.setText(String.format("%s g", name.getProtein()));
        calory.setText(String.format("%s kcal", name.getCalories()));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(selectmeal.this, Diary.class);
                showcalorieseaten();
                //i.putExtra("calories", name);
                //Toast.makeText(selectmeal.this, ""+name, Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }

    public void showcalorieseaten(){
        String Calories = calory.getText().toString();
        String Name = food.getText().toString();
        String mFats = Fats.getText().toString();
        String mCarbs = Carbs.getText().toString();
        String mProtein = Protein.getText().toString();

        String id = ref.push().getKey();
        foodeaten eaten = new foodeaten(id,Calories,Name,mCarbs,mFats,mProtein);

        ref.child(id).setValue(eaten);
        calory.setText("");
        food.setText("");
        Fats.setText("");
        Carbs.setText("");
        Protein.setText("");

    }
}