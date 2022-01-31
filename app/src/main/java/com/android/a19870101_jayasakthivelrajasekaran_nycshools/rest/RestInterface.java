package com.android.a19870101_jayasakthivelrajasekaran_nycshools.rest;

import com.android.a19870101_jayasakthivelrajasekaran_nycshools.model.HighSchoolsJson;
import com.android.a19870101_jayasakthivelrajasekaran_nycshools.model.SatScoreJson;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface RestInterface {


    @GET("resource/s3k6-pzi2.json")
    Call<List<HighSchoolsJson>> getAllHighSchools();

    @GET("resource/f9bf-2cp4.json")
    Call<List<SatScoreJson>> getSatScore(@Query("dbn") String id);
}
