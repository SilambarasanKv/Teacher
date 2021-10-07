package com.ahaguru.teacherahaguru.data.SubjectsApi.Interface;


import com.ahaguru.teacherahaguru.data.Model.RegisterProfileOutput;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RegisterProfileInterface {

    @GET("apod")
    Call<RegisterProfileOutput> getInputList();

}
