package com.m3t.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
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
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private SectionalPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //setup toolbar
        setSupportActionBar(toolBar);
        //set up drawer layout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        //set up tab layout
        mPagerAdapter = new SectionalPagerAdapter(getSupportFragmentManager());
        container.setAdapter(mPagerAdapter);
        tab.setupWithViewPager(container);
    }
}
