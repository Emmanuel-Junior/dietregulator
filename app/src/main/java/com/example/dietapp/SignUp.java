package com.example.dietapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
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
    ImageView Gsignup_btn;

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    private GoogleSignInClient mGoogleSignInClient;
    private final static int RC_SIGN_IN= 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.inputEmail);
        password = findViewById(R.id.inputPassword);
        ConfirmPswd = findViewById(R.id.confirm_Password);
        Gsignup_btn = findViewById(R.id.googlebtn);
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

        Gsignup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });
        createRequest();

    }

    private void createRequest() {
        //confugire Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(com.google.android.gms.base.R.string.common_open_on_phone))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            //firebaseAuthWithGoogle(account);
            updateUI(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            updateUI(null);
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUI(GoogleSignInAccount account) {

        
    }

    private void PerformAuth() {
        String Email = email.getText().toString();
        String Password = password.getText().toString();
        String ConfirmPassword =ConfirmPswd.getText().toString();

        String usertarget = getIntent().getStringExtra("Target");
        String userbehaviour = getIntent().getStringExtra("behaviour");
        String usergoal = getIntent().getStringExtra("goal");
        String usergender = getIntent().getStringExtra("gender");
        String userage = getIntent().getStringExtra("age");
        String userweight = getIntent().getStringExtra("weight");
        String userheight = getIntent().getStringExtra("height");
        String userbmi = getIntent().getStringExtra("bmi");

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
//        String usertarget = getIntent().getStringExtra("Target");
//        String userbehaviour = getIntent().getStringExtra("behaviour");
//        String usergoal = getIntent().getStringExtra("goal");
//        String usergender = getIntent().getStringExtra("gender");
//        String userage = getIntent().getStringExtra("age");
//        String userweight = getIntent().getStringExtra("weight");
//        String userheight = getIntent().getStringExtra("height");
//        String userbmi = getIntent().getStringExtra("bmi");

        Intent intent = new Intent(SignUp.this, Home.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

//        intent.putExtra("target", usertarget);
//        intent.putExtra("behaviour", userbehaviour);
//        intent.putExtra("goal", usergoal);
//        intent.putExtra("gender", usergender);
//        intent.putExtra("age", userage);
//        intent.putExtra("weight", userweight);
//        intent.putExtra("height", userheight);
//        intent.putExtra("bmi", userbmi);
        startActivity(intent);
    }
}