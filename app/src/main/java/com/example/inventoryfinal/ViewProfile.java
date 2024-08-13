package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: ViewProfile.java
// Class Description: This class allows the user to display their information assigned with the account, change their password, delete their account
//                    and logout of the account.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// ViewProfile.java
public class ViewProfile extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private String userID;
    private Button logout;
    private Button changepass;
    private Button returntomenu2;
    private Button deleteacc;
    private Animation bottom, up, fade;
    private TextView title, viewprofilebg;
    private TextView emailtitle, usernametitle, passwordtitle;

    // Firebase variables
    private FirebaseUser user;
    private DatabaseReference ref;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        title = findViewById(R.id.titledisplay5); // header
        viewprofilebg = findViewById(R.id.viewprofilebg); // coloured background

        emailtitle = findViewById(R.id.emailtitle);
        usernametitle = findViewById(R.id.usernametitle);
        passwordtitle = findViewById(R.id.passwordtitle);

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation
        fade = AnimationUtils.loadAnimation(this, R.anim.fade); // fade in animation

        title.setAnimation(bottom); // set drop down animation

        emailtitle.setAnimation(up); // set slide up animation
        usernametitle.setAnimation(up); // set slide up animation
        passwordtitle.setAnimation(up); // set slide up animation

        viewprofilebg.setAnimation(up); // set slide up animation

        deleteacc = (Button) findViewById(R.id.deleteacc);
        logout = (Button) findViewById(R.id.logoutbutton);
        changepass = (Button) findViewById(R.id.changepass);
        returntomenu2 = (Button) findViewById(R.id.returntomenu2);

        changepass.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewProfile.this, ChangePassword.class)); // redirects to ChangePassword
            }
        });

        returntomenu2.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewProfile.this, InventoryPage.class)); // redirects to InventoryPage
            }
        });

        deleteacc.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {

                ///////////// displays a dialog box
                AlertDialog.Builder dialog = new AlertDialog.Builder(ViewProfile.this); // displays in ViewProfile
                dialog.setTitle("Are you sure?"); // title of dialog box
                dialog.setMessage("Deleting your account will restrict your access to this application.");
                dialog.setPositiveButton("Delete", new DialogInterface.OnClickListener() { // setting delete button
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(ViewProfile.this, "Account Deleted", Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(ViewProfile.this, LoginActivity.class)); // redirects to LoginActivity if successful
                                }
                                else
                                {
                                    Toast.makeText(ViewProfile.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();  // in the case of any disruption or error
                                }
                            }
                        });
                    }
                });
                dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // setting dismiss button
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
            ///////////// displays a dialog box

        });

        logout.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ViewProfile.this, LoginActivity.class)); // redirects to LoginActivity
            }
        });

        ///////////// get user account name (ex. John Doe)
        user = FirebaseAuth.getInstance().getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        ///////////// get user account name (ex. John Doe)

        final TextView emaildisplay = (TextView) findViewById(R.id.emaildisplay);
        emaildisplay.setAnimation(up); // set slide up animation
        final TextView userdisplay  = (TextView) findViewById(R.id.userdisplay);
        userdisplay.setAnimation(up); // set slide up animation
        final TextView passdisplay  = (TextView) findViewById(R.id.passdisplay);
        passdisplay.setAnimation(up); // set slide up animation

        ref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User accdetails = snapshot.getValue(User.class); // snapshot of database
                if (accdetails != null) // if there is account details
                {
                    String fulluser = accdetails.Uname;
                    String email = accdetails.email;
                    String pass = accdetails.pass;

                    emaildisplay.setText(email); // setting email text to user data
                    emaildisplay.setAnimation(fade); // set fade in animation
                    userdisplay.setText(fulluser); // setting username text to user data
                    userdisplay.setAnimation(fade); // set fade in animation
                    passdisplay.setText(pass); // setting password text to user data
                    passdisplay.setAnimation(fade); // set fade in animation
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { // in the case of any disruption or error
                Toast.makeText(ViewProfile.this, "An Error has Occurred", Toast.LENGTH_LONG).show();
            }
        });
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



}
///////////////////////////////////////////////////////////////////// ViewProfile.java