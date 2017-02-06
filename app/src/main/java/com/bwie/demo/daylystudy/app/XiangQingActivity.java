package com.bwie.demo.daylystudy.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bwie.demo.daylystudy.R;

public class XiangQingActivity extends AppCompatActivity {
private ImageView setting_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);

        //  intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        setting_back=(ImageView)findViewById(R.id.setting_back);
        setting_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(XiangQingActivity.this,BannerActivity.class);
                startActivity(intent);
            }
        });

    }
}
