package com.example.hp.recyclerviewgrid.Entities;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mobile implements Serializable, Parcelable
{

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("svg")
    @Expose
    private String svg;
    public final static Parcelable.Creator<Mobile> CREATOR = new Creator<Mobile>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Mobile createFromParcel(Parcel in) {
            return new Mobile(in);
        }

        public Mobile[] newArray(int size) {
            return (new Mobile[size]);
        }

    }
            ;
    private final static long serialVersionUID = -8770092489321719777L;

    protected Mobile(Parcel in) {
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.svg = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Mobile() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(image);
        dest.writeValue(svg);
    }

    public int describeContents() {
        return 0;
    }

}