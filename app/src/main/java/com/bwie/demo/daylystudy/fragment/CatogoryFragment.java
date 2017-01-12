package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;

import static android.R.attr.x;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class CatogoryFragment extends BaseFragment {
    private String data;
    private TextView textView;

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
            showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }

    public void initData() {
        MyBaseDate myBaseDate = new MyBaseDate();
        myBaseDate.getData("http://www.baidu.com", "http://www.baidu.com", 0);
    }

    @Override
    public View createSuccessView() {

        textView = new TextView(getActivity());
        textView.setText("niini");
        return textView;
    }


    public class MyBaseDate extends BaseData {

        @Override
        public void onSucesss(String data) {
            CatogoryFragment.this.data = data;
            CatogoryFragment.this.showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            ToastUtil.show(getActivity(), data);
        }

        @Override
        public void onError(Throwable t) {
            ToastUtil.show(getActivity(), "ddddddddd");
        }
    }
}
