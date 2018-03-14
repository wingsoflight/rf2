package com.example.hp.recyclerviewgrid.Entities;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Serializable, Parcelable
{

    @SerializedName("like")
    @Expose
    private int like;
    @SerializedName("dislike")
    @Expose
    private int dislike;
    public final static Parcelable.Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
                "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
            ;
    private final static long serialVersionUID = -6960127463675029481L;

    protected User(Parcel in) {
        this.like = ((int) in.readValue((int.class.getClassLoader())));
        this.dislike = ((int) in.readValue((int.class.getClassLoader())));
    }

    public User() {
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(like);
        dest.writeValue(dislike);
    }

    public int describeContents() {
        return 0;
    }

}