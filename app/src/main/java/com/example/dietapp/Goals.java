package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Goals extends AppCompatActivity {
    String Lweight;
    String Mweight;
    String Gweight;

    Button losew;
    Button maintainw;
    Button gainw;

    private Button button;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        losew = (Button) findViewById(R.id.loseweight);
        maintainw = (Button) findViewById(R.id.maintainweight);
        gainw = (Button) findViewById(R.id.gainweight);
        selectedButton();
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Lweight = losew.getText().toString();
                    Mweight = maintainw.getText().toString();
                    Gweight = gainw.getText().toString();
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

    public void selectedButton(){
        losew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change button color

                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(2,getResources().getColor(R.color.green_2));
                losew.setBackground(gradientDrawable);

                GradientDrawable gradientDrawable1 = new GradientDrawable();
                gradientDrawable1.setStroke(2,getResources().getColor(R.color.black));
                maintainw.setBackground(gradientDrawable1);
                gainw.setBackground(gradientDrawable1);
                //change text color
                losew.setTextColor(getResources().getColor(R.color.green_2));
                maintainw.setTextColor(getResources().getColor(R.color.black));
                gainw.setTextColor(getResources().getColor(R.color.black));

            }
        });
        maintainw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change button color

                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(2,getResources().getColor(R.color.green_2));
                maintainw.setBackground(gradientDrawable);

                GradientDrawable gradientDrawable1 = new GradientDrawable();
                gradientDrawable1.setStroke(2,getResources().getColor(R.color.black));
                losew.setBackground(gradientDrawable1);
                gainw.setBackground(gradientDrawable1);
                //change text color
                maintainw.setTextColor(getResources().getColor(R.color.green_2));
                losew.setTextColor(getResources().getColor(R.color.black));
                gainw.setTextColor(getResources().getColor(R.color.black));

            }
        });
        gainw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //change button color

                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setStroke(2,getResources().getColor(R.color.green_2));
                gainw.setBackground(gradientDrawable);
                GradientDrawable gradientDrawable1 = new GradientDrawable();
                gradientDrawable1.setStroke(2,getResources().getColor(R.color.black));
                losew.setBackground(gradientDrawable1);
                maintainw.setBackground(gradientDrawable1);
                //change text color
                gainw.setTextColor(getResources().getColor(R.color.green_2));
                losew.setTextColor(getResources().getColor(R.color.black));
                maintainw.setTextColor(getResources().getColor(R.color.black));

            }
        });

    }
}
