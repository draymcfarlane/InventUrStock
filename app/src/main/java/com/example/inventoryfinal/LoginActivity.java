package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: LoginActivity.java
// Class Description: This class allows the user to login into their account, forgot password function and register a new account.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// LoginActivity.java
public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private EditText emaillog;
    private EditText password;
    private Button login;
    private Button register;
    private Button forgotpass;
    private ProgressBar progressBar;
    private Animation bottom, up;
    private TextView title, loginbg1;

    // Firebase variables
    private FirebaseAuth mAuth;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        title = findViewById(R.id.titledisplay1); // header
        loginbg1 = findViewById(R.id.loginbg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        loginbg1.setAnimation(up); // set slide up animation

        register = (Button) findViewById(R.id.registerbutton);
        register.setOnClickListener(this);

        login = (Button) findViewById(R.id.loginbutton);
        login.setOnClickListener(this);

        forgotpass = (Button) findViewById(R.id.passresetbutton);
        forgotpass.setOnClickListener(this);

        emaillog = (EditText) findViewById(R.id.emaillog);
        password = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// onClick()
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerbutton:
                Intent intent2 = new Intent(this, RegisterPage.class); // redirects to RegisterPage
                startActivity(intent2);
                break;
            case R.id.loginbutton:
                userSignin(); // calls userSignin()
                break;
            case R.id.passresetbutton:
                startActivity(new Intent(this, ForgotPassword.class)); // redirects to ForgotPassword
                break;
        }
    }
    ///////////////////////////////////////////////////////////////////// onClick()



    ///////////////////////////////////////////////////////////////////// userSignin()
    private void userSignin() // checks the required parameters entered and signs the user in if correct
    {
        String emaillogin = emaillog.getText().toString().trim();
        String pass = password.getText().toString().trim();

        ///////////// conditions if empty
        if(emaillogin.isEmpty())
        {
            emaillog.setError("Email required!");
            emaillog.requestFocus();
            return;
        }

        ///////////// if email is valid format
        if(!Patterns.EMAIL_ADDRESS.matcher(emaillogin).matches())
        {
            emaillog.setError("Email Invalid");
            emaillog.requestFocus();
            return;
        }
        ///////////// if email is valid format

        if(pass.isEmpty())
        {
            password.setError("Valid Password required!");
            password.requestFocus();
            return;
        }
        if(pass.length()<6)
        {
            password.setError("Password length of 6 required!");
            password.requestFocus();
            return;
        }
        ///////////// conditions if empty

        progressBar.setVisibility(View.VISIBLE); // display the progress bar to the screen

        ///////////// sign in with email and password function
        mAuth.signInWithEmailAndPassword(emaillogin, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser(); // collects user information from database

                    if (user.isEmailVerified()) { // redirects to InventoryPage
                        Intent intent = new Intent(LoginActivity.this, InventoryPage.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                    } else { // sends a validation check
                        user.sendEmailVerification();
                        emaillog.setError("Verify email, check inbox for verification email");
                        emaillog.requestFocus();
                        progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                    }
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                }

            }
        });
        ///////////// sign in with email and password function

    }
    ///////////////////////////////////////////////////////////////////// userSignin()



}
///////////////////////////////////////////////////////////////////// LoginActivity.java