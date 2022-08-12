package com.fmastudio.tod.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {

    @SerializedName("status")
    public String status;
    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public String pertanyaan;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return pertanyaan;
    }

    public void setData(String pertanyaan) {
        this.pertanyaan = pertanyaan;
    }
}
