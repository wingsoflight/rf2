package com.example.hp.recyclerviewgrid.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.recyclerviewgrid.Activities.BookDetailsActivity;
import com.example.hp.recyclerviewgrid.Entities.Result;
import com.example.hp.recyclerviewgrid.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HP on 08.03.2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    private ArrayList<Result> resultArrayList;
    private Context context;


    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleTextView, ratingTextView;
        MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.itemImageVIew);
            titleTextView = view.findViewById(R.id.itemTextViewTitle);
            ratingTextView = view.findViewById(R.id.itemTextViewRating);
        }

    }

    public Adapter(ArrayList<Result> _results, Context _context){
        resultArrayList = _results;
        context = _context;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        final MyViewHolder vh = new MyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result result = resultArrayList.get(vh.getAdapterPosition());
                Intent intent = new Intent(context, BookDetailsActivity.class);
                intent.putExtra(BookDetailsActivity.RESULT_OBJECT, (Parcelable) result);
                context.startActivity(intent);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Result result = resultArrayList.get(position);
        holder.titleTextView.setText(result.getTitle());
        String s = String.valueOf(result.getLikes()) + " +/- " + String.valueOf(result.getDislikes());
        holder.ratingTextView.setText(s);
        Picasso.with(context).load(result.getImage().getMobile().getImage()).placeholder(R.drawable.book_image_placeholder_horizontal).error(R.drawable.book_image_placeholder_horizontal).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }
}
