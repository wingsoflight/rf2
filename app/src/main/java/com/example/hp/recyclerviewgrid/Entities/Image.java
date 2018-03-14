package com.example.hp.recyclerviewgrid.Entities;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Serializable, Parcelable
{

    @SerializedName("desktop")
    @Expose
    private Desktop desktop;
    @SerializedName("mobile")
    @Expose
    private Mobile mobile;
    public final static Parcelable.Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    }
            ;
    private final static long serialVersionUID = -7226937191464551845L;

    protected Image(Parcel in) {
        this.desktop = ((Desktop) in.readValue((Desktop.class.getClassLoader())));
        this.mobile = ((Mobile) in.readValue((Mobile.class.getClassLoader())));
    }

    public Image() {
    }

    public Desktop getDesktop() {
        return desktop;
    }

    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(desktop);
        dest.writeValue(mobile);
    }

    public int describeContents() {
        return 0;
    }

}