package com.prosport.Start;
import android.app.Fragment;
import com.prosport.R;
import com.prosport.Start.Auth.AuthFragment_;
import com.prosport.Start.WelcomeSlider.WelcomeContainerFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;


/**
 * Created by root on 29.06.17.
 */
@EActivity(R.layout.activity_welcome)
public class WelcomeActivity extends BaseActivity {

    private Fragment welcomeFragment, authFragment;

    @AfterViews
    protected void afterViews(){
        welcomeFragment = WelcomeContainerFragment_.builder().build();
        authFragment = AuthFragment_.builder().build();
        replaceFragment(authFragment);
    }


}

