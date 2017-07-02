package com.prosport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prosport.welcome.WelcomeActivity;

public class MainActivity extends AppCompatActivity {

    PrefManager prefManager;
    Button repeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repeat = (Button)findViewById(R.id.testRepeatWelcome);


        prefManager = new PrefManager(getBaseContext());

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefManager.setFirstLaunch(true);
            }
        });

        if (prefManager.getFirstLaunch()){
            Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
            startActivity(intent);
        }





    }





}
