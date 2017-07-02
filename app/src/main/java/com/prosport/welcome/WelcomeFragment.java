package com.prosport.welcome;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prosport.R;

import java.util.zip.Inflater;



/**
 * Created by root on 29.06.17.
 */

public class WelcomeFragment extends Fragment {

    private ImageView imageView;
    private TextView title;
    private TextView description;
    private RelativeLayout layout;

    String mTitle;
    String mDescription;
    int mImage;

    public WelcomeFragment(){

    }

    public  static Fragment newInstance(String mTitle, String mDescription, int mImage){
        Fragment fragment = new WelcomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("mImage", mImage);
        bundle.putString("mTitle",mTitle);
        bundle.putString("mDescription",mDescription);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mTitle = getArguments().getString("mTitle");
            mDescription = getArguments().getString("mDescription");
            mImage = getArguments().getInt("mImage");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.welcome_slide,container,false);
        instViews(v);

        return v;
    }

    private void instViews(View v){
        imageView = (ImageView)v.findViewById(R.id.welcomeSlideImageView);
        title = (TextView)v.findViewById(R.id.welcomeSlideTitle);
        description = (TextView)v.findViewById(R.id.welcomeSlideDescription);
        layout = (RelativeLayout)v.findViewById(R.id.welcomeLayout);


        if (mTitle!=null){
            title.setText(mTitle);
        }

        if (mDescription != null){
            description.setText(mDescription);
        }

        if(mImage!=0){
            imageView.setImageResource(mImage);
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
