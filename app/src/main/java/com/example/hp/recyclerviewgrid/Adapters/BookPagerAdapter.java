package com.example.hp.recyclerviewgrid.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp.recyclerviewgrid.Activities.BookDetailsActivity;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Fragments.BookDetailsFragment;
import com.example.hp.recyclerviewgrid.Entities.Result;

/**
 * Created by user on 3/13/18.
 */

public class BookPagerAdapter extends FragmentPagerAdapter {
    Book book;
    public BookPagerAdapter(FragmentManager fm, Book book) {
        super(fm);
        this.book = book;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            Fragment fragment = new BookDetailsFragment();
            Bundle args = new Bundle();
            args.putParcelable(Book.BOOK_OBJECT, book);
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
