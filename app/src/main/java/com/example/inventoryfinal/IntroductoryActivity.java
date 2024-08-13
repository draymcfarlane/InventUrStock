package com.example.inventoryfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import pl.droidsonroids.gif.GifImageView;

////////////////////////////////////////////////////////////
//
// Author: Deonaundray McFarlane
// Date: 04/13/21
// Program: InventUrStock
// Class Name: IntroductoryActivity.java
// Class Description: This class presents a splash gif inclusive of the application name. Afterwards, it redirects with a smooth transition to three fragment
//                    activities which gives a brief overview regarding the app's strong points.
//
////////////////////////////////////////////////////////////



///////////////////////////////////////////////////////////////////// IntroductoryActivity.java
public class IntroductoryActivity extends AppCompatActivity {



    ///////////////////////////////////////////////////////////////////// Variables
    // Android variables
    private TextView title, bg;
    private Animation bottom;
    private GifImageView gifImageView;

    // Static counter for 3 fragment activities
    private static final int numpage = 3;

    // Firebase variables
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;
    ///////////////////////////////////////////////////////////////////// Variables



    ///////////////////////////////////////////////////////////////////// onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // removal of utility bar and action bar at the top and bottom of screen
        setContentView(R.layout.activity_main);

        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_animation); // drop down animation

        title = findViewById(R.id.appname); // header
        bg = findViewById(R.id.splashbg); // coloured background
        gifImageView = findViewById(R.id.gifsplash); // gif animation

        title.setAnimation(bottom); // set drop down animation

        viewPager = findViewById(R.id.pager); // setting up the view pager for the three fragment activities
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager()); // declaring the page adapter
        viewPager.setAdapter(pagerAdapter); // setting the page adapter to the view pager

        bg.animate().translationY(-2500).setDuration(1000).setStartDelay(4000); // manual setting of animation rather than creating a anim resource file
        gifImageView.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);
        title.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);
    }
    ///////////////////////////////////////////////////////////////////// onCreate()



    ///////////////////////////////////////////////////////////////////// ScreenSlidePagerAdapter.class
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{



        ///////////////////////////////////////////////////////////////////// Class Constructor
        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }
        ///////////////////////////////////////////////////////////////////// Class Constructor



        ///////////////////////////////////////////////////////////////////// getItem()
        @NonNull
        @Override
        public Fragment getItem(int position) { // uses switch case statement to dictate which page is to be displayed
            switch (position){
                case 0:
                    OnBoardingFragment1 one = new OnBoardingFragment1();
                    return one;
                case 1:
                    OnBoardingFragment2 two = new OnBoardingFragment2();
                    return two;
                case 2:
                    OnBoardingFragment3 three = new OnBoardingFragment3();
                    return three;
            }
            return null;
        }
        ///////////////////////////////////////////////////////////////////// getItem()



        ///////////////////////////////////////////////////////////////////// getCount()
        @Override
        public int getCount() { // checks and returns page count
            return numpage;
        }
        ///////////////////////////////////////////////////////////////////// getCount()



    }
    ///////////////////////////////////////////////////////////////////// ScreenSlidePagerAdapter.class



}
///////////////////////////////////////////////////////////////////// IntroductoryActivity.java