package com.example.dietapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class You extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    float bmi;
    float weight, height;
    int agedate;

    EditText age;
    Calendar calendar;
    RadioButton male,female;
    EditText inputweight, inputheight;


    private Spinner spinner;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you);

//        spinnermethod();
        age = findViewById(R.id.age);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        inputweight = findViewById(R.id.inputweight);
        inputheight = findViewById(R.id.inputheight);
        button = (Button) findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(age.getText().toString().trim().length() == 0 ||
                 inputweight.getText().toString().trim().length() == 0 ||
                        inputheight.getText().toString().trim().length() == 0 ||
                        male.getText().toString().trim().length() == 0 ){
                    Toast.makeText(You.this, "Fill the form please", Toast.LENGTH_SHORT).show();
                }
                else {
                    weight = Float.valueOf(inputweight.getText().toString());
                    height = Float.valueOf(inputheight.getText().toString());
                    bmi = weight / (height * height);

                    opennextpage();
                }
            }
        });

        male.isChecked();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { previousPage(); }
        });
        etdob();

    }
    public void opennextpage() {
        Intent intent = new Intent(this, Goals.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void previousPage(){
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
//    public void spinnermethod(){
//        spinner = findViewById(R.id.spinner1);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.weightunits, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//        spinner.setOnItemSelectedListener(this);
//    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String unit = adapterView.getItemAtPosition(i).toString();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}

    public void etdob(){
        age = findViewById(R.id.age);

        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateCalendar();
            }
            private void updateCalendar(){
                String Format = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(Format, Locale.US);
                age.setText(sdf.format(calendar.getTime()));
            }
        };
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(You.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();

                }
            });
        };


}