package com.example.administrator.week01_day05;

import com.example.administrator.week01_day05.Clazz.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetroInterface {
    @GET
    Observable<Bean> getData(@Url String path);
}
