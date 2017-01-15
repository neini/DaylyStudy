package com.bwie.demo.daylystudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.demo.daylystudy.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
       banner = (Banner) findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        ArrayList<Integer> imgUrlList = new ArrayList<>();
        imgUrlList.add(R.mipmap.bga_refresh_loading01);
        imgUrlList.add(R.mipmap.bga_refresh_loading02);
        imgUrlList.add(R.mipmap.bga_refresh_loading03);
        imgUrlList.add(R.mipmap.bga_refresh_loading04);
        banner.setImages(imgUrlList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        //设置banner动画效果
     //   banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
    //    banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

    }
    //如果你需要考虑更好的体验，可以这么操作
    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }


}
