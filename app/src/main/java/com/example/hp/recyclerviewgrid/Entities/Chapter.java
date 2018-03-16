package com.example.hp.recyclerviewgrid.Entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Chapter implements Serializable, Parcelable{
    public static final String CHAPTER_OBJECT = "CHAPTER_OBJECT";
    private static final long serialVersionUID = 160320180213L;
    String title, URL, content;
    protected Chapter(Parcel in) {
        title = in.readString();
        URL = in.readString();
        content = in.readString();
    }

    public Chapter(String title, String URL){
        this.title = title;
        this.URL = URL;
    }

    public static final Creator<Chapter> CREATOR = new Creator<Chapter>() {
        @Override
        public Chapter createFromParcel(Parcel in) {
            return new Chapter(in);
        }

        @Override
        public Chapter[] newArray(int size) {
            return new Chapter[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(URL);
        parcel.writeString(content);
    }
}
