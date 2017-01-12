package com.bwie.demo.daylystudy.interfaces;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 14：21.
 */

public interface RequestAPI {
    @GET
    Call<String> getMothed(@Url String uri);
    @FormUrlEncoded
    @POST
    Call<String> postMothed(@Url String uri, @FieldMap Map<String,String> map);
}
