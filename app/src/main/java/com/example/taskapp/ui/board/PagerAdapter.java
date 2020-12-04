package com.example.taskapp.ui.board;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;

public class PagerAdapter extends fragmentStatePagerAdapter {

    private ArrayList<Fragment> mfragments = new ArrayList<>();

    public PagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        mfragments = fragments;
    }

    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    public int getCount() {
        return mfragments.size();
    }
}