package com.bwie.demo.daylystudy.app;

import android.os.Bundle;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseActivity;

public class SortActivity extends BaseActivity {

    private TextView course_list_total_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        initView();
        String name=getIntent().getStringExtra("name");
        course_list_total_tv.setText(name);
    }

    private void initView() {
        course_list_total_tv = (TextView) findViewById(R.id.course_list_total_tv);
    }
}
