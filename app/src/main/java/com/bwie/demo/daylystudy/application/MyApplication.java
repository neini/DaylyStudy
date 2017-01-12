package com.bwie.demo.daylystudy.application;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import static android.R.attr.x;

/**
 * Created by ${薛亚南}
 * on 2017/1/10 22：51.
 */

public class MyApplication extends Application {
    private  static Context context;
    private static Handler handler;
    private  static int mainThreadId;
    @Override
    public void onCreate() {
        super.onCreate();
        //设置获取上下文
        context = getApplicationContext();
        //设置获取handler
        handler = new Handler();
        //设置获取主线程的线程号
        mainThreadId = Process.myTid();

    }
    public static Context getContext(){
        return  context;
    }

    public  static Handler getHandler(){
        return  handler;
    }

    public static int getMainThreadId(){
        return  mainThreadId;
    }
    public static Thread getMainThread(){
        return  Thread.currentThread();
    }
}
