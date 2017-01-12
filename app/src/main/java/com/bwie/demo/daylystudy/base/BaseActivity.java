package com.bwie.demo.daylystudy.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.widget.Toast;

import com.bwie.demo.daylystudy.MainActivity;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by ${薛亚南}
 * on 2017/1/10 21：37.
 */

public class BaseActivity extends AutoLayoutActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
    }


}
