package com.example.inventoryfinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: AddNewAdapter.java
// Class Description: This class controls the Recyclerview and passes through the variables storing the database information.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// AddNewAdapter.java
public class AddNewAdapter extends FirebaseRecyclerAdapter<AddNewItemsClass, AddNewAdapter.AddHolder> {



    ///////////////////////////////////////////////////////////////////// Class Constructor
    public AddNewAdapter(@NonNull FirebaseRecyclerOptions<AddNewItemsClass> options) {
        super(options);
    }
    ///////////////////////////////////////////////////////////////////// Class Constructor



    ///////////////////////////////////////////////////////////////////// onBindViewHolder()
    @Override
    protected void onBindViewHolder(@NonNull AddHolder addHolder, int i, @NonNull AddNewItemsClass addNewItemsClass) { // setting display inside the Recyclerview

        ///////////// setting the text with the respective variable
        addHolder.barcode.setText("Barcode:    "+addNewItemsClass.getBarcode());
        addHolder.product.setText("Product:     "+addNewItemsClass.getProduct());
        addHolder.category.setText("Category:   "+addNewItemsClass.getCategory());
        addHolder.price.setText("Price:     "+"    "+addNewItemsClass.getPrice());
        addHolder.added_by.setText("Added by:  "+addNewItemsClass.getAdded_by()); // displays user's name
        ///////////// setting the text with the respective variable
    }
    ///////////////////////////////////////////////////////////////////// onBindViewHolder()



    ///////////////////////////////////////////////////////////////////// onCreateViewHolder()
    @NonNull
    @Override
    public AddHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // setting custom layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inventory_display, // setting custom layout of the Recyclerview
                parent, false);
        return new AddHolder(v);
    }
    ///////////////////////////////////////////////////////////////////// onCreateViewHolder()



    ///////////////////////////////////////////////////////////////////// deleteItem()
    public void deleteItem(int position) { // deleting inventory items
        getSnapshots().getSnapshot(position).getRef().removeValue(); // module is called when the user chooses the delete an item from the database's inventory
    }
    ///////////////////////////////////////////////////////////////////// deleteItem()



    ///////////////////////////////////////////////////////////////////// AddHolder.class
    class AddHolder extends RecyclerView.ViewHolder { // declaring variables

        ///////////// Declaring display variables
        TextView barcode;
        TextView product;
        TextView category;
        TextView price;
        TextView added_by;
        ///////////// Declaring display variables

        ///////////////////////////////////////////////////////////////////// AddHolder()
        public AddHolder(View itemView) { // setting id's
            super(itemView);

            ///////////// Setting display variables to their id's
            barcode = itemView.findViewById(R.id.barcodedisplay);
            product = itemView.findViewById(R.id.producdisplay);
            category = itemView.findViewById(R.id.categorydisplay);
            price = itemView.findViewById(R.id.pricedisplay);
            added_by = itemView.findViewById(R.id.added_bydisplay);
            ///////////// Setting display variables to their id's
        }
        ///////////////////////////////////////////////////////////////////// AddHolder()
    }
    ///////////////////////////////////////////////////////////////////// AddHolder.class



}
///////////////////////////////////////////////////////////////////// AddNewAdapter.java