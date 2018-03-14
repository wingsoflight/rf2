package com.example.hp.recyclerviewgrid.Entities;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("view")
    @Expose
    private int view;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("likes")
    @Expose
    private int likes;
    @SerializedName("dislikes")
    @Expose
    private int dislikes;
    @SerializedName("user")
    @Expose
    private User user;
    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        public Result[] newArray(int size) {
            return (new Result[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5503109302306127486L;

    protected Result(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.image = ((Image) in.readValue((Image.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.view = ((int) in.readValue((int.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.likes = ((int) in.readValue((int.class.getClassLoader())));
        this.dislikes = ((int) in.readValue((int.class.getClassLoader())));
        this.user = ((User) in.readValue((User.class.getClassLoader())));
    }

    public Result() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(url);
        dest.writeValue(title);
        dest.writeValue(image);
        dest.writeValue(description);
        dest.writeValue(view);
        dest.writeValue(status);
        dest.writeValue(likes);
        dest.writeValue(dislikes);
        dest.writeValue(user);
    }

    public int describeContents() {
        return 0;
    }

}