package com.prosport.welcome;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

/**
 * Created by root on 29.06.17.
 */

public class WelcomePagerAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments;

    public WelcomePagerAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

}
