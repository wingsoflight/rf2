package com.example.hp.recyclerviewgrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

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

    Adapter(ArrayList<Result> _results, Context _context){
        resultArrayList = _results;
        context = _context;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        Result result = resultArrayList.get(position);
        holder.titleTextView.setText(result.getTitle());
        String s = String.valueOf(result.getLikes()) + " +/- " + String.valueOf(result.getDislikes());
        holder.ratingTextView.setText(s);
        Picasso.with(context).load(result.getImage().getMobile().getImage()).placeholder(R.drawable.placeholder).error(R.drawable.placeholder).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }
}
