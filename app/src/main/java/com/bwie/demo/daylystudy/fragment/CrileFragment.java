package com.bwie.demo.daylystudy.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.factoty.HomeFragmentFactoty;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.bwie.demo.daylystudy.view.LazyViewPager;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;
import static android.view.View.inflate;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class CrileFragment extends BaseFragment {
    final String[] str = {"话题", "热门", "关注"};
    private boolean isConnet = true;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager cricle_lvp;


    @Override
    public void onLoad() {
        showingPage.setOnShowinPageListener(new OnShowinPageListener() {
            @Override
            public void isShowPager(View view) {
                isConnet = true;
                initData();
            }
        });
        initData();
    }

    //请求数据的方法
    public void initData() {
        showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }


    @Override
    public View createSuccessView() {
        View crileView = LayoutInflater.from(getActivity()).inflate(R.layout.circle_fragment, null);
        cricle_lvp = (ViewPager) crileView.findViewById(R.id.cricle_lvp);
        cricle_lvp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return HomeFragmentFactoty.getFragment(str[position]);
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return str[position];
            }
        });
        tabLayout.setupWithViewPager(cricle_lvp);
        return crileView;
    }

    @Override
    public void setTitleView(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.title_toolbar);
        toolbar.setNavigationIcon(R.mipmap.add_friend);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(getActivity(), "add Friendly");
            }
        });
        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.addTab(tabLayout.newTab().setText(str[0]), true);
        tabLayout.addTab(tabLayout.newTab().setText(str[1]), false);
        tabLayout.addTab(tabLayout.newTab().setText(str[2]), false);
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerPadding(50);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(getActivity(),
                R.drawable.layout_divider_vertical));

    }

}
