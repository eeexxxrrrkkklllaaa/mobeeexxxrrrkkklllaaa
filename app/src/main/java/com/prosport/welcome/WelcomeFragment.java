package com.prosport.welcome;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prosport.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by root on 29.06.17.
 */

public class WelcomeFragment extends Fragment {

    @BindView(R.id.welcomeImageView) ImageView imageView;
    @BindView(R.id.welcomeTitle) TextView title;
    @BindView(R.id.welcomeDescription) TextView description;
    @BindView(R.id.fragment_welcome) RelativeLayout layout;

    private String mTitle, mDescription, backgroundColor, shadowLineColor;
    private int mImage;


    public static WelcomeFragment newInstance(String mTitle, String mDescription, int mImage,
                                              String backgroundColor){
        Fragment fragment = new WelcomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mImage", mImage);
        bundle.putString("mTitle",mTitle);
        bundle.putString("mDescription",mDescription);
        bundle.putString("backgroundColor", backgroundColor);
        fragment.setArguments(bundle);
        return (WelcomeFragment)fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_welcome, container, false);
        ButterKnife.bind(this, v);

        initializeFragment();

        return v;
    }


    private void initializeFragment(){
            mTitle = getArguments().getString("mTitle");
            mDescription = getArguments().getString("mDescription");
            mImage = getArguments().getInt("mImage");
            backgroundColor = getArguments().getString("backgroundColor");
            shadowLineColor = getArguments().getString("shadowLineColor");
            title.setText(mTitle);
            description.setText(mDescription);
            imageView.setImageDrawable(getActivity().getResources().getDrawable(mImage));
            layout.setBackgroundColor(Color.parseColor(backgroundColor));
    }

}
