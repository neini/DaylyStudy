package com.bwie.demo.daylystudy.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseActivity;
import com.bwie.demo.daylystudy.factoty.HomeFragmentFactoty;
import com.bwie.demo.daylystudy.view.LazyViewPager;

import java.util.List;

import static android.R.id.list;

public class MainActivity extends BaseActivity {

    private LazyViewPager main_lvp;
    private RadioGroup main_rg;
    private String[] homeList = {"首页", "课程", "圈子", "我的"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mian);
        //找控件
        initView();
    }

    private void initView() {
        main_lvp = (LazyViewPager) findViewById(R.id.main_lvp);
        main_rg = (RadioGroup) findViewById(R.id.main_rg);
        RadioButton radioButton = (RadioButton) main_rg.getChildAt(0);
        radioButton.setChecked(true);
        main_lvp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return HomeFragmentFactoty.getFragment(homeList[position]);
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        main_lvp.setOnPageChangeListener(new LazyViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < main_rg.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) main_rg.getChildAt(i);
                    if (i == position) {
                        main_lvp.setCurrentItem(i);
                        radioButton.setChecked(true);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        main_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                for (int j = 0; j < main_rg.getChildCount(); j++) {
                    RadioButton rb = (RadioButton) main_rg.getChildAt(j);
                    if (rb.getId() == i) {
                        main_lvp.setCurrentItem(j);
                    }
                }
            }
        });
    }

    //监听连续两次返回退出
    private long waitTime = 1200;
    private long touchTime = 0;

    //监听程序退出
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - touchTime) >= waitTime) {
                Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
                touchTime = currentTime;
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
