package com.example.hp.recyclerviewgrid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 3/13/18.
 */

public class BookPagerAdapter extends FragmentPagerAdapter {
    Result result;
    public BookPagerAdapter(FragmentManager fm, Result result) {
        super(fm);
        this.result = result;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            Fragment fragment = new BookDetailsFragment();
            Bundle args = new Bundle();
            args.putParcelable(BookDetailsActivity.RESULT_OBJECT, result);
            fragment.setArguments(args);
            return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "ASDASD";
    }
}
