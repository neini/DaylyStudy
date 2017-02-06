package com.bwie.demo.daylystudy.app;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseActivity;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.bean.CommitBean;
import com.bwie.demo.daylystudy.bean.RegisetBean;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.google.gson.Gson;

import java.util.HashMap;


public class RegistActivity extends BaseActivity implements View.OnClickListener {

    private TextView title_tv;
    private EditText regesit_et_pw;
    private EditText regesit_et_usernum;
    private EditText regesit_et_yzm;
    private TextView regest_tv_sendyzm;
    private Button regist_bt_tijiao;
    private TextView regest_tv;
    private String userNum;
    private String yzm;
    private String pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        iniiView();
    }

    //找控件
    public void iniiView() {
        title_tv = (TextView) findViewById(R.id.tv_title);
        title_tv.setText("注册");
        findViewById(R.id.back).setOnClickListener(this);
        //密码
        regesit_et_pw = (EditText) findViewById(R.id.regesit_et_pw);
        //手机号码
        regesit_et_usernum = (EditText) findViewById(R.id.regesit_et_usernum);
        //验证码
        regesit_et_yzm = (EditText) findViewById(R.id.regesit_et_yzm);
        //发送验证吗
        regest_tv_sendyzm = (TextView) findViewById(R.id.regest_tv_sendyzm);
        regest_tv_sendyzm.setOnClickListener(this);
        //提交
        regist_bt_tijiao = (Button) findViewById(R.id.regist_bt_tijiao);
        regist_bt_tijiao.setOnClickListener(this);
        //判断是否有密码 手机号
        regest_tv = (TextView) findViewById(R.id.regest_tv);
    }

    //获取输入的数据
    public void getInData() {
        //用户手机号
        userNum = regesit_et_usernum.getText().toString().trim();
        //验证码
        yzm = regesit_et_yzm.getText().toString().trim();
        //密码
        pw = regesit_et_pw.getText().toString().trim();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            //发送验证码
            case R.id.regest_tv_sendyzm:
                userNum = regesit_et_usernum.getText().toString().trim();
                if (TextUtils.isEmpty(userNum)) {
                    regest_tv.setVisibility(View.VISIBLE);
                    regest_tv.setText("手机号不能为空哦!");
                } else {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("dosubmit", "1");
                    map.put("account", userNum);
                    map.put("type", "1");
                    map.put("from", "hiapk");
                    new BaseData() {
                        @Override
                        public void onSucesss(String data) {
                            Gson gson = new Gson();
                            RegisetBean regisetBean = gson.fromJson(data, RegisetBean.class);
                            if (regisetBean.getStatus() == 200) {
                                ToastUtil.show(RegistActivity.this, "获取验证码成功");
                            } else {
                                ToastUtil.show(RegistActivity.this, "获取验证码失败");
                            }

                        }

                        @Override
                        public void onError(Throwable t) {
                            ToastUtil.show(RegistActivity.this, "获取验证码失败");
                        }
                    }.postData(false, false, Constants.signInCode, Constants.signInCodeArgs, BaseData.NORMALTIME, map);
                }
                break;
            //提交
            case R.id.regist_bt_tijiao:
                //验证码
                yzm = regesit_et_yzm.getText().toString().trim();
                //密码
                pw = regesit_et_pw.getText().toString().trim();
                HashMap<String, String> map = new HashMap<>();
                map.put("code", yzm);
                map.put("account", userNum);
                map.put("password", pw);
                if (TextUtils.isEmpty(yzm)) {
                    regest_tv.setVisibility(View.VISIBLE);
                    regest_tv.setText("验证码不能为空哦!");
                } else if (TextUtils.isEmpty(pw)) {
                    regest_tv.setVisibility(View.VISIBLE);
                    regest_tv.setText("密码码不能为空哦!");
                } else {
                    new BaseData() {
                        @Override
                        public void onSucesss(String data) {
                            Gson gson = new Gson();
                            CommitBean commitBean = gson.fromJson(data, CommitBean.class);
                            if (commitBean.getStatus() == 200) {
                                ToastUtil.show(RegistActivity.this, "注册成功");
                            } else {
                                ToastUtil.show(RegistActivity.this, "注册失败");
                            }

                        }

                        @Override
                        public void onError(Throwable t) {
                            ToastUtil.show(RegistActivity.this, "注册失败");
                        }
                    }.postData(false, false, Constants.register, Constants.registerargs, BaseData.NORMALTIME, map);
                    break;
                }
        }
    }
}
