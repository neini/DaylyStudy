package com.bwie.demo.daylystudy.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseActivity;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseShowInPagerActivity;
import com.bwie.demo.daylystudy.bean.TopicInfoTopBean;
import com.bwie.demo.daylystudy.fragment.TopicChildFragment;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.GLideUtils;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.google.gson.Gson;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.bwie.demo.daylystudy.R.id.title_toolbar;
import static com.bwie.demo.daylystudy.R.id.topicinfo_vp;

public class TopicInfoActivtity extends BaseActivity {


    private View view;
    private ImageView topicinfo_backgroud;
    private ImageView topicinfo_title_img;
    private TextView topicinto_title;
    private TextView topic_brief;
    private TextView usercount;
    private TextView postcount;
    private ImageView img_add;
    private TabLayout tabLayout;
    private ViewPager topicinfo_vp;
    private Toolbar title_toolbar;
    private TextView title_tv;
    private String nid;
    private int page;
    private Gson gson;
    private String[] str = {"最新", "最热"};
    public  AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_info_activtity);
        initView();
        creatTitleView();
        gson = new Gson();
        getIntentId();
        getDataFromNet();
    }

    //获取传入的id
    public void getIntentId() {
        Intent intent = getIntent();
        nid = intent.getStringExtra("nid");
        getDataFromNet();
    }

    //请求网络数据
    public void getDataFromNet() {
        Map<String, String> map = new HashMap<>();
        map.put("nid", nid);
        map.put("order", "1");
        map.put("page", page + "");
        new BaseData() {
            @Override
            public void onSucesss(String data) {
                if (data != null) {
                    TopicInfoTopBean topicInfoTopBean = gson.fromJson(data, TopicInfoTopBean.class);
                    title_tv.setText(topicInfoTopBean.getData().getN_title());
                    topicinto_title.setText(topicInfoTopBean.getData().getN_title());
                    topicinfo_backgroud.setScaleType(ImageView.ScaleType.FIT_XY);
                    GLideUtils.loagNormalImg(topicInfoTopBean.getData().getN_big_img(), topicinfo_backgroud);
                    GLideUtils.loagNormalImg(topicInfoTopBean.getData().getN_small_img(), topicinfo_title_img);
                    topic_brief.setText(topicInfoTopBean.getData().getN_brief());
                    usercount.setText(topicInfoTopBean.getData().getN_user_count());
                    postcount.setText(topicInfoTopBean.getData().getN_post_count());
                    if (topicInfoTopBean.getData().getIsjoin() == 1) {
                        img_add.setImageResource(R.mipmap.jianhao);
                    } else {
                        img_add.setImageResource(R.mipmap.topic_focus);
                    }
                }
            }

            @Override
            public void onError(Throwable t) {
                ToastUtil.show(TopicInfoActivtity.this, "网络不给力");
            }
        }.postData(true, false, Constants.topictop, Constants.topictopargs, BaseData.NORMALTIME, map);

    }


    //找控件
    public void initView() {
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarLayout);
        //图片背景
        topicinfo_backgroud = (ImageView) findViewById(R.id.topicinfo_backgroud);
        //图片
        topicinfo_title_img = (ImageView) findViewById(R.id.topicinfo_title_img);
        //标题
        topicinto_title = (TextView) findViewById(R.id.topicinto_title);
        topic_brief = (TextView) findViewById(R.id.topic_activity);
        usercount = (TextView) findViewById(R.id.usercount);
        postcount = (TextView) findViewById(R.id.postcount);
        //是否关注
        img_add = (ImageView) findViewById(R.id.topicinfo_img_add);
        //tablayout
        tabLayout = (TabLayout) findViewById(R.id.tablaout);
        //viewpager
        topicinfo_vp = (ViewPager) findViewById(R.id.topicinfo_vp);
        tabLayout.addTab(tabLayout.newTab().setText(str[0]), true);
        tabLayout.addTab(tabLayout.newTab().setText(str[01]), false);
        topicinfo_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                TopicChildFragment topicChildFragment = new TopicChildFragment();
                Bundle bundle = new Bundle();
                bundle.putString("nid", nid);
                bundle.putString("index", position + "");
                topicChildFragment.setArguments(bundle);
                return topicChildFragment;
            }

            @Override
            public int getCount() {
                return str.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return str[position];
            }
        });
        tabLayout.setupWithViewPager(topicinfo_vp);
    }

    //标题栏控件
    public void creatTitleView() {
        title_toolbar = (Toolbar) findViewById(R.id.title_toolbar);
        title_toolbar.setNavigationIcon(R.mipmap.back);
        title_tv = (TextView) findViewById(R.id.title_tv);
        title_tv.setVisibility(View.VISIBLE);
        title_tv.setTextColor(Color.WHITE);
        title_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        title_toolbar.inflateMenu(R.menu.toolbar_menu);
        title_toolbar.getMenu().findItem(R.id.img_fatie).setVisible(true);
        title_toolbar.getMenu().findItem(R.id.img_serch).setVisible(false);
        title_toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.img_fatie:
                        ToastUtil.show(TopicInfoActivtity.this, "发帖");
                        break;
                }
                return true;
            }
        });
    }
}
