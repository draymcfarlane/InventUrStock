package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: ViewItems.java
// Class Description: This class allows the user to display their inventory from the database, as well as enter edit mode using a floating action button.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// ViewItems.java
public class ViewItems extends AppCompatActivity {

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private ListView listView;
    private Button returntomenu3;
    private Animation bottom, up;
    private TextView title, viewitemsbg;
    private FloatingActionButton editfab;

    // Firebase variables
    private FirebaseListAdapter adapter;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_items);

        title = findViewById(R.id.titledisplay5); // header
        viewitemsbg = findViewById(R.id.viewitemsbg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        viewitemsbg.setAnimation(up); // set slide up animation

        editfab = (FloatingActionButton) findViewById(R.id.editfabs);
        editfab.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewItems.this, ViewItemsEdit.class)); // redirects to the ViewItemsEdit
            }
        });

        returntomenu3 = (Button) findViewById(R.id.returntomenu3);
        returntomenu3.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewItems.this, InventoryPage.class)); // redirects to the InventoryPage
            }
        });

        listView = (ListView) findViewById(R.id.inventorydisplay);
        Query query = FirebaseDatabase.getInstance().getReference().child("Inventory"); // calls a query from firebase
        FirebaseListOptions<AddNewItemsClass> options = new FirebaseListOptions.Builder<AddNewItemsClass>()
                .setLayout(R.layout.inventory_display) // setting layout to an xml layout
                .setQuery(query, AddNewItemsClass.class) // setting query
                .build();
        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {
                TextView barcode = v.findViewById(R.id.barcodedisplay); // setting id's to text views
                TextView product = v.findViewById(R.id.producdisplay);
                TextView category = v.findViewById(R.id.categorydisplay);
                TextView price = v.findViewById(R.id.pricedisplay);
                TextView added_by = v.findViewById(R.id.added_bydisplay);

                AddNewItemsClass itemsClass = (AddNewItemsClass) model; // retrieves data from database to display
                barcode.setText("Barcode: "+itemsClass.getBarcode().toString()); // setting text
                product.setText("Product: "+itemsClass.getProduct().toString());
                category.setText("Category: "+itemsClass.getCategory().toString());
                price.setText("Price: "+itemsClass.getPrice().toString());
                added_by.setText("Added by: "+itemsClass.getAdded_by().toString());
            }
        };
        listView.setAdapter(adapter); // setting adapter to list view
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// onStart()
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening(); // allows the adapter to only display when open
    }
    ///////////////////////////////////////////////////////////////////// onStart()



    ///////////////////////////////////////////////////////////////////// onStop()
    @Override
    protected void onStop() {
        super.onStop();
        adapter.startListening(); // allows the adapter to stop displaying when closed
    }
    ///////////////////////////////////////////////////////////////////// onStop()



}
///////////////////////////////////////////////////////////////////// ViewItems.java