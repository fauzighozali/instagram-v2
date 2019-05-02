package com.example.fauzighozali.instagram.register;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.fauzighozali.instagram.R;
import com.example.fauzighozali.instagram.register.adapter.PagerAdapter;
import com.example.fauzighozali.instagram.register.fragment.EmailFragment;
import com.example.fauzighozali.instagram.register.fragment.TeleponeFragment;

public class RegisterActivity extends AppCompatActivity {

    ViewPager simpleViewPager;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        simpleViewPager = findViewById(R.id.simpleViewPager);
        tabLayout = findViewById(R.id.simpleTabLayout);

        // ********** Init git for this project **********

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        simpleViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(simpleViewPager);

        // ********** Init git for this project **********

    }
}
