package com.example.hp.recyclerviewgrid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.hp.recyclerviewgrid.Adapters.BookPagerAdapter;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Entities.Result;
import com.example.hp.recyclerviewgrid.R;

/**
 * Created by user on 3/13/18.
 */

public class BookDetailsActivity extends FragmentActivity {
    public final static String RESULT_OBJECT = "Result object";
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
        Book book = new Book(result.getTitle(), result.getDescription(), result.getLikes(), result.getDislikes(), result.getView(), result.getImage().getDesktop().getImage());
        mBookPagerAdapter = new BookPagerAdapter(getSupportFragmentManager(), book);
        mViewPager.setAdapter(mBookPagerAdapter);
    }
}
