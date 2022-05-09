package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Activity4 extends AppCompatActivity {

    RadioButton radioButton;
    RadioGroup radioGroup;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        radioGroup =  findViewById(R.id.radioGroup);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousPage();
            }
        });

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectecId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectecId);
                Toast.makeText(getApplicationContext(), radioButton.getText().toString(), Toast.LENGTH_LONG).show();
                openPage2();
            }
        });

    }

    public void previousPage(){
        Intent intent = new Intent(this, You.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void openPage2(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
