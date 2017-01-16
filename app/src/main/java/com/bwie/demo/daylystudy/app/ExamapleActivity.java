package com.bwie.demo.daylystudy.app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseShowInPagerActivity;
import com.bwie.demo.daylystudy.utils.ShowingPage;


public class ExamapleActivity extends BaseShowInPagerActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //加载数据
    @Override
    public void onLoad() {
        MyBaseDate myBaseDate = new MyBaseDate();
        myBaseDate.getData("http://www.baidu.com", "http://www.baidu.com", 0);
    }

    @Override
    public View creatSuccessView() {
        textView = new TextView(this);
        return textView;
    }

    @Override
    public void creatTitleView(View view) {

    }


    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                textView.setText("data");
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
