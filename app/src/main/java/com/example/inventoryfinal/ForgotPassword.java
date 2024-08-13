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
import com.google.firebase.auth.FirebaseAuth;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: ForgotPassword.java
// Class Description: This class allows the user to change their password.
//                    Afterwards, it returns the user to the login activity if successful or if cancelled.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// ForgotPassword.java
public class ForgotPassword extends AppCompatActivity implements View.OnClickListener{

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private EditText emailpassreset;
    private Button resetpassbtn;
    private Button returnlogin;
    private TextView title, forgotbg;
    private Animation bottom, up;
    private ProgressBar progressBar;

    // Firebase variables
    private FirebaseAuth auth;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        title = findViewById(R.id.titledisplay3); // header
        forgotbg = findViewById(R.id.forgotbg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        forgotbg.setAnimation(up); // set slide up animation

        emailpassreset = (EditText) findViewById(R.id.emailresetpass);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);

        auth = FirebaseAuth.getInstance();

        resetpassbtn = (Button) findViewById(R.id.changebutton);
        resetpassbtn.setOnClickListener(this);

        returnlogin = (Button) findViewById(R.id.returntologin);
        returnlogin.setOnClickListener(this);
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// onClick()
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.changebutton:
                resetpass(); // calls resetpass()
                break;
            case R.id.returntologin:
                startActivity(new Intent(this, LoginActivity.class)); // redirect to user profile
                break;
        }
    }
    ///////////////////////////////////////////////////////////////////// onClick()



    ///////////////////////////////////////////////////////////////////// resetpass()
    public void resetpass() // initiates password reset
    {
        String email = emailpassreset.getText().toString().trim(); // email input

        ///////////// conditions if empty
        if(email.isEmpty())
        {
            emailpassreset.setError("Email required!");
            emailpassreset.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailpassreset.setError("Email Invalid");
            emailpassreset.requestFocus();
            return;
        }
        ///////////// conditions if empty

        progressBar.setVisibility(View.VISIBLE); // display the progress bar to the screen
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) { // checking condition of task
                if(task.isSuccessful())
                {
                    progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                    Toast.makeText(ForgotPassword.this, "Check email to change password!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ForgotPassword.this, LoginActivity.class)); // redirect to the login
                }
                else
                {
                    progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                    Toast.makeText(ForgotPassword.this, "Try again! an error occurred", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    ///////////////////////////////////////////////////////////////////// resetpass()



}
///////////////////////////////////////////////////////////////////// ForgotPassword.java