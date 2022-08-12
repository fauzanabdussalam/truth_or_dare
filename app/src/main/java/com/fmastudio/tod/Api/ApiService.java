package com.fmastudio.tod.Api;

import com.fmastudio.tod.Model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("tod")
    Call<ResponseModel> getQuestion(@Query("jenis") String jenis);
}
