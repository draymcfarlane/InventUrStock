package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
// Class Name: InventoryPage.java
// Class Description: This class presents a menu with three options AddItems, ViewItems and ViewProfile. It also greets the user by their name.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// InventoryPage.java
public class InventoryPage extends AppCompatActivity implements View.OnClickListener{



    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private Button additems;
    private Button viewitems;
    private Button viewprofile;
    private String userID;
    private Animation bottom, up, fade;
    private TextView title, inventorybg;

    // Firebase variables
    private FirebaseUser user;
    private DatabaseReference ref;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_page);

        title = findViewById(R.id.titledisplay4); // header
        inventorybg = findViewById(R.id.inventorybg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation
        fade = AnimationUtils.loadAnimation(this, R.anim.fade); // fade in animation

        title.setAnimation(bottom); // set drop down animation
        inventorybg.setAnimation(up); // set slide up animation

        ///////////// get user account name (ex. John Doe)
        user = FirebaseAuth.getInstance().getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        ///////////// get user account name (ex. John Doe)

        final TextView greetingdisplay = (TextView) findViewById(R.id.greeting); // text view for the greeting

        greetingdisplay.setAnimation(up); // set slide up animation
        greetingdisplay.setAnimation(fade); // set fade in animation

        ref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User accdetails = snapshot.getValue(User.class); // receives user's name
                if (accdetails != null)
                {
                    String name = accdetails.Uname; // setting name to string

                    greetingdisplay.setText("Welcome, " + name + "!"); // displaying name
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { // in the case of any disruption or error
                Toast.makeText(InventoryPage.this, "An Error has Occurred", Toast.LENGTH_LONG).show();
            }
        });

        additems = (Button) findViewById(R.id.additemsbutton_ip);
        additems.setOnClickListener(this);

        viewitems = (Button) findViewById(R.id.viewitemsbutton);
        viewitems.setOnClickListener(this);

        viewprofile = (Button) findViewById(R.id.profilebutton);
        viewprofile.setOnClickListener(this);
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// onClick()
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.additemsbutton_ip:
                startActivity(new Intent(this, AddItems.class)); // redirects to AddItems
                break;
            case R.id.viewitemsbutton:
                startActivity(new Intent(this, ViewItems.class)); // redirects to ViewItems
                break;
            case R.id.profilebutton:
                startActivity(new Intent(this, ViewProfile.class)); // redirects to ViewProfile
                break;
        }
    }
    ///////////////////////////////////////////////////////////////////// onClick()



}
///////////////////////////////////////////////////////////////////// InventoryPage.java