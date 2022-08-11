package com.fmastudio.tod.Model;

import com.google.gson.annotations.SerializedName;

public class ListPlayerModel {

    private String nama;

    public ListPlayerModel(String nama) { this.nama = nama; }

    public String getNama() {
        return nama;
    }
}
