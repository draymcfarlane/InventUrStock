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
// Class Name: ChangePassword.java
// Class Description: This class allows the user to change their password.
//                    Afterwards, it returns the user to the login activity if successful or to their account if cancelled.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// ChangePassword.java
public class ChangePassword extends AppCompatActivity implements View.OnClickListener{

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private EditText emailpassreset2;
    private Button resetpassbtn2;
    private Button returnviewprofile;
    private TextView title, changebg;
    private Animation bottom, up;
    private ProgressBar progressBar4;

    // Firebase variables
    private FirebaseAuth auth;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        title = findViewById(R.id.titledisplay4); // header
        changebg = findViewById(R.id.changebg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        changebg.setAnimation(up); // set slide up animation

        emailpassreset2 = (EditText) findViewById(R.id.emailresetpass2);

        progressBar4 = (ProgressBar) findViewById(R.id.progressBar4);

        auth = FirebaseAuth.getInstance();

        resetpassbtn2 = (Button) findViewById(R.id.changebutton2);
        resetpassbtn2.setOnClickListener(this);

        returnviewprofile = (Button) findViewById(R.id.returnviewprofile);
        returnviewprofile.setOnClickListener(this);
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// onClick()
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.changebutton2:
                resetpass(); // calls resetpass()
                break;
            case R.id.returnviewprofile:
                startActivity(new Intent(this, ViewProfile.class)); // redirect to user profile
                break;
        }
    }
    ///////////////////////////////////////////////////////////////////// onClick()



    ///////////////////////////////////////////////////////////////////// resetpass()
    public void resetpass() // initiates password reset
    {
        String email = emailpassreset2.getText().toString().trim(); // email input

        ///////////// conditions if empty
        if(email.isEmpty())
        {
            emailpassreset2.setError("Email required!");
            emailpassreset2.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailpassreset2.setError("Email Invalid");
            emailpassreset2.requestFocus();
            return;
        }
        ///////////// conditions if empty

        progressBar4.setVisibility(View.VISIBLE); // display the progress bar to the screen
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) { // checking condition of task
                if(task.isSuccessful())
                {
                    progressBar4.setVisibility(View.GONE); // removes the progress bar from the screen
                    Toast.makeText(ChangePassword.this, "Check email to change password!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ChangePassword.this, LoginActivity.class)); // redirect to the login
                }
                else
                {
                    progressBar4.setVisibility(View.GONE); // removes the progress bar from the screen
                    Toast.makeText(ChangePassword.this, "Try again! an error occurred", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    ///////////////////////////////////////////////////////////////////// resetpass()



}
///////////////////////////////////////////////////////////////////// ChangePassword.java