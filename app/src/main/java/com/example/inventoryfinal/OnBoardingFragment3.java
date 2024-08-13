package com.example.inventoryfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: OnBoardingFragment3.java
// Class Description: This class controls fragment activity 3 and displays its respected xml.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// OnBoardingFragment3.java
public class OnBoardingFragment3 extends Fragment {



    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    Button nextpg;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreateView()
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding3, container, false); // sets layout to first fragment xml

        nextpg = root.findViewById(R.id.buttonnextpg);

        nextpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), LoginActivity.class); // redirects to LoginActivity
                startActivity(intent2);
            }
        });
        return root;
    }
    ///////////////////////////////////////////////////////////////////// onCreateView()



}
///////////////////////////////////////////////////////////////////// OnBoardingFragment3.java