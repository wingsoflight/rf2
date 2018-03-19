package com.example.hp.recyclerviewgrid.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.recyclerviewgrid.Activities.BookReaderActivity;
import com.example.hp.recyclerviewgrid.Entities.Chapter;
import com.example.hp.recyclerviewgrid.R;

import java.util.ArrayList;

/**
 * Created by HP on 16.03.2018.
 */

public class BookChaptersRecyclerViewAdapter extends RecyclerView.Adapter<BookChaptersRecyclerViewAdapter.MyViewHolder> {
    ArrayList<Chapter> chapters;
    Context context;
    public BookChaptersRecyclerViewAdapter(ArrayList<Chapter> chapters, Context context){
        this.chapters = chapters;
        this.context = context;
    }

    @Override
    public BookChaptersRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_chapter_item, parent, false);
        final MyViewHolder vh = new MyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chapter chapter = chapters.get(vh.getAdapterPosition());
                Intent intent = new Intent(context, BookReaderActivity.class);
                intent.putExtra(Chapter.CHAPTER_OBJECT, (Parcelable) chapter);
                context.startActivity(intent);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(BookChaptersRecyclerViewAdapter.MyViewHolder holder, int position) {
        int size = chapters.size();
        holder.bookChapterTitleTextView.setText(""+chapters.get(position).getTitle());
        holder.bookChapterNumberTextView.setText(""+(size - position));
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookChapterNumberTextView;
        TextView bookChapterTitleTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            bookChapterNumberTextView = itemView.findViewById(R.id.bookChapterNumberTextView);
            bookChapterTitleTextView = itemView.findViewById(R.id.bookChapterTitleTextVew);
        }
    }


}
