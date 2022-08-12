package com.fmastudio.tod.Model;

import com.google.gson.annotations.SerializedName;

public class QuestionModel {

    @SerializedName("pertanyaan")
    public String pertanyaan;

    public String getPertanyaan() {
        return pertanyaan;
    }
}
