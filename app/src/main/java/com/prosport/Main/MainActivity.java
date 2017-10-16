package com.prosport.Main;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.prosport.PrefManager;
import com.prosport.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.navigation)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.testRepeatWelcome) ImageView repeat;
    @ViewById(R.id.toolbar) Toolbar toolbar;
    @ViewById(R.id.drawerLayout) DrawerLayout drawerLayout;

    @Click(R.id.testRepeatWelcome)
    protected void onRepeatClicked(){
        prefManager.setFirstLaunch(true);
    }


    private ActionBarDrawerToggle toggle;
    private PrefManager prefManager;

    @AfterViews
    protected void afterViews(){
        setNavigation();
        setPrefManager();
    }

    private void setNavigation(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.nav_open, R.string.nav_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void setPrefManager(){
        prefManager = new PrefManager(this);

        if (prefManager.getFirstLaunch()){
            MainActivity_.intent(this).start();
        }
    }





}
