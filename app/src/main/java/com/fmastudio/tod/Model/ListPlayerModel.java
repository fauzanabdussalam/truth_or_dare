package com.fmastudio.tod.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ListPlayerModel implements Parcelable {

    private String nama;

    public ListPlayerModel(String nama) { this.nama = nama; }

    public String getNama() {
        return nama;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
    }

    public void readFromParcel(Parcel source) {
        this.nama = source.readString();
    }

    protected ListPlayerModel(Parcel in) {
        this.nama = in.readString();
    }

    public static final Parcelable.Creator<ListPlayerModel> CREATOR = new Parcelable.Creator<ListPlayerModel>() {
        @Override
        public ListPlayerModel createFromParcel(Parcel source) {
            return new ListPlayerModel(source);
        }

        @Override
        public ListPlayerModel[] newArray(int size) {
            return new ListPlayerModel[size];
        }
    };
}
