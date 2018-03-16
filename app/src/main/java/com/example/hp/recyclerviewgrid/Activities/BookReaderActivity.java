package com.example.hp.recyclerviewgrid.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.example.hp.recyclerviewgrid.Entities.Chapter;
import com.example.hp.recyclerviewgrid.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class BookReaderActivity extends AppCompatActivity {
    Chapter chapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_reader_layout);
        chapter = getIntent().getParcelableExtra(Chapter.CHAPTER_OBJECT);
        new GetContent().execute();
    }

    class GetContent extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            try{
                Document doc = Jsoup.connect(chapter.getURL()).get();

            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
