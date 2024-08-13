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
// Class Name: OnBoardingFragment1.java
// Class Description: This class controls fragment activity 1 and displays its respected xml.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// OnBoardingFragment1.java
public class OnBoardingFragment1 extends Fragment {



    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    Button skip1;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreateView()
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding1, container, false); // sets layout to first fragment xml

        skip1 = root.findViewById(R.id.skip3);

        skip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class); // redirects to LoginActivity
                startActivity(intent);
            }
        });
        return root;
    }
    ///////////////////////////////////////////////////////////////////// onCreateView()



}
///////////////////////////////////////////////////////////////////// OnBoardingFragment1.java