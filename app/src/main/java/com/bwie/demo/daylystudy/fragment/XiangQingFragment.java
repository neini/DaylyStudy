package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.KeChengXQActivity;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by johpo on 2017/1/17 0017.
 */

public class XiangQingFragment extends Fragment {
    private boolean isConnet = true;
    private View view;
    private TextView tv_course_detail_totaltime;
    private TextView tv_course_detail_grade;
    private AutoLinearLayout details_layout_details;
    private TextView details_tv_teacher;
    private TextView details_tv_scholl;
    private TextView details_tv_highlights;
    private TextView details_tv_brief_introduction;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.xiangqing_fragment,null,true);
        details_layout_details = (AutoLinearLayout) view.findViewById(R.id.details_layout_details);
        details_tv_teacher = (TextView) view.findViewById(R.id.details_tv_teacher);
        details_tv_scholl = (TextView) view.findViewById(R.id.details_tv_scholl);
        details_tv_highlights = (TextView) view.findViewById(R.id.details_tv_Highlights);
        details_tv_brief_introduction = (TextView) view.findViewById(R.id.details_tv_brief_introduction);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        KeChengXQActivity keA = (KeChengXQActivity) getActivity();
        if (keA.kechengbean != null) {
            details_tv_teacher.setText(keA.kechengbean.getData().getCourse_tname());
            details_tv_scholl.setText(keA.kechengbean.getData().getSchool_field());
            details_tv_highlights.setText(keA.kechengbean.getData().getCourse_tb_bright());
            details_tv_brief_introduction.setText(keA.kechengbean.getData().getCourse_tb_desc());
        }
    }


}
