package com.ahaguru.teacherahaguru.data.Repository;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ahaguru.teacherahaguru.data.Dao.TeacherDao;
import com.ahaguru.teacherahaguru.data.Model.RegisterProfileInput;
import com.ahaguru.teacherahaguru.data.Entity.Teachers;
import com.ahaguru.teacherahaguru.data.Model.RegisterProfileOutput;
import com.ahaguru.teacherahaguru.data.Model.TeacherRegistrationSubject;
import com.ahaguru.teacherahaguru.data.Room.TeacherRoomDatabase;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.ApiStatusResponse;
import com.ahaguru.teacherahaguru.data.SubjectsApi.ErrorHandling.Resource;
import com.ahaguru.teacherahaguru.data.SubjectsApi.Retrofit.RegisterProfileClient;
import com.ahaguru.teacherahaguru.data.SubjectsApi.Retrofit.SubjectsApiClient;
import com.ahaguru.teacherahaguru.utils.ConstantData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeachersRepository {

    public String apikey="goLj8jNbuSbNDt3IRwbLGyModq3yUWPKob5zzao7";
    private TeacherDao teacherDao;
    private Teachers teacher;
    private TeacherRoomDatabase teacherRoomDatabase;
    private List<Teachers> getAllSubjects;
    private Context context;


    public TeachersRepository(Application application) {

        TeacherRoomDatabase teacherRoomDatabase = TeacherRoomDatabase.getInstance(application);
        teacherDao = teacherRoomDatabase.teacherDao();
    }

    public void insert(Teachers teachers) {

        insertLists(teachers);

    }


    public void update(Teachers teachers) {

        updateLists(teachers);
    }

    public void delete(Teachers teachers) {

        deleteLists(teachers);

    }


    public LiveData<List<Teachers>> getAllPendingTeachers() {
        return teacherDao.getAllPendingTeachers(ConstantData.REQUESTED);
    }

    public LiveData<List<Teachers>> getAllApprovedTeachers() {
        return teacherDao.getAllApprovedTeachers(ConstantData.APPROVED);
    }

    public void insertLists(final Teachers teachers) {

        teacherRoomDatabase.executorService.execute(new Runnable() {
            @Override
            public void run() {

                teacherRoomDatabase.teacherDao().insert(teachers);
            }
        });
    }

    public void updateLists(final Teachers teachers) {

        teacherRoomDatabase.executorService.execute(new Runnable() {
            @Override
            public void run() {

                teacherRoomDatabase.teacherDao().update(teachers);
            }
        });
    }

    public void deleteLists(final Teachers teachers) {

        teacherRoomDatabase.executorService.execute(new Runnable() {
            @Override
            public void run() {

                teacherRoomDatabase.teacherDao().delete(teachers);
            }
        });
    }

    public LiveData<Resource<ApiStatusResponse>> subjectsRequest(TeacherRegistrationSubject teacherRegistrationSubject) {

        MutableLiveData<Resource<ApiStatusResponse>> apiStatusResponse = new MutableLiveData<>();

        Call<TeacherRegistrationSubject> call =  SubjectsApiClient.getInstance().subjectsApiInterface().getSubjectsList(apikey);
        call.enqueue(new Callback<TeacherRegistrationSubject>() {

            @Override
            public void onResponse(Call<TeacherRegistrationSubject> call, Response<TeacherRegistrationSubject> response) {

//                if (response.body() == null) {
//                    apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(response.code(), response.message())));
//                }
//
//                TeacherRegistrationSubject teacherRegistrationSub = response.body();
//
//                if (teacherRegistrationSub.getStatus() == ConstantData.STATUS_CODE_SUCESS) {
//
//                    apiStatusResponse.postValue(Resource.success(new ApiStatusResponse(teacherRegistrationSubject.getStatus(), teacherRegistrationSubject.getMessage())));
//
//                }
//
//                else if (teacherRegistrationSub.getStatus() == ConstantData.STATUS_CODE_TOKEN_MISMATCH) {
//
//
//
//                    apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(teacherRegistrationSub.getStatus(), teacherRegistrationSub.getMessage())));
//
//                }
//
//                else {
//
//                    apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(teacherRegistrationSub.getStatus(), teacherRegistrationSub.getMessage())));
//                }

            }

            @Override
            public void onFailure(Call<TeacherRegistrationSubject> call, Throwable t) {

//                apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(-1, t.getMessage())));
            }
        });

        return apiStatusResponse;

    }

    public LiveData<Resource<ApiStatusResponse>> registerTeacherProfile(RegisterProfileInput registerProfileInput) {

        MutableLiveData<Resource<ApiStatusResponse>> apiStatusResponse = new MutableLiveData<>();

        // check network

//        isInternetAvailable(context);


        Call<RegisterProfileOutput> call =  RegisterProfileClient.getInstance().inputService().getInputList();
        call.enqueue(new Callback<RegisterProfileOutput>() {


            @Override
            public void onResponse(Call<RegisterProfileOutput> call, Response<RegisterProfileOutput> response) {

//                if (response.body() == null) {
//                    apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(response.code(), response.message())));
//                }
//
//                RegisterProfileOutput registerProfileOutput = response.body();
//
//                if (registerProfileOutput.getStatus() == ConstantData.STATUS_CODE_SUCESS) {
//
//                    // add to db
//
//                    teacherRoomDatabase.teacherDao().insert(teacher);
//
//                    apiStatusResponse.postValue(Resource.success(new ApiStatusResponse(registerProfileOutput.getStatus(), registerProfileOutput.getMessage())));
//
//                }
//
//                else if (registerProfileOutput.getStatus() == ConstantData.STATUS_CODE_TOKEN_MISMATCH) {
//
//                    // clear table
//
//                    teacherRoomDatabase.clearAllTables();
//
//                    apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(registerProfileOutput.getStatus(), registerProfileOutput.getMessage())));
//
//                }
//
//                else {
//
//                    apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(registerProfileOutput.getStatus(), registerProfileOutput.getMessage())));
//                }
            }

            @Override
            public void onFailure(Call<RegisterProfileOutput> call, Throwable t) {

//                apiStatusResponse.postValue(Resource.error("", new ApiStatusResponse(-1, t.getMessage())));

            }
        });

        return apiStatusResponse;
    }

    public static boolean isInternetAvailable(Context context) {
        return isWiFiAvailable(context) || isMobileDateAvailable(context);
    }


    public static boolean isWiFiAvailable(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network_info = connectivityManager.getActiveNetworkInfo();

        return network_info != null
                && network_info.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public static boolean isMobileDateAvailable(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null
                && networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
    }

}