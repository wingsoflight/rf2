package com.example.hp.recyclerviewgrid.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.recyclerviewgrid.Activities.BookDetailsActivity;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Entities.Result;
import com.example.hp.recyclerviewgrid.R;
import com.squareup.picasso.Picasso;

/**
 * Created by user on 3/13/18.
 */

public class BookDetailsFragment extends Fragment {
    TextView titleTextView, descriptionTextView, bookLikesCountTextView, bookDislikesCountTextView, bookViewsCountTextView, bookCountryTextView, bookAuthorTextView, bookChaptersCountTextView, bookGenresTextView, bookRatingTextView, bookStatusTextView;
    ImageView bookDetailsImageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_detail, container, false);
        Bundle args = getArguments();
        Book book = args.getParcelable(Book.BOOK_OBJECT);

        titleTextView = rootView.findViewById(R.id.bookTitleTextView);
        bookDetailsImageView = rootView.findViewById(R.id.bookImageView);
        descriptionTextView = rootView.findViewById(R.id.bookDescriptionTextView);
        bookLikesCountTextView = rootView.findViewById(R.id.bookLikesCountTextView);
        bookDislikesCountTextView = rootView.findViewById(R.id.bookDislikesCountTextView);
        bookViewsCountTextView = rootView.findViewById(R.id.bookViewCountTextView);
        bookCountryTextView = rootView.findViewById(R.id.bookCountryTextView);
        bookAuthorTextView = rootView.findViewById(R.id.bookAuthorTextView);
        bookChaptersCountTextView = rootView.findViewById(R.id.bookChaptersCountTextView);
        bookGenresTextView = rootView.findViewById(R.id.bookGenresTextView);
        bookRatingTextView = rootView.findViewById(R.id.bookRatingTextView);
        bookStatusTextView = rootView.findViewById(R.id.bookStatusTextView);

        titleTextView.setText(book.getTitle());
        descriptionTextView.setText(book.getDescription());
        bookLikesCountTextView.setText(""+book.getLikes());
        bookDislikesCountTextView.setText(""+book.getDislikes());
        bookViewsCountTextView.setText(""+book.getView_count());
        bookCountryTextView.setText("Страна: "+book.getCountry());
        bookAuthorTextView.setText(""+book.getAuthor());
        bookChaptersCountTextView.setText("Всего глав: "+ (book.getChapters() == null ? 0 : book.getChapters().size()));
        bookGenresTextView.setText("Жанры: "+book.getGenres());
        bookRatingTextView.setText("Рейтинг: "+book.getRating());
        bookStatusTextView.setText(""+book.getStatus());
        Picasso.with(getContext()).load(book.getImageURL()).placeholder(R.drawable.book_image_placeholder_vertical).error(R.drawable.book_image_placeholder_vertical).into(bookDetailsImageView);
        return rootView;
    }
}
