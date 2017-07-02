package com.prosport.welcome;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by root on 29.06.17.
 */

public class WelcomePagerAdapter extends FragmentPagerAdapter {

    private ArrayList<WelcomeModel> layoutModels;

    public WelcomePagerAdapter(FragmentManager fm) {
        super(fm);
        layoutModels = new ArrayList<>();
    }

    public void addItem(WelcomeModel model){
        layoutModels.add(model);
    }

    public void addItem(String mTitle, String mDescription, int mImage){
        layoutModels.add(new WelcomeModel(mTitle, mDescription, mImage));
    }

    @Override
    public Fragment getItem(int position) {
        return new WelcomeFragment().newInstance(layoutModels.get(position).getmTitle(),
                layoutModels.get(position).getmDesciption(),layoutModels.get(position).getmImageView());
    }

    @Override
    public int getCount() {
        return 3;
    }

}
