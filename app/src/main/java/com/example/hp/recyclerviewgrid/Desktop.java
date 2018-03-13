package com.example.hp.recyclerviewgrid;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Desktop implements Serializable, Parcelable
{

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("svg")
    @Expose
    private String svg;
    public final static Parcelable.Creator<Desktop> CREATOR = new Creator<Desktop>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Desktop createFromParcel(Parcel in) {
            return new Desktop(in);
        }

        public Desktop[] newArray(int size) {
            return (new Desktop[size]);
        }

    }
            ;
    private final static long serialVersionUID = 8525088108679816274L;

    protected Desktop(Parcel in) {
        this.image = ((String) in.readValue((String.class.getClassLoader())));
        this.svg = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Desktop() {
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