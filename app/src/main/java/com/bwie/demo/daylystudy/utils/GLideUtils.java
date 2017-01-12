package com.bwie.demo.daylystudy.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.application.MyApplication;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 19：10.
 */

public class GLideUtils {
    //加载正常的图片
    public static void loagNormalImg(String url, ImageView imageView) {
        Glide.with(MyApplication.getContext()).load(url).error(R.mipmap.default_two).into(imageView);
    }

    //加载圆形的图片
    public static void loadCrileImg(String url, ImageView imageView) {
        Glide.with(MyApplication.getContext()).load(url).bitmapTransform(new CropCircleTransformation(MyApplication.getContext())).crossFade(1000).into(imageView);
    }
}
