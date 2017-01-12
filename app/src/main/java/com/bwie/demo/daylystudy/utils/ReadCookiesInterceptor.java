package com.bwie.demo.daylystudy.utils;

import android.util.Log;

import com.bwie.demo.daylystudy.application.MyApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;


/**
 * Created by zhiyuan on 17/1/11.
 */

public class ReadCookiesInterceptor implements Interceptor {

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String cookie = SharedPreferencesUtils.getString(MyApplication.getContext(), "cookie", "");

        builder.addHeader("Cookie", cookie);
        Log.i("BBB",cookie);
        return chain.proceed(builder.build());
    }
}
