package com.m3t.myapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.m3t.myapp.fragment.AuctionFragment;
import com.m3t.myapp.fragment.MainFragment;
import com.m3t.myapp.fragment.UserMaintainFragment;

/**
 * Created by namvp58uet on 27/05/2016.
 */
public class SectionalPagerAdapter extends FragmentPagerAdapter {

    public SectionalPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainFragment();
            case 1:
                return new AuctionFragment();
            case 2:
                return new UserMaintainFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home Page";
            case 1:
                return "Auction";
            case 2:
                return "User Maintain";
        }
        return null;
    }
}
