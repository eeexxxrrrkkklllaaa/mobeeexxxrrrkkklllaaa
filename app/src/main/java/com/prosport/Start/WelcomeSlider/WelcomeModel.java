package com.prosport.Start.WelcomeSlider;

/**
 * Created by root on 29.06.17.
 */

public class WelcomeModel  {

    private String mTitle;
    private String mDescription;
    private int mBackground;

    public WelcomeModel(String mTitle, String mDescription, int mBackground){
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mBackground = mBackground;
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

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public int getmBackground() {
        return mBackground;
    }

    public void setmBackground(int mBackground) {
        this.mBackground = mBackground;
    }
}
