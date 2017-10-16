package com.prosport.Start.Auth.CustomViews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.prosport.R;

/**
 * Created by roman on 16.09.17.
 */

public class CustomImageView extends AbstractAnimatedView {

    private TypedArray typedArray;
    private ImageView imageView, imageViewReal;
    private TextView textView;
    private Context context;

    private String text;
    private int colorActive, colorInactive;

    public CustomImageView(Context context){
        super(context, null);
        initView(null, context);
    }

    public CustomImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(attrs, context);

    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(attrs, context);
    }

    private void setViews(){
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_custom_image, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageView = (ImageView)findViewById(R.id.button);
        imageViewReal = (ImageView)findViewById(R.id.buttonReal);
        textView = (TextView)findViewById(R.id.text);
        if(typedArray != null)
            reactOnAttrs();
    }

    private void setAttrs(TypedArray typedArray){
        if(typedArray != null) {
            text = typedArray.getString(R.styleable.CustomImageView_textContent);
            colorInactive = typedArray.getColor(R.styleable.CustomImageView_colorInactive, R.color.colorInactive);
            colorActive = typedArray.getColor(R.styleable.CustomImageView_colorActive, R.color.colorPrimary);

        }
    }

    public void setReveal(boolean active){
        if(active)
            startRevealAnimation(imageViewReal, imageView, colorActive, 0);
        else
            startRevealAnimation(imageViewReal, imageView, colorInactive, 0);
    }

    private void initView(AttributeSet attrs, Context context){
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomImageView, 0, 0);
        this.context = context;
        setViews();
        setAttrs(typedArray);
    }

    private void reactOnAttrs(){
        textView.setText(text);
        imageView.setBackgroundColor(colorInactive);
        imageViewReal.setBackgroundColor(colorActive);
    }


    public void setColorActive(int colorActive) {
        this.colorActive = colorActive;
        imageViewReal.setBackgroundColor(colorActive);
    }

    public void setColorInactive(int colorInactive) {
        this.colorInactive = colorInactive;
        imageView.setBackgroundColor(colorInactive);
    }
}
