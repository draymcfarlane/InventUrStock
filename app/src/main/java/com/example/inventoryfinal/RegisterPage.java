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
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.database.FirebaseDatabase;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: RegisterPage.java
// Class Description: This class allows the user to register an account in the database, it also checks if the email the user entered is in use.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// RegisterPage.java
public class RegisterPage extends AppCompatActivity implements View.OnClickListener {

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private EditText signname, signpass, signpasscheck, signemail;
    private Button returnpage, register;
    private ProgressBar progressBar;
    private TextView title, registerbg;
    private Animation bottom, up;

    // Firebase variables
    private FirebaseAuth mAuth;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        title = findViewById(R.id.titledisplay2); // header
        registerbg = findViewById(R.id.registerbg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        registerbg.setAnimation(up); // set slide up animation

        mAuth = FirebaseAuth.getInstance();

        register = (Button) findViewById(R.id.reg_button);


        returnpage = (Button) findViewById(R.id.signbutton);
        returnpage.setOnClickListener(this);

        register = (Button) findViewById(R.id.reg_button);
        register.setOnClickListener(this);

        signname = (EditText) findViewById(R.id.signname);
        signpass = (EditText) findViewById(R.id.signpassword);
        signpasscheck = (EditText) findViewById(R.id.signpasswordcheck);
        signemail = (EditText) findViewById(R.id.signemail);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// onClick()
    @Override
    public void onClick(View v)
    {
        switch (v.getId()){
            case R.id.signbutton:
                Intent intent3 = new Intent(this, LoginActivity.class); // redirects to the LoginActivity
                startActivity(intent3);
                break;
            case R.id.reg_button:
                register(); // calls register()
        }
    }
    ///////////////////////////////////////////////////////////////////// onClick()



    ///////////////////////////////////////////////////////////////////// register()
    private void register() // accepts the user input and passes it through the user class and creates a node in Firebase to store users,
    {                       // afterwards it notifies the user if the account was registered or not
        String usern = signname.getText().toString().trim();
        String pass = signpass.getText().toString().trim();
        String passval = signpasscheck.getText().toString().trim();
        String email = signemail.getText().toString().trim();

        ///////////// conditions if empty
        if(usern.isEmpty())
        {
            signname.setError("Full name required!");
            signname.requestFocus();
            return;
        }

        if(email.isEmpty())
        {
            signemail.setError("Email required!");
            signemail.requestFocus();
            return;
        }
        ///////////// conditions if empty

        ///////////// if email is valid format
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signemail.setError("Email Invalid");
            signemail.requestFocus();
            return;
        }
        ///////////// if email is valid format

        ///////////// condition if empty
        if(pass.isEmpty())
        {
            signpass.setError("Password required!");
            signpass.requestFocus();
            return;
        }
        ///////////// condition if empty

        ///////////// password length check
        if(pass.length()<6)
        {
            signpass.setError("Password length of 6 required!");
            signpass.requestFocus();
            return;
        }
        ///////////// password length check

        ///////////// condition if empty
        if(passval.isEmpty())
        {
            signpasscheck.setError("Password Re-Enter required!");
            signpasscheck.requestFocus();
            return;
        }
        ///////////// condition if empty

        ///////////// condition if passwords are the same
        if(!passval.equals(pass))
        {
            signpasscheck.setError("Passwords do not match!");
            signpasscheck.requestFocus();
            return;
        }
        ///////////// condition if passwords are the same

        progressBar.setVisibility(View.VISIBLE); // display the progress bar to the screen
        mAuth.fetchSignInMethodsForEmail(signemail.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) { // test if email exist or not
                        boolean check = !task.getResult().getSignInMethods().isEmpty();
                        if (!check)
                        {
                            progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                        }
                        else
                        {
                            signemail.setError("Email already in use");
                            signemail.requestFocus();
                            progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                        }
                    }
                });

        progressBar.setVisibility(View.VISIBLE); // display the progress bar to the screen
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) { // adds user to database
                            User user = new User(usern, email, pass);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) { // notifies if account was registered or not
                                        progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                                        Toast.makeText(RegisterPage.this, "Account Registered", Toast.LENGTH_LONG).show();
                                        Intent intent4 = new Intent(RegisterPage.this, LoginActivity.class); // redirects to LoginActivity
                                        startActivity(intent4);
                                    } else {
                                        Toast.makeText(RegisterPage.this, "Registration Failed", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE); // removes the progress bar from the screen
                                    }
                                }
                            });
                        }
                    }
                });
        }
        ///////////////////////////////////////////////////////////////////// register()



    }
    ///////////////////////////////////////////////////////////////////// RegisterPage.java