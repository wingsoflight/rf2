package com.example.hp.recyclerviewgrid.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by HP on 14.03.2018.
 */

public class Book implements Parcelable, Serializable{
    public static final String BOOK_OBJECT = "BOOK_OBJECT";
    private static final long serialVersionUID = 160320180216L;
    private String title, country, description, author, rating, imageURL, genres, status;
    private int likes, dislikes, view_count;
    private ArrayList<Chapter> chapters;

    public Book(String title, String description, int likes, int dislikes, int view_count, String imageURL){
        this.title = title;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.view_count = view_count;
        this.imageURL = imageURL;
    }

    protected Book(Parcel in) {
        title = in.readString();
        country = in.readString();
        description = in.readString();
        author = in.readString();
        rating = in.readString();
        imageURL = in.readString();
        genres = in.readString();
        status = in.readString();
        likes = in.readInt();
        dislikes = in.readInt();
        view_count = in.readInt();
        chapters = in.createTypedArrayList(Chapter.CREATOR);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public ArrayList<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(ArrayList<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(country);
        parcel.writeString(description);
        parcel.writeString(author);
        parcel.writeString(rating);
        parcel.writeString(imageURL);
        parcel.writeString(genres);
        parcel.writeString(status);
        parcel.writeInt(likes);
        parcel.writeInt(dislikes);
        parcel.writeInt(view_count);
        parcel.writeTypedList(chapters);
    }
}
