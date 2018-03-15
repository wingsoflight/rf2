package com.example.hp.recyclerviewgrid.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.transition.Visibility;
import android.view.View;
import android.widget.ProgressBar;

import com.example.hp.recyclerviewgrid.Adapters.BookPagerAdapter;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Entities.Result;
import com.example.hp.recyclerviewgrid.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by user on 3/13/18.
 */

public class BookDetailsActivity extends FragmentActivity {
    public final static String RESULT_OBJECT = "Result object";
    ProgressBar bookPagerProgressBar;
    ViewPager mViewPager;
    BookPagerAdapter mBookPagerAdapter;
    Intent intent;
    Result result;
    Book book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_pager);
        bookPagerProgressBar = findViewById(R.id.bookPagerProgressBar);
        mViewPager = findViewById(R.id.aboutBookPager);
        intent = getIntent();
        result = intent.getParcelableExtra(RESULT_OBJECT);
        book = new Book(result.getTitle(), result.getDescription(), result.getLikes(), result.getDislikes(), result.getView(), result.getImage().getDesktop().getImage());
        new getBookInfo().execute();
    }

    class getBookInfo extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try{
                Document doc = Jsoup.connect(result.getUrl()).get();
                String country = doc.selectFirst("div.book__block-item.country-block > div > a").text();
                String author = doc.selectFirst("div.book__block-name").text();
                String rating = doc.selectFirst("div.rating-text").text();
                Elements chaptersTables = doc.select("table.table");
                for(Element e: chaptersTables){
                    Element ahref = e.selectFirst("a[href]");
                    System.out.println(ahref.attr("href"));
                    System.out.println(ahref.text());
                }
                book.setCountry(country);

            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void s) {
            mBookPagerAdapter = new BookPagerAdapter(getSupportFragmentManager(), book);
            mViewPager.setAdapter(mBookPagerAdapter);
            bookPagerProgressBar.setVisibility(View.GONE);
            mViewPager.setVisibility(View.VISIBLE);
        }
    }
}
