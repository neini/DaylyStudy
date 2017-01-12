package com.bwie.demo.daylystudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：52.
 */

public abstract class BaseFragment extends Fragment {

    public ShowingPage showingPage;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        showingPage = new ShowingPage(getContext()) {
            @Override
            public View createSuccessView() {

                return BaseFragment.this.createSuccessView();
            }

            @Override
            public void onLoad() {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        BaseFragment.this.onLoad();
                    }
                }.start();

            }
        };

        return showingPage;
    }

    public abstract void onLoad();

    public abstract View createSuccessView();


    public void showCurrentView(ShowingPage.StateType stateType) {
        if (showingPage != null)
            showingPage.showCurrentPage(stateType);
    }
}
