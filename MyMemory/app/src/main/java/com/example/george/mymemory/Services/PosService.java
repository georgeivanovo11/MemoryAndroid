package com.example.george.mymemory.Services;

import com.example.george.mymemory.Models.PartOfSpeech;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PosService
{
    @GET("/api/partsofspeech")
    Call<List<PartOfSpeech>> getPos();

//    @POST("/api/partsofspeech/")
//    Call<PartOfSpeech> addPos(@Body PartOfSpeech pos);
//
//    @PUT("/api/partsofspeech/")
//    Call<PartOfSpeech> updatePos(@Body PartOfSpeech pos);
}
