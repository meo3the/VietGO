package com.m3t.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.m3t.myapp.adapter.SectionalPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nam on 5/26/2016.
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.container)
    ViewPager container;
    @BindView(R.id.tab)
    TabLayout tab;
    private SectionalPagerAdapter mpagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolBar);

        mpagerAdapter = new SectionalPagerAdapter(getSupportFragmentManager());
        container.setAdapter(mpagerAdapter);
        tab.setupWithViewPager(container);
    }
}
