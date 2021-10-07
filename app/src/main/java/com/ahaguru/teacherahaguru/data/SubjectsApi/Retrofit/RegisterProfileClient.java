package com.ahaguru.teacherahaguru.data.SubjectsApi.Retrofit;

import com.ahaguru.teacherahaguru.data.SubjectsApi.Interface.RegisterProfileInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterProfileClient {

    private static RegisterProfileClient inputClient;
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nasa.gov/planetary/";

    public RegisterProfileClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static RegisterProfileClient getInstance(){
        if(inputClient == null){
            inputClient = new RegisterProfileClient();
        }
        return inputClient;
    }

    public RegisterProfileInterface inputService(){
        return retrofit.create(RegisterProfileInterface.class);
    }

}
