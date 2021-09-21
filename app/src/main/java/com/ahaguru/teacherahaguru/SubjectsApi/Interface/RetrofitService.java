package com.ahaguru.teacherahaguru.SubjectsApi.Interface;

import com.ahaguru.teacherahaguru.SubjectsApi.Model.Subjects;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("")
    Call<Subjects> getSubjectsList();

}
