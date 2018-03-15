package com.example.hp.recyclerviewgrid.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by HP on 14.03.2018.
 */

public class Book implements Parcelable {
    public static final String BOOK_OBJECT = "BOOK_OBJECT";
    String title, country, chapterTittles[], titleURLs[], description;

    protected Book(Parcel in) {
        title = in.readString();
        country = in.readString();
        chapterTittles = in.createStringArray();
        titleURLs = in.createStringArray();
        description = in.readString();
        imageURL = in.readString();
        rating = in.readDouble();
        likes = in.readInt();
        dislikes = in.readInt();
        view_count = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    String imageURL;
    double rating;
    int likes, dislikes, view_count;
    public Book(String title, String description, int likes, int dislikes, int view_count, String imageURL){
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.view_count = view_count;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getChapterTittles() {
        return chapterTittles;
    }

    public void setChapterTittles(String[] chapterTittles) {
        this.chapterTittles = chapterTittles;
    }

    public String[] getTitleURLs() {
        return titleURLs;
    }

    public void setTitleURLs(String[] titleURLs) {
        this.titleURLs = titleURLs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(country);
        parcel.writeStringArray(chapterTittles);
        parcel.writeStringArray(titleURLs);
        parcel.writeString(description);
        parcel.writeString(imageURL);
        parcel.writeDouble(rating);
        parcel.writeInt(likes);
        parcel.writeInt(dislikes);
        parcel.writeInt(view_count);
    }
}
