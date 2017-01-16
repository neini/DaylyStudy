package com.bwie.demo.daylystudy.base;

import android.util.Log;

import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.HttpUtils;
import com.bwie.demo.daylystudy.utils.Md5;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.key;
import static android.R.attr.keySet;
import static android.R.attr.path;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 14：02.
 */

public abstract class BaseData {

    public static int NORMALTIME = 3 * 24 * 60 * 60 * 1000;
    public static int NOTIME = 0;
    private final File fileDir;

    public abstract void onSucesss(String data);

    public abstract void onError(Throwable t);

    public BaseData() {
        //找到存储路径
        File file = MyApplication.getContext().getCacheDir();
        //创建存储文件家
        fileDir = new File(file, "mrx");
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
    }

    //get获取网络数据
    public void getMothedNet(final String baseUri, final String uri, final int time) {
        HttpUtils.getMothed(baseUri, uri, new Callback<String>() {
            @Override
            public void onResponse(Call call, Response response) {
                String s = (String) response.body();
                onSucesss(s);
                wtitrToLocal(baseUri, uri, time, s);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                onError(t);
            }
        });
    }

    //读取本地信息
    public String getDataFromLocal(String baseUri, String uri, int time) {
        try {
            File file = new File(fileDir, Md5.Md5(baseUri + uri));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String s = bufferedReader.readLine();
            long oldtime = Long.parseLong(s);
            if (System.currentTimeMillis() < oldtime) {
                StringBuilder builder = new StringBuilder();
                String len;
                while ((len = bufferedReader.readLine()) != null) {
                    builder.append(len);
                }
                return builder.toString();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    //写入本地
    public void wtitrToLocal(String baseUri, String uri, int time, String s) {
        try {
            File file = new File(fileDir, Md5.Md5(baseUri + uri));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(System.currentTimeMillis() + time + "\r\n");
            bufferedWriter.write(s);
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //get获取数据
    public void getData(String baseUri, String uri, int time) {
        if (time == 0) {
            getMothedNet(baseUri, uri, time);
        } else {
            String data = getDataFromLocal(baseUri, uri, time);
            if (data == null) {
                getMothedNet(baseUri, uri, time);
            } else {
                onSucesss(data);
            }

        }
    }

    //post获取网络数据
    public void postMoetedNet(boolean isReadCookie, boolean isSaveCookie, final String baseUri, final String uri, final int time, final Map<String, String> map) {
        HttpUtils.postMethed(isReadCookie, isSaveCookie, baseUri, uri, map, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String s = response.body();
                StringBuffer sb = new StringBuffer(uri);
                Set<String> keyset = map.keySet();
                for (String str : keyset) {
                    sb.append(map.get(str));
                }
                wtitrToLocal(baseUri, sb.toString(), time, s);
                onSucesss(s);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                onError(t);
            }
        });
    }

    //post获取数据
    public void postData(boolean isReadCookie, boolean isSaveCookie, String baseUri, String uri, int time, Map<String, String> map) {
        if (map != null) {
            if (time == 0) {
                postMoetedNet(isReadCookie, isSaveCookie, baseUri, uri, time, map);
            } else {
                String data = getDataFromLocal(baseUri, uri, time);
                if (data == null) {
                    postMoetedNet(isReadCookie, isSaveCookie, baseUri, uri, time, map);
                } else {
                    onSucesss(data);
                }
            }
        }
    }
}