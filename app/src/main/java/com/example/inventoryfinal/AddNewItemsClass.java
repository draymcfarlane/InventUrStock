package com.example.inventoryfinal;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: AddNewItemsClass.java
// Class Description: This class controls the Getter's for the inventory addition variables.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// AddNewItemsClass.java
public class AddNewItemsClass {

    public String barcode, product, category, price, added_by;



    ///////////////////////////////////////////////////////////////////// Empty Constructor
    public AddNewItemsClass(){
        // empty constructor needed for firebase
    }
    ///////////////////////////////////////////////////////////////////// Empty Constructor



    ///////////////////////////////////////////////////////////////////// Initialize in constructor
    public AddNewItemsClass(String barcode, String product, String category, String price, String added_by) {
        this.barcode = barcode;
        this.product = product;
        this.category = category;
        this.price = price;
        this.added_by = added_by;
    }
    ///////////////////////////////////////////////////////////////////// Initialize in constructor



    ///////////////////////////////////////////////////////////////////// Getter's
    public String getBarcode() {
        return barcode;
    }

    public String getProduct() {
        return product;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }

    public String getAdded_by() {
        return added_by;
    }
    ///////////////////////////////////////////////////////////////////// Getter's



}
///////////////////////////////////////////////////////////////////// AddNewItemsClass.java
