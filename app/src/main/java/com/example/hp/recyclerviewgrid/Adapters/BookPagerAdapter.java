package com.example.hp.recyclerviewgrid.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.hp.recyclerviewgrid.Activities.BookDetailsActivity;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Fragments.BookDetailsFragment;
import com.example.hp.recyclerviewgrid.Fragments.ChaptersListFragment;
import com.example.hp.recyclerviewgrid.Entities.Result;

/**
 * Created by user on 3/13/18.
 */

public class BookPagerAdapter extends FragmentPagerAdapter {
    Book book;
    Fragment bookDetailsFragment;
    Fragment bookChaptersList;
    public BookPagerAdapter(FragmentManager fm, Book book) {
        super(fm);
        this.book = book;
    }

    @Override
    public Fragment getItem(int position) {
        bookDetailsFragment = new BookDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(Book.BOOK_OBJECT, book);
        bookDetailsFragment.setArguments(args);
        bookChaptersList = new ChaptersListFragment();
        bookChaptersList.setArguments(args);
        if(position == 0)
            return bookDetailsFragment;
        return bookChaptersList;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "Описание";
        return "Список глав";
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
