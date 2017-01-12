package com.bwie.demo.daylystudy.utils;

import android.util.Log;

import com.bwie.demo.daylystudy.interfaces.RequestAPI;

import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static android.R.string.ok;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 14：02.
 */

public class HttpUtils {
    //get请求
    public static void getMothed(String baseUri, String uri, final Callback<String> callback) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUri).addConverterFactory(ScalarsConverterFactory.create()).build();
        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        requestAPI.getMothed(uri).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });
    }

    //获取OkhttpClient
    public static OkHttpClient getOkHttClient(boolean isReadCookie, boolean isSaveCookie) {
        OkHttpClient httpClient = null;
        if (isReadCookie && !isSaveCookie) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(new ReadCookiesInterceptor())
                    .build();
        }
        if (isSaveCookie && !isReadCookie) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(new SaveCookiesInterceptor())
                    .build();
        }
        if (isSaveCookie && isReadCookie) {
            httpClient = new OkHttpClient.Builder()
                    .addInterceptor(new SaveCookiesInterceptor()).addInterceptor(new ReadCookiesInterceptor())
                    .build();
        }
        if (!isSaveCookie && !isReadCookie) {
            httpClient = new OkHttpClient.Builder()
                    .build();
        }
        return httpClient;
    }

    //post请求
    public static void postMethed(boolean isReadCookie, boolean isSaveCookie, String baseUri, String uri, Map<String, String> map, final Callback<String> callback) {
        OkHttpClient httpClient = getOkHttClient(isReadCookie, isSaveCookie);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUri).client(httpClient).addConverterFactory(ScalarsConverterFactory.create()).build();
        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        requestAPI.postMothed(uri, map).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.onFailure(call, t);
            }
        });

    }

}
