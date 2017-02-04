package com.bwie.demo.daylystudy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.adapter.TopicHotRecyclerView;
import com.bwie.demo.daylystudy.app.LogingActivity;
import com.bwie.demo.daylystudy.app.TopicInfoActivtity;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.bean.TopicRootBean;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.MyGlideImagLoaer;
import com.bwie.demo.daylystudy.utils.SharedPreferencesUtils;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${薛亚南}
 * on 2017/1/12 19：02.
 */

public class TopicFragment extends BaseNetFragment {
    private TopicRootBean.DataBean topicList;
    private MyBaseData myBaseData;
    private View view;
    private RecyclerView topic_rlv;
    private Gson gson;
    private TopicRootBean topicRootBean;
    private List<TopicRootBean.DataBean.BannerBean> bannerBeanList;
    private List<TopicRootBean.DataBean.CircleBean> circleList;
    private SpringView topic_spl;
    private View view1;
    private Banner banner;
    private RecyclerView topicmy_rlv;
    private RecyclerView topic_hot_rlv;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            initRoll();
            TopicHotRecyclerView topicHotRecyclerView = new TopicHotRecyclerView(getActivity(), circleList);
            topic_hot_rlv.setAdapter(topicHotRecyclerView);
            topicHotRecyclerView.setListener(new TopicHotRecyclerView.OnClickLisenter() {
                //点击条目
                @Override
                public void setOnItemLisenter(int possition) {
                    CommonUtil.jumpAndId(getActivity(), TopicInfoActivtity.class, circleList.get(possition).getNid() + "");
                }
                //点击添加关注
                @Override
                public void setOnAddListenter(int possition) {
                    ToastUtil.show(getActivity(), "点击了" + possition + "add");
                    String cookie = SharedPreferencesUtils.getString(MyApplication.getContext(), "cookie", "");
                    //跳转登录界面
                    if (cookie == null) {
                        CommonUtil.jump(getActivity(), LogingActivity.class);
                    } else {

                    }
                }
            });
        }
    };
    private TextView topicmy_tv;
    private TextView topichot_tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson();
        myBaseData = new MyBaseData();
    }

    @Override
    public void onload() {
        initData();
    }

    public void initData() {
        myBaseData.getData(Constants.hot_viewPager, Constants.hot_viewPager_arg, BaseData.NORMALTIME);
    }

    @Override
    public View createSuccessView() {
        view1 = LayoutInflater.from(getActivity()).inflate(R.layout.topic_fragment, null);
        initView();
        return view1;
    }

    //初始化轮播图
    public void initRoll() {
        List<String> imgs = new ArrayList<>();
        for (int i = 0; i < bannerBeanList.size(); i++) {
            imgs.add(bannerBeanList.get(i).getImg());
        }
        banner.setImageLoader(new MyGlideImagLoaer()).setImages(imgs).start();
        //banner的点击事件
        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.show(getActivity(), "点击了" + (position - 1));
            }
        });
    }

    private void initView() {
        //我的圈子
        topicmy_rlv = (RecyclerView) view1.findViewById(R.id.topicmy_rlv);
        topicmy_tv = (TextView) view1.findViewById(R.id.topicmy_tv);
        //热门圈子
        topic_hot_rlv = (RecyclerView) view1.findViewById(R.id.topic_hot_rlv);
        topichot_tv = (TextView) view1.findViewById(R.id.topichot_tv);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        topic_hot_rlv.setLayoutManager(manager);

        //  topicmy_rlv.setLayoutManager(manager);
        banner = (Banner) view1.findViewById(R.id.topic_banner);
        topic_spl = (SpringView) view1.findViewById(R.id.topic_spl);
        topic_spl.setListener(new SpringView.OnFreshListener() {
            //下拉刷新
            @Override
            public void onRefresh() {
                myBaseData.getData(Constants.hot_viewPager, Constants.hot_viewPager_arg, BaseData.NOTIME);
                topic_spl.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {

            }
        });
        topic_spl.setHeader(new DefaultHeader(getActivity()));
        topic_spl.setType(SpringView.Type.FOLLOW);
    }

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
                    topicRootBean = gson.fromJson(data, TopicRootBean.class);
                    topicList = topicRootBean.getData();
                    bannerBeanList = topicList.getBanner();
                    circleList = topicList.getCircle();
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
