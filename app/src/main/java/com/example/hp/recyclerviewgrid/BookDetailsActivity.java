package com.example.hp.recyclerviewgrid;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

/**
 * Created by user on 3/13/18.
 */

public class BookDetailsActivity extends FragmentActivity {
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_pager);
        mViewPager = findViewById(R.id.aboutBookPager);
    }
}
