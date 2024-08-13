package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: ViewItemsEdit.java
// Class Description: This class allows the user to display their inventory from the database, as well as add new inventory using a floating action button.
//                    Swipe to delete is another function that differs from the ViewItems class, allows the user to delete inventory.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// ViewItemsEdit.java
public class ViewItemsEdit extends AppCompatActivity{

    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private RecyclerView recyclerView;
    private AddNewAdapter adapter;
    private Button exitedit;
    private Animation bottom, up;
    private TextView title, viewitemsbg;
    private FloatingActionButton addfab;

    // Firebase variables
    private FirebaseRecyclerOptions<AddNewItemsClass> options;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_items_edit);

        ///////////// displays a dialog box
        AlertDialog.Builder dialog = new AlertDialog.Builder(ViewItemsEdit.this); // displays in ViewItemsEdit
        dialog.setTitle("Edit Items"); // title of dialog box
        dialog.setMessage("Welcome to Ur inventory display. To delete items, drag the preferred module to the right. " +
                "To Update items, re-enter the same barcode and update the fields that follows afterwards");
        dialog.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() { // setting dismiss button
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        ///////////// displays a dialog box

        title = findViewById(R.id.titledisplay6); // header
        viewitemsbg = findViewById(R.id.viewitemseditbg); // coloured background

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation
        up = AnimationUtils.loadAnimation(this, R.anim.slide_up); // slide up animation

        title.setAnimation(bottom); // set drop down animation
        viewitemsbg.setAnimation(up); // set slide up animation

        addItems();

        addfab = (FloatingActionButton) findViewById(R.id.addfabs);
        addfab.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewItemsEdit.this, AddItems.class)); // redirects to AddItems
            }
        });

        exitedit = (Button) findViewById(R.id.exitedit);
        exitedit.setOnClickListener(new View.OnClickListener() { // on click
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewItemsEdit.this, ViewItems.class)); // redirects to ViewItems
            }
        });
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// addItems()
    private void addItems() { // this module replicates the list view in the ViewItems class
        Query query = FirebaseDatabase.getInstance().getReference().child("Inventory");
        options = new FirebaseRecyclerOptions.Builder<AddNewItemsClass>().setQuery(query, AddNewItemsClass.class).build();
        adapter = new AddNewAdapter(options);
        recyclerView = findViewById(R.id.inventorydisplayedit); // setting the recyclerview's id
        recyclerView.setHasFixedSize(true); // setting layout size
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // setting layout
        recyclerView.setAdapter(adapter); // setting the adapter to the recyclerview
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback); // declaring swipe to delete
        itemTouchHelper.attachToRecyclerView(recyclerView); // attaching swipe to delete to the recyclerview
    }
    ///////////////////////////////////////////////////////////////////// addItems()



    ///////////////////////////////////////////////////////////////////// swipe to delete
    final ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false; // this method is for arranging items vertically
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.deleteItem(viewHolder.getAdapterPosition()); // this method deletes items swiping right
            Toast.makeText(ViewItemsEdit.this, "Item Deleted", Toast.LENGTH_SHORT).show();
        }

        final ColorDrawable background = new ColorDrawable(Color.WHITE); // setting color background to white

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            View itemView = viewHolder.itemView;
            int backgroundCornerOffset = 5;

            if (dX > 0) { // Swiping to the right
                background.setBounds(itemView.getLeft(), itemView.getTop(),
                        itemView.getLeft() + ((int) dX) + backgroundCornerOffset,
                        itemView.getBottom());
            } else { // view is unSwiped
                background.setBounds(0, 0, 0, 0);
            }
            background.draw(c); // draws on the canvas

            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(ViewItemsEdit.this, R.color.white)) // setting color
                    .addActionIcon(R.drawable.ic_action_delete) // setting a icon while swiping
                    .addSwipeRightLabel("Delete") // setting a label while deleting
                    .create()
                    .decorate();
        }
    };
    ///////////////////////////////////////////////////////////////////// swipe to delete



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
///////////////////////////////////////////////////////////////////// ViewItemsEdit.java