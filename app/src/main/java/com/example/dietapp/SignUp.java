package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private Button button;

    EditText email,password, ConfirmPswd;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+" ;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        ConfirmPswd = findViewById(R.id.confirm_Password);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();



        button = (Button) findViewById(R.id.sign_up);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                PerformAuth();
                //finish();
            }
        });
    }

    private void PerformAuth() {
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String ConfirmPassword =ConfirmPswd.getText().toString();

        if(!Email.matches(emailPattern)){
            email.setError("Enter correct email");
            email.requestFocus();

        }else if(Password.isEmpty() || Password.length()<6){
            password.setError("Password should be atleast 6 Characters");
        }else if(!Password.equals(ConfirmPassword)){
            ConfirmPswd.setError("Password Don't Match");
        }else
        {
            progressDialog.setMessage("Registration in Process...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUsertoNextActivity();
                        Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(SignUp.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUsertoNextActivity() {
        Intent intent = new Intent(SignUp.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}