package com.bwie.demo.daylystudy.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.adapter.ContentRecyclerViewAdapter;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.bean.HotContentBean;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${薛亚南}
 * on 2017/1/15 21：14.
 */

public class TopicChildFragment extends BaseNetFragment {

    private View view;
    private String tid;
    private MyBaseData myBaseData;
    private int page = 1;
    private RecyclerView hotchild_recyclerview;
    private SpringView hotchild_springview;
    private FloatingActionButton hotchild_floatActionBton;
    private Gson gson;
    private ContentRecyclerViewAdapter contentRecyclerViewAdapter;
    private List<HotContentBean.DataBean> hotList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBaseData = new MyBaseData();
        gson = new Gson();
    }

    @Override
    public View createSuccessView() {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.spring_recyclerview_item, null);
        initView();
        return view;
    }


    //找控件
    public void initView() {
        hotchild_springview = (SpringView) view.findViewById(R.id.hotchild_springview);
        hotchild_recyclerview = (RecyclerView) view.findViewById(R.id.hotchild_recyclerview);
        hotchild_floatActionBton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        //悬浮控件和recyclerview建立关联
        hotchild_floatActionBton.attachToRecyclerView(hotchild_recyclerview);
        hotchild_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));

        //悬浮控件的点击事件
        hotchild_floatActionBton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        hotchild_springview.setHeader(new DefaultHeader(getActivity()));
        hotchild_springview.setFooter(new DefaultFooter(getActivity()));
        hotchild_springview.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                contentRecyclerViewAdapter = null;
                hotList.clear();
                getData();
                hotchild_springview.onFinishFreshAndLoad();
            }

            //加载更多
            @Override
            public void onLoadmore() {
                ++page;
                Log.i("TAG", "page***" + page);
                getData();
            }
        });
        hotchild_springview.setType(SpringView.Type.FOLLOW);
    }

    public void getData() {
        tid = getArguments().getString("nid");
        String index = getArguments().getString("index");
        if (index.equals("0")) {
            Map<String, String> map = new HashMap<>();
            map.put("nid", tid);
            map.put("order", "1");
            map.put("page", page + "");
            myBaseData.postData(false, false, Constants.topichot, Constants.topichotargs, BaseData.NORMALTIME, map);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("nid", tid);
            map.put("order", "2");
            map.put("page", page + "");
            myBaseData.postData(false, false, Constants.topichot, Constants.topichotargs, BaseData.NORMALTIME, map);
        }
    }


    @Override
    public void onload() {
        getData();
    }

    @Override
    public void setTitleView1(View view) {
        view.setVisibility(View.GONE);
    }

    class MyBaseData extends BaseData {
        private int lastPosition = 0;

        @Override
        public void onSucesss(final String data) {
            if (data != null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                        HotContentBean hotContentBean = gson.fromJson(data, HotContentBean.class);
                        List<HotContentBean.DataBean> hotContentBeanList = hotContentBean.getData();
                        lastPosition = hotList.size() - 1;
                        hotList.addAll(hotContentBeanList);
                        contentRecyclerViewAdapter = new ContentRecyclerViewAdapter(hotList, getActivity());
                        hotchild_recyclerview.setAdapter(contentRecyclerViewAdapter);
                        hotchild_recyclerview.scrollToPosition(lastPosition);
                    }
                });
            }
        }

        @Override
        public void onError(Throwable t) {
            showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }
}
