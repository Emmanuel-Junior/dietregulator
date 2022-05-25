package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Goals extends AppCompatActivity {
    String Lweight;
    String Mweight;
    String Gweight;

    RadioButton radioButton;
    RadioGroup radioGroup;


    private Button button;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        radioGroup =  findViewById(R.id.radioGroup);

        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroup.getCheckedRadioButtonId() ==-1){
                    Toast.makeText(Goals.this, "Select a Goal", Toast.LENGTH_SHORT).show();
                }else {
                    int selectecId = radioGroup.getCheckedRadioButtonId();
                    radioButton = findViewById(selectecId);
                    Toast.makeText(getApplicationContext(), radioButton.getText().toString(), Toast.LENGTH_LONG).show();
                    opennextPage();
                }
                }
        });
    }

    public void opennextPage(){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void previousPage(View view){
        Intent intent = new Intent(this, You.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
