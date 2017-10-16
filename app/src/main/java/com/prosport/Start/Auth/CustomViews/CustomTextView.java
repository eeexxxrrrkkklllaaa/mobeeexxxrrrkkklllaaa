package com.prosport.Start.Auth.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.prosport.R;

/**
 * Created by roman on 17.09.17.
 */

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    private final int REGULAR_TEXT = 1;
    private TypedArray typedArray;
    private Typeface typeface;
    private Context context;
    private int fontType;

    public CustomTextView(Context context) {
        super(context);
        this.context = context;
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        fontType = typedArray.getInt(R.styleable.CustomTextView_font, 0);
        setFont(fontType);
    }

    public void setFont(int fontType){
        String path;
        switch (fontType){
            case 1:
                path = "fonts/exo2_light.ttf";
                break;
            case 2:
                path = "fonts/exo2_bold.ttf";
            default:
                path = "fonts/exo2_light.ttf";
        }
        typeface = Typeface.createFromAsset(context.getAssets(), path);
        this.setTypeface(typeface);
    }

}
