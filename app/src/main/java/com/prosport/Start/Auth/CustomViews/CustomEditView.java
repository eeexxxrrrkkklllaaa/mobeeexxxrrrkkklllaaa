package com.prosport.Start.Auth.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.ImageView;
import com.prosport.R;

/**
 * Created by roman on 16.09.17.
 */

public class CustomEditView extends AbstractAnimatedView {

    private TypedArray typedArray;
    private ImageView imageView;
    private EditText editText;
    private ImageView imageViewReal;
    private EditText editTextReal;
    private Context context;

    private String hint, text;
    private final int defaultTextSize = 22;
    private boolean isRevealed;
    private int hintColor, icon, iconReal, textColor, textSize,
                iconColorFill, backgroundColorFill, iconBackgroundColor, editBackgroundColor;

    public CustomEditView(Context context){
        super(context, null);
        typedArray = context.obtainStyledAttributes(null, R.styleable.CustomEditView, 0, 0);
        this.context = context;
        setViews();
        setAttrs(typedArray);
    }

    public CustomEditView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditView, 0, 0);
        this.context = context;
        setViews();
        setAttrs(typedArray);
    }

    public CustomEditView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditView, 0, 0);
        this.context = context;
        setViews();
        setAttrs(typedArray);
    }

    private void setViews(){
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.view_custom_edit, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        imageView = (ImageView)findViewById(R.id.imageView);
        editText = (EditText)findViewById(R.id.editText);
        imageViewReal = (ImageView)findViewById(R.id.imageViewReal);
        editTextReal = (EditText)findViewById(R.id.editTextReal);
        if(typedArray != null)
            reactOnAttrs();
    }

    private void setAttrs(TypedArray typedArray){
        if(typedArray != null) {
            hint = typedArray.getString(R.styleable.CustomEditView_hint);
            text = typedArray.getString(R.styleable.CustomEditView_text);
            hintColor = typedArray.getColor(R.styleable.CustomEditView_hintColor, R.color.colorAccent);
            icon = typedArray.getResourceId(R.styleable.CustomEditView_icon, R.drawable.ic_email_inactive);
            iconReal = typedArray.getResourceId(R.styleable.CustomEditView_activeIcon, R.drawable.ic_email_active);
            textColor = typedArray.getColor(R.styleable.CustomEditView_textColor, android.R.color.white);
            textSize = typedArray.getInt(R.styleable.CustomEditView_textSize, defaultTextSize);
            iconColorFill = typedArray.getColor(R.styleable.CustomEditView_iconColorFill, 0);
            backgroundColorFill = typedArray.getColor(R.styleable.CustomEditView_backgroundColorFill, 0);
            iconBackgroundColor = typedArray.getColor(R.styleable.CustomEditView_iconBackgroundColor, 0);
            editBackgroundColor = typedArray.getColor(R.styleable.CustomEditView_editBackgroundColor, 0);
            isRevealed = typedArray.getBoolean(R.styleable.CustomEditView_isReveal, false);
        }
    }

    private void reactOnAttrs(){
        editText.setHint(hint);
        editText.setHintTextColor(hintColor);
        editText.setTextSize(textSize);
        imageView.setImageDrawable(context.getResources().getDrawable(icon));
        editText.setTextColor(textColor);
        if(editBackgroundColor != 0)
            editText.setBackgroundColor(editBackgroundColor);
        if(iconBackgroundColor != 0)
            imageView.setBackgroundColor(iconBackgroundColor);
        setReveal(isRevealed);
        editTextReal.setHint(hint);
        editTextReal.setHintTextColor(hintColor);
        editTextReal.setTextSize(textSize);
        imageViewReal.setImageDrawable(context.getResources().getDrawable(icon));
        editTextReal.setTextColor(textColor);
    }

    public void setReveal(boolean isRevealed){
        if(isRevealed)
        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus){
                startRevealAnimation(editTextReal, editText, backgroundColorFill, 0);
                startRevealAnimation(imageViewReal, imageView, iconColorFill, iconReal);
            }else{
                startRevealAnimation(editTextReal, editText, editBackgroundColor, 0);
                startRevealAnimation(imageViewReal, imageView, iconBackgroundColor, icon);
            }
        });
    }

    public void setRevealed(boolean isRevealed){
        this.isRevealed = isRevealed;
    }

    public void setHintColor(int hintColor) {
        this.hintColor = hintColor;
        editText.setHintTextColor(hintColor);
    }

    public void setIcon(int icon) {
        this.icon = icon;
        imageView.setImageDrawable(context.getResources().getDrawable(icon));
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
        editText.setTextColor(textColor);
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        editText.setTextSize(textSize);
    }

    public void setIconColorFill(int iconColorFill) {
        this.iconColorFill = iconColorFill;
    }

    public void setBackgroundColorFill(int backgroundColorFill) {
        this.backgroundColorFill = backgroundColorFill;
    }

    public void setIconBackgroundColor(int iconBackgroundColor) {
        this.iconBackgroundColor = iconBackgroundColor;
        imageView.setBackgroundColor(iconBackgroundColor);
    }

    public void setEditBackgroundColor(int editBackgroundColor){
        this.editBackgroundColor = editBackgroundColor;
        editText.setBackgroundColor(editBackgroundColor);
    }

    public void setHint(String hint) {
        this.hint = hint;
        editText.setHint(hint);
    }

    public void setText(String text) {
        this.text = text;
        editText.setText(text);
    }
}
