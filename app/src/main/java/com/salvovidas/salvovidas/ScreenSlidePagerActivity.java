package com.salvovidas.salvovidas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.salvovidas.salvovidas.fragments.AskFragment;
import com.salvovidas.salvovidas.fragments.BuddiesFragment;
import com.salvovidas.salvovidas.fragments.RouteFragment;
import com.salvovidas.salvovidas.fragments.SettingsFragment;

import java.util.ArrayList;
import java.util.List;

public class ScreenSlidePagerActivity extends FragmentActivity {
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    private Button prev;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide_pager);

        setUpSlider();
        setUpButtons();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void setUpButtons() {
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem() > 0) {
                    mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPager.getCurrentItem() < mPagerAdapter.getCount() - 1) {
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                }
            }
        });
    }

    private void startTracking() {
        Log.i("NEXT", "TRACKING...");
    }

    private void setUpSlider() {
        mPager = (ViewPager) findViewById(R.id.pager);

        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new AskFragment());
        fragments.add(new SettingsFragment());
        fragments.add(new BuddiesFragment());
        fragments.add(new RouteFragment());

        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mPagerAdapter);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments;

        public ScreenSlidePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = new ArrayList<>(fragments);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}

