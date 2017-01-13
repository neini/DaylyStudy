package com.bwie.demo.daylystudy.fragment;

import android.view.View;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;

/**
 * Created by ${薛亚南}
 * on 2017/1/12 19：02.
 */

public class TopicFragment extends BaseNetFragment {

    private MyBaseData myBaseData;

    @Override
    public void onload() {
        myBaseData = new MyBaseData();
        myBaseData.getData(Constants.hot_viewPager, Constants.hot_viewPager_arg, 0);
    }

    @Override
    public View createSuccessView() {
        TextView textView = new TextView(getActivity());
        textView.setText("nihaoini");
        return textView;
    }

    @Override
    public void setTitleView1(View view) {
        view.setVisibility(View.GONE);
    }


    class MyBaseData extends BaseData {

        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }
        }

        @Override
        public void onError(Throwable t) {

        }
    }
}
