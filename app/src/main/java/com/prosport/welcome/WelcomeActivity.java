package com.prosport.welcome;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.prosport.MainActivity;
import com.prosport.PrefManager;
import com.prosport.R;


/**
 * Created by root on 29.06.17.
 */

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private WelcomePagerAdapter adapter;
    private Button skipBtn;
    private Button nextBtn;



    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initViews();


    }

    private void initViews(){
        viewPager = (ViewPager)findViewById(R.id.welcomeViewPager);

        adapter = new WelcomePagerAdapter(getSupportFragmentManager());

        adapter.addItem(Values.slide_1_title,Values.slide_1_desc,Values.slide_1_image);
        adapter.addItem(Values.slide_2_title,Values.slide_2_desc,Values.slide_2_image);
        adapter.addItem(Values.slide_3_title,Values.slide_3_desc,Values.slide_3_image);

        viewPager.setAdapter(adapter);

        nextBtn = (Button)findViewById(R.id.nextButton);
        skipBtn = (Button)findViewById(R.id.skipButton);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem() == adapter.getCount()-1){
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    PrefManager prefManager = new PrefManager(getBaseContext());
                    prefManager.setFirstLaunch(false);
                    startActivity(intent);
                }

                else if (viewPager.getCurrentItem() < adapter.getCount()-1){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1,true);
                }
            }
        });

        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                PrefManager prefManager = new PrefManager(getBaseContext());
                prefManager.setFirstLaunch(false);
                startActivity(intent);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == adapter.getCount()-1){
                    skipBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setText("lets rock");
                }
                else {
                    skipBtn.setVisibility(View.VISIBLE);
                    nextBtn.setText("next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


}

