package com.example.george.mymemory.Services;

import com.example.george.mymemory.Models.EngWord;
        import com.example.george.mymemory.Models.PartOfSpeech;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.http.Body;
        import retrofit2.http.GET;
        import retrofit2.http.POST;
        import retrofit2.http.PUT;

public interface EngWordService
{
    @GET("/api/engwords")
    Call<List<EngWord>> getEngWords();
}