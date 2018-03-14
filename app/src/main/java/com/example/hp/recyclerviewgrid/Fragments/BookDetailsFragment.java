package com.example.hp.recyclerviewgrid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.recyclerviewgrid.Activities.BookDetailsActivity;
import com.example.hp.recyclerviewgrid.Entities.Result;
import com.example.hp.recyclerviewgrid.R;

/**
 * Created by user on 3/13/18.
 */

public class BookDetailsFragment extends Fragment {
    TextView titleTextView, descriptionTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail, container, false);
        Bundle args = getArguments();
        Result result = args.getParcelable(BookDetailsActivity.RESULT_OBJECT);
        titleTextView = rootView.findViewById(R.id.bookTitleTextView);
        descriptionTextView = rootView.findViewById(R.id.bookDescriptionTextView);
        titleTextView.setText(result.getTitle());
        descriptionTextView.setText(result.getDescription());
        return rootView;
    }
}
