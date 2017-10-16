package com.prosport.Start.WelcomeSlider;

import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.prosport.Main.MainActivity;
import com.prosport.Main.MainActivity_;
import com.prosport.PrefManager;
import com.prosport.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;


/**
 * Created by root on 29.06.17.
 */

@EFragment(R.layout.fragment_welcome_container)
public class WelcomeContainerFragment extends Fragment {
    private WelcomePagerAdapter adapter;
    private PrefManager prefManager;

    @ViewById(R.id.skipButton)
    Button skipBtn;
    @ViewById(R.id.nextButton) Button nextBtn;
    @ViewById(R.id.welcomeViewPager)
    ViewPager viewPager;

    @StringRes(R.string.begin)
    String beginText;
    @StringRes(R.string.next)
    String nextText;

    @Click(R.id.nextButton)
    protected void onNextButtonClicked(){
        if(viewPager.getCurrentItem() == adapter.getCount()-1){
            PrefManager prefManager = new PrefManager(getActivity());
            prefManager.setFirstLaunch(false);
            MainActivity_.intent(this).start();
        }

        else if (viewPager.getCurrentItem() < adapter.getCount() - 1){
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1,true);
        }
    }

    @Click(R.id.skipButton)
    protected void onSkipButtonClicked(){
        prefManager.setFirstLaunch(false);
        MainActivity_.intent(this).start();
        getActivity().finish();
    }

    @AfterViews
    protected void afterViews(){
        initViews();
    }

    private void initViews(){
        prefManager = new PrefManager(getActivity());
        adapter = new WelcomePagerAdapter(getFragmentManager(), fillAdapter(WelcomeValues.slide_titles.length));
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                if(position == adapter.getCount()-1){
                    skipBtn.setVisibility(View.GONE);
                    nextBtn.setText(beginText);
                }
                else {
                    skipBtn.setVisibility(View.VISIBLE);
                    nextBtn.setText(nextText);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        if(prefManager != null && !prefManager.getFirstLaunch()){
            MainActivity_.intent(this).start();
            getActivity().finish();
        }
    }

    private Fragment[] fillAdapter(int count){
        Fragment[] fragments = new Fragment[count];
        for(int i = 0; i < count; i++){
            fragments[i] = WelcomeFragment_.builder().
                    arg("mTitle", WelcomeValues.slide_titles[i]).
                    arg("mDescription", WelcomeValues.slide_descs[i]).
                    arg("mBackground", WelcomeValues.backgrounds[i]).
                    build();
        }
        return fragments;
    }

}
