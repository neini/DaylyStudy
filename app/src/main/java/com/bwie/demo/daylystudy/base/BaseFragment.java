package com.bwie.demo.daylystudy.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;

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
            protected void setTitleView(View view) {
                Toolbar toolbar = (Toolbar) view.findViewById(R.id.title_toolbar);
                toolbar.inflateMenu(R.menu.toolbar_menu);
                toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.img_serch:
                                ToastUtil.show(getActivity(), "search Friendly");
                                break;
                        }
                        return true;
                    }
                });
                BaseFragment.this.setTitleView(view);
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

    public abstract void setTitleView(View view);

    public void showCurrentView(ShowingPage.StateType stateType) {
        if (showingPage != null)
            showingPage.showCurrentPage(stateType);
    }
}
