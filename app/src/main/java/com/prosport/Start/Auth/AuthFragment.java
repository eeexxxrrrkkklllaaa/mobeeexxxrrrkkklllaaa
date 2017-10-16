package com.prosport.Start.Auth;

import android.app.Fragment;

import com.prosport.R;
import com.prosport.Start.Auth.CustomViews.CustomEditView;
import com.prosport.Start.Auth.CustomViews.CustomImageView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


/**
 * Created by root on 29.06.17.
 */

@EFragment(R.layout.fragment_auth)
public class AuthFragment extends Fragment {

    @ViewById(R.id.email) CustomEditView email;
    @ViewById(R.id.password) CustomEditView password;
    @ViewById(R.id.password_repeat) CustomEditView password_repeat;
    @ViewById(R.id.submit) CustomImageView submit;

    private boolean active;

    @Click(R.id.submit)
    protected void onSubmitted(){
        submit.setReveal(active);
        if(active)
            active = false;
        else
            active = true;
    }





    @AfterViews
    protected void afterViews(){
    }


}
