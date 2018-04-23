package com.example.hp.recyclerviewgrid.Activities;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.hp.recyclerviewgrid.ApiConnectivity.ApiService;
import com.example.hp.recyclerviewgrid.ApiConnectivity.RetrofitClient;
import com.example.hp.recyclerviewgrid.Entities.Chapter;
import com.example.hp.recyclerviewgrid.R;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.os.Build.VERSION_CODES.N;


public class BookReaderActivity extends AppCompatActivity {
    Chapter chapter;
    TextView chapterContentTextView;
    TextView chapterTitleTextView;
    private final static String TAG = "BOOK_READER_ACTIVITY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_reader_layout);
        chapter = getIntent().getParcelableExtra(Chapter.CHAPTER_OBJECT);
        chapterContentTextView = findViewById(R.id.chapterContentTextView);
        chapterTitleTextView = findViewById(R.id.chapterTitleTextView);
        Uri uri = Uri.parse(chapter.getURL());
        List<String> path = uri.getPathSegments();

        ApiService apiService = RetrofitClient.getApiService();
        Call<JsonObject> objectCall = apiService.getChapterData(path.get(0), path.get(1));

        objectCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                JsonObject partObject = jsonObject.getAsJsonObject("result").getAsJsonObject("part");
                String content = partObject.get("content").getAsString();
                String title = partObject.get("title").getAsString();
                content = "<html><head></head><body style=\"text-align:justify;\">"
                        + content + "</body></html>";
                chapterTitleTextView.setText(title);
                chapterContentTextView.setText(Html.fromHtml(content));
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                t.printStackTrace();
            }
        });


//        String url = "https://ранобэ.рф/v1/part/load/?bookAlias=" + path.get(0) + "&partAlias=" + path.get(1);
//        OkHttpClient okHttpClient = new OkHttpClient();
//        Request request = new Request.Builder().url(url).build();
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String responseBody = response.body().string();
//                try {
//                    JSONObject jsonObject = new JSONObject(responseBody).getJSONObject("result").getJSONObject("part");
//                    String content = jsonObject.getString("content");
//                    String title = jsonObject.getString("title");
//                    chapter.setContent(content);
//                    chapter.setTitle(title);
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            String content = "<html><head></head><body style=\"text-align:justify;\">"
//                                    + chapter.getContent() + "</body></html>";
//                            chapterContentWebView.loadData(content, "text/html; charset=utf-8", "utf-8");
//                            chapterTitleTextView.setText(chapter.getTitle());
//                        }
//                    });
//                }
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
