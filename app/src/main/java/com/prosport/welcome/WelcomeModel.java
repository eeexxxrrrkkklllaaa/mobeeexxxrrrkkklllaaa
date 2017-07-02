package com.prosport.welcome;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by root on 29.06.17.
 */

public class WelcomeModel  {
    private String mTitle;
    private String mDescription;
    private int mImage;

    public WelcomeModel(String mTitle, String mDescription, int mImage){
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImage = mImage;
    }

    public int getmImageView() {
        return mImage;
    }

    public String getmDesciption() {
        return mDescription;
    }

    public void setmDesciption(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
