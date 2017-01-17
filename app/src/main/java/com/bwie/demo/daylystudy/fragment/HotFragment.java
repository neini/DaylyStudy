package com.bwie.demo.daylystudy.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.bean.HotTitleBean;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.google.gson.Gson;

import java.util.List;

/**
 * Created by ${薛亚南}
 * on 2017/1/12 19：02.
 */

public class HotFragment extends BaseNetFragment {

    private View hotView;
    private MyBaseData myBaseData;
    private Gson gson;
    private List<HotTitleBean.DataBean> titleDataList;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            setTabAndViewPager();
        }
    };
    private TabLayout hot_tablayout;
    private ViewPager hot_viewPager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
        myBaseData = new MyBaseData();
    }

    @Override
    public void onload() {
        myBaseData.getData(Constants.HOTTITLE, Constants.HOTTTITLEARGS, BaseData.NORMALTIME);
    }

    @Override
    public View createSuccessView() {
        hotView = LayoutInflater.from(getActivity()).inflate(R.layout.hot_fragment, null);
        iniView();
        return hotView;
    }

    //设置tablayout标题以及关联viewPager
    public void setTabAndViewPager() {
        if (titleDataList != null)
            hot_tablayout.addTab(hot_tablayout.newTab().setText(titleDataList.get(0).getName()), true);
        for (int i = 1; i < titleDataList.size(); i++) {
            hot_tablayout.addTab(hot_tablayout.newTab().setText(titleDataList.get(i).getName()), false);
        }
        hot_viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                HotChildFragment hotChildFragment = new HotChildFragment();
                Bundle bundle = new Bundle();
                bundle.putString("tid", titleDataList.get(position).getTid());
                hotChildFragment.setArguments(bundle);
                return hotChildFragment;
            }

            @Override
            public int getCount() {
                return titleDataList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleDataList.get(position).getName();

            }
        });
        hot_tablayout.setupWithViewPager(hot_viewPager);
    }

    //找控件
    public void iniView() {
        hot_tablayout = (TabLayout) hotView.findViewById(R.id.hot_tablayout);
        hot_viewPager = (ViewPager) hotView.findViewById(R.id.hot_viewpager);
    }

    //设置标题栏
    @Override
    public void setTitleView1(View view) {
        view.setVisibility(View.GONE);
    }

    class MyBaseData extends BaseData {

        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                if (data != null) {
                    HotTitleBean hotTitleBean = gson.fromJson(data, HotTitleBean.class);
                    titleDataList = hotTitleBean.getData();
                    handler.sendEmptyMessage(0);
                }
            }
        }

        @Override
        public void onError(Throwable t) {
            showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }

}
