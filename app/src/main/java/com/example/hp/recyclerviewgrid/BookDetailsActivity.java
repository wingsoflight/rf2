package com.example.hp.recyclerviewgrid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * Created by user on 3/13/18.
 */

public class BookDetailsActivity extends FragmentActivity {
    final static String RESULT_OBJECT = "Result object";
    ViewPager mViewPager;
    BookPagerAdapter mBookPagerAdapter;
    Intent intent;
    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_pager);
        mViewPager = findViewById(R.id.aboutBookPager);
        intent = getIntent();
        result = intent.getParcelableExtra(RESULT_OBJECT);
        mBookPagerAdapter = new BookPagerAdapter(getSupportFragmentManager(), result);
        mViewPager.setAdapter(mBookPagerAdapter);
    }
}
