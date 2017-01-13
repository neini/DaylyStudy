package com.bwie.demo.daylystudy.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.ExamapleActivity;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class HomeFragment extends BaseFragment {

    private Toolbar title_toolbar;

    //加载数据 并根据加载的结果返回相应的状态
    @Override
    public void onLoad() {
        showingPage.setOnShowinPageListener(new OnShowinPageListener() {
            @Override
            public void isShowPager(View view) {
                initData();
            }
        });
        initData();
    }

    //执行加执行加载数据的操作
    public void initData() {
        MyBaseDate myBaseDate = new MyBaseDate();
        myBaseDate.getData("http://www.baidu.com", "http://www.baidu.com", 0);
    }

    ;

    //创建成功的视图
    @Override
    public View createSuccessView() {
        TextView textView = new TextView(getActivity());
        textView.setText("首页");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ExamapleActivity.class);
                startActivity(intent);
            }
        });
        return textView;
    }

    //设置标题栏
    @Override
    public void setTitleView(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setTextSize(20);
        textView1.setText("每日学");
    }

    //初始化标题栏
    public void intiTitleView() {

    }

    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                ToastUtil.show(getActivity(), data);
            }
        }

        //error后显示error状态
        @Override
        public void onError(Throwable t) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        }
    }
}
