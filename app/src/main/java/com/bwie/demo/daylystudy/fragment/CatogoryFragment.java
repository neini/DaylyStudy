package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
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

public class CatogoryFragment extends BaseNetFragment {
    private String data;
    private TextView textView;


    //加载数据 并加载成功后设置应该返回的状态
    @Override
    public void onload() {
        initData();
    }

    public void initData() {
        MyBaseDate myBaseDate = new MyBaseDate();
        myBaseDate.getData("http://www.baidu.com", "http://www.baidu.com", 0);
    }

    //创建成功的视图
    @Override
    public View createSuccessView() {

        textView = new TextView(getActivity());
        textView.setText("niini");
        return textView;
    }

    //标题栏
    @Override
    public void setTitleView1(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setTextSize(20);
        textView1.setText("全部分类");
    }


    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            CatogoryFragment.this.data = data;
            CatogoryFragment.this.showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            //  ToastUtil.show(getActivity(), data);
        }

        //error后显示error状态
        @Override
        public void onError(Throwable t) {
            CatogoryFragment.this.showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }
}
