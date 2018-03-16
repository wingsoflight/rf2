package com.example.hp.recyclerviewgrid.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hp.recyclerviewgrid.Adapters.BookChaptersRecyclerViewAdapter;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Entities.Chapter;
import com.example.hp.recyclerviewgrid.R;

import java.util.ArrayList;

/**
 * Created by HP on 16.03.2018.
 */

public class ChaptersListFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager recyclerViewLayoutManager;
    Book book;
    RecyclerView.Adapter recyclerViewAdapter;
    ArrayList<Chapter> chapters;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_chapters_list, container, false);
        recyclerView = rootView.findViewById(R.id.bookChaptersRecyclerView);
        chapters = new ArrayList<>();
        if(book != null)
            chapters = book.getChapters();
        recyclerView.setHasFixedSize(true);
        book = getArguments().getParcelable(Book.BOOK_OBJECT);
        recyclerViewLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewAdapter = new BookChaptersRecyclerViewAdapter(chapters);
        recyclerView.setAdapter(recyclerViewAdapter);
        return rootView;
    }
}