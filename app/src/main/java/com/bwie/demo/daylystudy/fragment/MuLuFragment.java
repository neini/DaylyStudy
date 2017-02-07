package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.KeChengXQActivity;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.bean.HotTitleBean;
import com.bwie.demo.daylystudy.bean.KeChengBean;
import com.bwie.demo.daylystudy.bean.MuLuBean;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by johpo on 2017/1/17 0017.
 */

public class MuLuFragment extends BaseFragment {
    private boolean isConnet = true;
    private View view;
    private TextView tv_course_detail_totaltime;
    private TextView tv_course_detail_grade;
    private MyBaseData myBaseDate;

    private ListView details_fragment_lv;
    private String cid;
    private TextView details_fragment_tv_title;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!CommonUtil.isConnected()) {
            isConnet = false;
        }
    }
    @Override
    public void onLoad() {
        showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
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

    @Override
    public void onResume() {
        super.onResume();
        myBaseDate = new MyBaseData();
//        mulu = (MuLuBean) getArguments().getSerializable("bean");
        KeChengXQActivity keA = (KeChengXQActivity) getActivity();
        if (keA.kechengbean != null) {
            cid = keA.kechengbean.getData().getCid();
            Map<String, String> map = new HashMap<>();
            map.put("courseid", cid);
            myBaseDate.postData(false, false, Constants.mu, Constants.mulu, BaseData.NORMALTIME, map);
        }
    }
    public void initData() {
     /*  *//* Intent intent = getIntent();
        url = intent.getStringExtra("url");*//*
        myBaseDate = new MyBaseData();
//        mulu = (MuLuBean) getArguments().getSerializable("bean");
       KeChengXQActivity keA = (KeChengXQActivity) getActivity();
           if(keA.kechengbean != null){
       cid = keA.kechengbean.getData().getCid();
        Map<String,String> map=new HashMap<>();
        map.put("courseid",cid);
        myBaseDate.postData(false,false, Constants.mu, Constants.mulu, BaseData.NORMALTIME,map);*/
  //  }
    }
    @Override
    public View createSuccessView() {
        //view = View.inflate(getActivity(),R.layout.xiangqing_fragment, null);
        view = LayoutInflater.from(getActivity()).inflate(R.layout.mulu_fragment,null,true);
        return view;
    }
    @Override
    public void setTitleView(View view) {
        view.setVisibility(View.GONE);
    }
    class MyBaseData extends BaseData {

        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                if (data != null) {
                    Message msg = Message.obtain();
                    msg.obj = data;
                    Log.i("~~~~~~","data~~~~"+data);
                    handler.sendMessage(msg);
                }
            }
        }

        @Override
        public void onError(Throwable t) {
            showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }

    private MuLuBean mulu;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str= (String) msg.obj;
            Log.i("11111", "handleMessage: "+str);
            Gson gson = new Gson();
            mulu = gson.fromJson(str, MuLuBean.class);
            //展示
            zhanshi();
        }
    };

    private void zhanshi() {

        details_fragment_lv = (ListView) view.findViewById(R.id.details_fragment_lv);
        details_fragment_tv_title = (TextView) view.findViewById(R.id.details_fragment_tv_title);
        details_fragment_tv_title.setText(mulu.getData().get(0).getStep_name());
        final List<MuLuBean.DataBean.NodesBean> nodes = mulu.getData().get(0).getNodes();
        details_fragment_lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return nodes.size();
            }

            @Override
            public Object getItem(int i) {
                return nodes.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null){
                    view = LayoutInflater.from(getActivity()).inflate(R.layout.mulu_fragment_lv,null);
                }
                TextView lv_tv_title = (TextView) view.findViewById(R.id.lv_tv_title);
                TextView lv_tv_name = (TextView) view.findViewById(R.id.lv_tv_name);
                TextView lv_tv_time = (TextView) view.findViewById(R.id.lv_tv_time);
                lv_tv_title.setText(nodes.get(i).getSections_isfree()+"-"+nodes.get(i).getSections_sort());
                lv_tv_name.setText(nodes.get(i).getSections_name());
                return view;
            }
        });
    }

}