package com.prosport.Start.Auth.CustomViews;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.prosport.R;

/**
 * Created by roman on 16.09.17.
 */

public abstract class AbstractAnimatedView extends RelativeLayout {

    private Context context;

    public AbstractAnimatedView(Context context){
        super(context);
        this.context = context;
    }

    public AbstractAnimatedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public AbstractAnimatedView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
    }

    protected void startRevealAnimation(View view, View old, int color, int drawable){
        double length = Math.hypot(view.getWidth(), view.getHeight());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = ViewAnimationUtils.createCircularReveal(view, 0, 0,
                    0, (float)length);
            animator.setDuration(500);
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    view.setVisibility(View.VISIBLE);
                    view.setBackgroundColor(color);
                    if(drawable != 0)
                        ((ImageView)view).
                                setImageDrawable(context.getResources().getDrawable(drawable));
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    view.setVisibility(View.INVISIBLE);
                    old.setBackgroundColor(color);
                    if(drawable != 0)
                        ((ImageView)old).
                                setImageDrawable(context.getResources().getDrawable(drawable));
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            animator.start();
        }
    }


}
