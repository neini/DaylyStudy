package com.bwie.demo.daylystudy.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.EditText;

import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.base.BaseActivity;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.bean.LogingBean;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;

import static android.R.attr.data;
import static com.bwie.demo.daylystudy.R.id.login_bt_login;
import static com.bwie.demo.daylystudy.R.id.re_sucess;


public class LogingActivity extends BaseActivity implements View.OnClickListener {

    private TextView title_tv;
    private EditText login_et_usernum;
    private EditText login_et_pw;
    private TextView login_tv_nonet;
    private MyBaseData myBaseData;
    private String userName;
    private String pw;
    private Gson gson;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);
        intent = getIntent();
        initView();
        myBaseData = new MyBaseData();
        gson = new Gson();
    }

    //判断是否写入用户名以及密码
    public void hasNameOrPw() {
        userName = login_et_usernum.getText().toString().trim();
        pw = login_et_pw.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            login_tv_nonet.setVisibility(View.VISIBLE);
            login_tv_nonet.setText("用户名不能为空");
            return;
        }
        if (TextUtils.isEmpty(pw)) {
            login_tv_nonet.setVisibility(View.VISIBLE);
            login_tv_nonet.setText("密码不能为空");
            return;
        }

    }

    //请求数据
    public void getData() {
        Map<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("password", pw);
        map.put("dosubmit", "1");
        Log.i("TAG", "--------------------");
        myBaseData.postData(false, true, Constants.signIn, Constants.signInArgs, 0, map);
    }

    //找控件
    public void initView() {
        findViewById(R.id.back).setOnClickListener(this);
        title_tv = (TextView) findViewById(R.id.tv_title);
        title_tv.setText("登录");
        //用户名
        login_et_usernum = (EditText) findViewById(R.id.login_et_usernum);
        //密码
        login_et_pw = (EditText) findViewById(R.id.login_et_pw);
        //忘记密码
        findViewById(R.id.login_tv_forgetpw).setOnClickListener(this);
        //网络未连接
        login_tv_nonet = (TextView) findViewById(R.id.login_tv_nonet);
        //登录
        findViewById(R.id.login_bt_login).setOnClickListener(this);
        //注册
        findViewById(R.id.login_bt_zuce).setOnClickListener(this);
        findViewById(R.id.qq).setOnClickListener(this);
        findViewById(R.id.weibo).setOnClickListener(this);
        findViewById(R.id.weix).setOnClickListener(this);

    }

    class MyBaseData extends BaseData {
        @Override
        public void onSucesss(String data) {
            isLoging(data);
        }

        @Override
        public void onError(Throwable t) {

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            //忘记密码
            case R.id.login_tv_forgetpw:
                break;
            //登录
            case login_bt_login:
                isNet();
                hasNameOrPw();
                getData();
                break;
            //注册
            case R.id.login_bt_zuce:
                CommonUtil.jump(this, RegistActivity.class);
                break;
            //QQ登录
            case R.id.qq:
                break;
        }
    }


    //判断是否登录成功
    public void isLoging(String data) {
        LogingBean logingBean = gson.fromJson(data, LogingBean.class);
        if (logingBean.getStatus() == 200) {
            ToastUtil.show(this, "登录成功");
            EventBus.getDefault().post(logingBean);
            MyApplication.isLoging = true;
            finish();
        } else if (logingBean.getStatus() == 202) {
            login_tv_nonet.setVisibility(View.VISIBLE);
            login_tv_nonet.setText("用户不存在");
        } else if (logingBean.getStatus() == 201) {
            login_tv_nonet.setVisibility(View.VISIBLE);
            login_tv_nonet.setText("密码不正确");
        }
    }

    //判断网络
    public void isNet() {
        if (!CommonUtil.isConnected()) {
            login_tv_nonet.setVisibility(View.VISIBLE);
        }
    }
}
