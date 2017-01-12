package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;

import static android.R.attr.id;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class CrileFragment extends BaseFragment {
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

    //请求数据的方法
    public void initData() {
        showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    public View createSuccessView() {

        TextView textView = new TextView(getActivity());
        textView.setText("圈子");
        return textView;
    }

}
