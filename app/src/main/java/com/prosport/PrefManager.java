package com.prosport;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 29.06.17.
 */

public class PrefManager {
    private SharedPreferences  preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private final String PREFERANCE_NAME = "ProSportPreferences";
    private final String PREFERENCE_FIRST_LAUNCH_NAME = "firstLaunch";


    public  PrefManager(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREFERANCE_NAME,Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setFirstLaunch(boolean launch){
        editor.putBoolean(PREFERENCE_FIRST_LAUNCH_NAME,launch);
        editor.commit();
    }

    public boolean getFirstLaunch(){
        return preferences.getBoolean(PREFERENCE_FIRST_LAUNCH_NAME,true);
    }
}
