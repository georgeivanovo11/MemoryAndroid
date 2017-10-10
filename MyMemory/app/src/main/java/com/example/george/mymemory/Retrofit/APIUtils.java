package com.example.george.mymemory.Retrofit;

import com.example.george.mymemory.Services.PosService;

public class APIUtils
{
    private APIUtils(){};

    private static final String API_URL = "http://10.0.2.2:10000/";

    public static PosService getPosService()
    {
        return RetrofitClient.getClient(API_URL).create(PosService.class);
    }
}
