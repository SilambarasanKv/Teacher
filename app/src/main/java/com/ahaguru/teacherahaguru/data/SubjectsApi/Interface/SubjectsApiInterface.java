package com.ahaguru.teacherahaguru.data.SubjectsApi.Interface;

import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.data.Model.TeacherRegistrationSubject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SubjectsApiInterface {

    @GET("apod")
    Call<TeacherRegistrationSubject> getSubjectsList(@Query("api_key") String apiKey);

}
