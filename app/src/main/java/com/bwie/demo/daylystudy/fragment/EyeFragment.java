package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.view.View;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.SharedPreferencesUtils;
import com.bwie.demo.daylystudy.utils.ShowingPage;

/**
 * Created by ${薛亚南}
 * on 2017/1/12 19：02.
 */

public class EyeFragment extends BaseFragment {
    private boolean isConnet = true;
    private String cookie;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!CommonUtil.isConnected()) {
            isConnet = false;
        }
    }

    @Override
    public void onLoad() {
        showingPage.setOnShowinPageListener(new OnShowinPageListener() {
            @Override
            public void isShowPager(View view) {
                isConnet = true;
                initData();
            }
        });
        if (isConnet) {
            initData();
        } else {
            showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }

    //判断本地是否有cookie值
    public void initData() {
        cookie = SharedPreferencesUtils.getString(MyApplication.getContext(), "cookie", "");
        if (cookie != null) {
            getDataFromNet();
        } else {
            showCurrentView(ShowingPage.StateType.STATE_UNLOAD);
        }
    }

    //请求网络
    public void getDataFromNet() {
        new BaseData() {
            //请求成功
            @Override
            public void onSucesss(String data) {
                showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }

            //请求失败
            @Override
            public void onError(Throwable t) {
                showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        };
    }

    @Override
    public View createSuccessView() {
        return null;
    }

    @Override
    public void setTitleView(View view) {
        view.setVisibility(View.GONE);
    }


}
