package com.prosport.welcome;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.prosport.MainActivity;
import com.prosport.PrefManager;
import com.prosport.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by root on 29.06.17.
 */

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private WelcomePagerAdapter adapter;

    @BindView(R.id.skipButton) Button skipBtn;
    @BindView(R.id.nextButton) Button nextBtn;
    @BindView(R.id.shadowLine) RelativeLayout shadowLine;




    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        initViews();


    }

    private void initViews(){
        viewPager = (ViewPager)findViewById(R.id.welcomeViewPager);

        adapter = new WelcomePagerAdapter(getFragmentManager(), fillAdapter(5));
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                shadowLine.setBackgroundColor(Color.parseColor(Values.slide_shadow_line_colors[position]));
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        shadowLine.setBackgroundColor(Color.parseColor(Values.slide_shadow_line_colors[0]));

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
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                if(position == adapter.getCount()-1){
                    skipBtn.setVisibility(View.GONE);
                    nextBtn.setText("begin");
                }
                else {
                    skipBtn.setVisibility(View.VISIBLE);
                    nextBtn.setText("next");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

    }

    private Fragment[] fillAdapter(int count){
        Fragment[] fragments = new Fragment[count];
        for(int i = 0; i < count; i++){
            fragments[i] = WelcomeFragment.newInstance(Values.slide_titles[i],
                    Values.slide_descs[i], Values.slide_images[i], Values.slide_colors[i]);
        }
        return fragments;
    }


}

