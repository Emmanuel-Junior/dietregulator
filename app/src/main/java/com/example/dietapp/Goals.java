package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class Goals extends AppCompatActivity {

    private Button button;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opennextPage();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousPage();
            }
        });
    }

    public void opennextPage(){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void previousPage(){
        Intent intent = new Intent(this, You.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void onOutlinedbtnclicked(View view){

        //change button color
        Button button = findViewById(view.getId());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(2,getResources().getColor(R.color.green_2));
        button.setBackground(gradientDrawable);
        //change text color
        button.setTextColor(getResources().getColor(R.color.green_2));

    }
}
