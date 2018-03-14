package com.example.hp.recyclerviewgrid.Entities;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response implements Serializable, Parcelable
{

    @SerializedName("countPages")
    @Expose
    private int countPages;
    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    public final static Parcelable.Creator<Response> CREATOR = new Creator<Response>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Response createFromParcel(Parcel in) {
            return new Response(in);
        }

        public Response[] newArray(int size) {
            return (new Response[size]);
        }

    }
            ;
    private final static long serialVersionUID = 6348852226774895043L;

    protected Response(Parcel in) {
        this.countPages = ((int) in.readValue((int.class.getClassLoader())));
        in.readList(this.result, (Result.class.getClassLoader()));
    }

    public Response() {
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(countPages);
        dest.writeList(result);
    }

    public int describeContents() {
        return 0;
    }

}