package com.bwie.demo.daylystudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.google.gson.Gson;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by ${薛亚南}
 * on 2017/1/10 21：37.
 */

public abstract class BaseShowInPagerActivity extends AutoLayoutActivity {

    public ShowingPage showingPage;
    public Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
        showingPage = new ShowingPage(this) {
            @Override
            protected View createSuccessView() {
                return BaseShowInPagerActivity.this.creatSuccessView();
            }

            @Override
            protected void setTitleView(View view) {
                BaseShowInPagerActivity.this.creatTitleView(view);
            }


            @Override
            protected void onLoad() {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        BaseShowInPagerActivity.this.onLoad();
                    }
                }.start();
            }
        };
        if (showingPage != null) {
            showingPage.setOnShowinPageListener(new OnShowinPageListener() {
                @Override
                public void isShowPager(View view) {
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            BaseShowInPagerActivity.this.onLoad();
                        }
                    }.start();
                }
            });
            setContentView(showingPage);
        }
    }

    public abstract void onLoad();

    public abstract View creatSuccessView();

    public abstract void creatTitleView(View  view);


}
