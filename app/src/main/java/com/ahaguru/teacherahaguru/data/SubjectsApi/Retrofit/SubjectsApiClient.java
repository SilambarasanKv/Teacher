package com.ahaguru.teacherahaguru.data.SubjectsApi.Retrofit;

import com.ahaguru.teacherahaguru.data.SubjectsApi.Interface.SubjectsApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubjectsApiClient {

    private static SubjectsApiClient subjectsApiClient;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nasa.gov/planetary/";

    public SubjectsApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static SubjectsApiClient getInstance(){
        if(subjectsApiClient == null){
            subjectsApiClient = new SubjectsApiClient();
        }
        return subjectsApiClient;
    }

    public SubjectsApiInterface subjectsApiInterface(){
        return retrofit.create(SubjectsApiInterface.class);
    }
}
