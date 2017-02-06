package com.bwie.demo.daylystudy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.LogingActivity;
import com.bwie.demo.daylystudy.bean.LogingBean;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView user_name;
    private Button my_top_log;
    private TextView account;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, null);
        initView();
        return view;
    }

    //接受传来的消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getLoginData(LogingBean event) {
        //接受传来登录成功的消息 event为用户的所有信息
        my_top_log.setVisibility(View.GONE);
        user_name.setVisibility(View.VISIBLE);
        account.setVisibility(View.GONE);
        user_name.setText(event.getData().getUser_name());
    }

    //找控件
    public void initView() {
        account = (TextView) view.findViewById(R.id.account);
        user_name = (TextView) view.findViewById(R.id.user_name);
        my_top_log = (Button) view.findViewById(R.id.My_top_log);
        view.findViewById(R.id.My_top_log).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.My_top_log:
                Intent intent = new Intent(getActivity(), LogingActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

