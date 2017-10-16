package com.prosport.Start;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.prosport.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


/**
 * Created by root on 29.06.17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.replace(R.id.welcomeActivityLayout, fragment);
        fragmentTransaction.commit();
    }
}

