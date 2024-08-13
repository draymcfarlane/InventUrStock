package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
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
// Class Name: AddItems.java
// Class Description: This class adds new data to the database whilst passing through the user's name from a database snapshot call
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// AddItems.java
public class AddItems extends AppCompatActivity {



    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private Button returntomenu;
    private EditText barcodeadditem_et, productnameadditem_et, categoryadditem_et, priceadditem_et;
    private String userID;
    private Animation bottom, up;
    private TextView title, additemsbg;

    // Firebase variables
    private FirebaseUser user;
    private DatabaseReference ref;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        title = findViewById(R.id.titledisplay); // header
        additemsbg = findViewById(R.id.additemsbg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        additemsbg.setAnimation(up); // set slide up animation

        returntomenu = (Button) findViewById(R.id.returntomenu);
        returntomenu.setOnClickListener(new View.OnClickListener() { // on click returns to inventory menu
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddItems.this, InventoryPage.class));
            }
        });
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// process()
    public void process(View view) // accepts and sends user input for barcode, product name, category and price to the database
    {

        barcodeadditem_et = (EditText) findViewById(R.id.barcodeadditem); // barcode
        productnameadditem_et = (EditText) findViewById(R.id.productnameadditem); // product name
        categoryadditem_et = (EditText) findViewById(R.id.categoryadditem); // category
        priceadditem_et = (EditText) findViewById(R.id.priceadditem); // price

        ///////////// setting the variables to string
        String barcode=barcodeadditem_et.getText().toString().trim();
        String product=productnameadditem_et.getText().toString().trim();
        String category=categoryadditem_et.getText().toString().trim();
        String price=priceadditem_et.getText().toString().trim();
        ///////////// setting the variables to string

        ///////////// conditions if empty
        if(barcode.isEmpty())
        {
            barcodeadditem_et.setError("Barcode required!");
            barcodeadditem_et.requestFocus();
            return;
        }
        if(product.isEmpty())
        {
            productnameadditem_et.setError("Product name required!");
            productnameadditem_et.requestFocus();
            return;
        }
        ///////////// conditions if empty

        ///////////// get user account name (ex. John Doe)
        user = FirebaseAuth.getInstance().getCurrentUser();
        ref = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();
        ///////////// get user account name (ex. John Doe)

        ref.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User accdetails = snapshot.getValue(User.class); // receives user's name
                if (accdetails != null)
                {
                    String added_by = accdetails.Uname; // setting name to string and pass through to AddNewItemsClass
                    AddNewItemsClass obj = new AddNewItemsClass (barcode, product, category, price, added_by);
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference node = db.getReference("Inventory"); // creates a new node to store inventory in
                    node.child(barcode).setValue(obj);
                    barcodeadditem_et.setText(""); // resets fields empty
                    productnameadditem_et.setText("");
                    categoryadditem_et.setText("");
                    priceadditem_et.setText("");
                    Toast.makeText(AddItems.this, "Data Added!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) { // in the case of any disruption or error
                Toast.makeText(AddItems.this, "An Error has Occurred", Toast.LENGTH_LONG).show();
            }
        });
    }
    ///////////////////////////////////////////////////////////////////// process()



}
///////////////////////////////////////////////////////////////////// AddItems.java