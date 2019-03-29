package com.example.fauzighozali.instagram.register.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.fauzighozali.instagram.register.fragment.TeleponeFragment;
import com.example.fauzighozali.instagram.register.fragment.EmailFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                TeleponeFragment firstTab = new TeleponeFragment();
                return firstTab;
            case 1:
                EmailFragment secondTab = new EmailFragment();
                return secondTab;
                default:
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Telepon";
            case 1:
                return "Email";
        }
        return null;
    }
}
