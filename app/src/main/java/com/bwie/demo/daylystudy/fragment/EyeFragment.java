package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.view.View;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;

/**
 * Created by ${薛亚南}
 * on 2017/1/12 19：02.
 */

public class EyeFragment extends BaseFragment {
    private boolean isConnet = true;

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
            showCurrentView(ShowingPage.StateType.STATE_UNLOAD);
        }
    }


    public void initData() {

    }

    ;

    @Override
    public View createSuccessView() {
        return null;
    }

    @Override
    public void setTitleView(View view) {
        view.setVisibility(View.GONE);
    }


}
