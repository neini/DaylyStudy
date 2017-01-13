package com.bwie.demo.daylystudy.fragment;

import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.utils.ShowingPage;

/**
 * Created by ${薛亚南}
 * on 2017/1/12 19：02.
 */

public class HotFragment extends BaseNetFragment {

    @Override
    public void onload() {
        if (showingPage != null) {
            showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
        }
    }

    @Override
    public View createSuccessView() {
        TextView textView = new TextView(getActivity());
        textView.setText("热门");
        return textView;
    }

    //设置标题栏
    @Override
    public void setTitleView1(View view) {
        view.setVisibility(View.GONE);
    }


}
