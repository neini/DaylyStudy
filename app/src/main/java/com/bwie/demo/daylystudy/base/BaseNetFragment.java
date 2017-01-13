package com.bwie.demo.daylystudy.base;

import android.content.Context;
import android.view.View;

import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by ${薛亚南}
 * on 2017/1/13 14：33.
 */

public abstract class BaseNetFragment extends BaseFragment {

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
                onload();
            }
        });
        if (isConnet) {
            onload();
        } else {
            showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }

    }

    public abstract void onload();
    @Override
    public View createSuccessView() {
        return null;
    }

    @Override
    public void setTitleView(View view) {
        BaseNetFragment.this.setTitleView1(view);

    }

    public abstract void setTitleView1(View view);

}
