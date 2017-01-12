package com.bwie.demo.daylystudy.fragment;

import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.utils.ShowingPage;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class MineFragment extends BaseFragment {
    @Override
    public void onLoad() {
        MineFragment.this.showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    public View createSuccessView() {
        TextView textView = new TextView(getActivity());
        textView.setText("我的");
        return textView;
    }

}
