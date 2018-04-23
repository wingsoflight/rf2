package com.example.hp.recyclerviewgrid.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.hp.recyclerviewgrid.Adapters.BookPagerAdapter;
import com.example.hp.recyclerviewgrid.Entities.Book;
import com.example.hp.recyclerviewgrid.Entities.Chapter;
import com.example.hp.recyclerviewgrid.Entities.Result;
import com.example.hp.recyclerviewgrid.R;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BookDetailsActivity extends FragmentActivity {
    public final static String RESULT_OBJECT = "Result object";
    private final static String TAG = "BOOK_DETAILS_ACTIVITY";
    ViewPager mViewPager;
    BookPagerAdapter mBookPagerAdapter;
    Intent intent;
    Result result;
    Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_pager);
        mViewPager = findViewById(R.id.aboutBookPager);
        intent = getIntent();
        result = intent.getParcelableExtra(RESULT_OBJECT);
        book = new Book(result.getTitle(), result.getDescription(), result.getLikes(), result.getDislikes(), result.getView(), result.getImage().getDesktop().getImage());
        mBookPagerAdapter = new BookPagerAdapter(getSupportFragmentManager(), book);
        mViewPager.setAdapter(mBookPagerAdapter);
        mViewPager.setVisibility(View.VISIBLE);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(result.getUrl()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseBody = response.body().string();
                Document doc = Jsoup.parse(responseBody);
                String country = doc.selectFirst("div.book__block-item.country-block > div > a").text();
                String author = doc.selectFirst("div.book__block-name").text();
                String rating = doc.selectFirst("div.rating-text").text();
                String genres = doc.selectFirst("div.book__block-collapse").text();
                String status = doc.select("div.book__description > p").get(1).text();
                ArrayList<Chapter> chapters = new ArrayList<>();
                Elements chaptersTables = doc.select("table.table");
                for(Element e: chaptersTables){
                    Element ahref = e.selectFirst("a[href]");
                    String ch_URL = ahref.attr("href");
                    String ch_title = ahref.text();
                    Chapter chapter = new Chapter(ch_title, ch_URL);
                    chapters.add(chapter);
                }
                book.setCountry(country);
                book.setStatus(status);
                book.setRating(rating);
                book.setGenres(genres);
                book.setAuthor(author);
                book.setChapters(chapters);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mBookPagerAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(new Bundle());
    }
}
