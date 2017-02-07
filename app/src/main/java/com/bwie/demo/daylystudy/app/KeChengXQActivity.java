package com.bwie.demo.daylystudy.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseShowInPagerActivity;
import com.bwie.demo.daylystudy.bean.KeChengBean;
import com.bwie.demo.daylystudy.factoty.HomeFragmentFactoty;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class KeChengXQActivity extends BaseShowInPagerActivity {
    private String url;
    private ImageView iv_kecheng;
    private String data;
    private TextView tv_course_detail_title;
    private TextView tv_course_detail_totaltime;
    private TextView tv_course_detail_grade;
    private TextView tv_course_detail_person_num;
    private TabLayout tabLayout;
    final String[] str = {"详情", "目录", "评价"};
    private View view;
    private ViewPager vp_course_detail;
    private int curnetPosition = 0;
    private int oldPosition = 0;
   // ArrayList<Fragment> al=new  ArrayList<>();
   public KeChengBean kechengbean;
    @Override
    public void onLoad() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        Log.i("~~~~~~","url~~~~"+url);
       MyBaseDate myBaseDate = new MyBaseDate();
        Map<String,String> map=new HashMap<>();
        map.put("courseid",url);
        myBaseDate.postData(false,false, Constants.ke, Constants.kecheng, BaseData.NORMALTIME,map);
        // myBaseDate.getData(Constants.dian, Constants.dianji+"&aid"+url, 0);
    }

    @Override
    public View creatSuccessView() {
         view =  LayoutInflater.from(this).inflate(R.layout.activity_ke_cheng_xq, null);
        initData();
        return view;
    }

    private void initData() {

        iv_kecheng=(ImageView)view.findViewById(R.id.iv_kecheng);
        tv_course_detail_title=(TextView) view.findViewById(R.id.tv_course_detail_title);
        tv_course_detail_totaltime=(TextView) view.findViewById(R.id.tv_course_detail_totaltime);
        tv_course_detail_grade=(TextView) view.findViewById(R.id.tv_course_detail_grade);
        tv_course_detail_person_num=(TextView) view.findViewById(R.id.tv_course_detail_person_num);

        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.addTab(tabLayout.newTab().setText(str[0]), true);
        tabLayout.addTab(tabLayout.newTab().setText(str[1]), false);
        tabLayout.addTab(tabLayout.newTab().setText(str[2]), false);
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        linearLayout.setDividerPadding(30);
        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
                R.drawable.layout_dividerl));

        vp_course_detail = (ViewPager) view.findViewById(R.id.vp_course_detail);


    }

    @Override
    public void creatTitleView(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setTextSize(20);
        textView1.setText("课程详情");
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.title_toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.img_serch:

                        break;
                }
                return true;
            }
        });

    }
    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                Message msg = Message.obtain();
                msg.obj = data;
                KeChengXQActivity.this.data = data;
                Log.i("~~~~~~","data~~~~"+data);
                Gson gson = new Gson();
                kechengbean = gson.fromJson(data, KeChengBean.class);
                handler.sendMessage(msg);
            }
        }
        //error后显示error状态
        @Override
        public void onError(Throwable t) {

            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        }
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str= (String) msg.obj;
//            Gson gson = new Gson();
//             kechengbean = gson.fromJson(str, KeChengBean.class);
//            Log.i("TTTTTTTT", "handleMessage: ---------------"+kechengbean);
            //展示
            zhanshi();
        }
    };
    private void zhanshi() {
        Glide.with(this).load(kechengbean.getData().getCourse_pic()).into(iv_kecheng);
        tv_course_detail_title.setText(kechengbean.getData().getCourse_name());
        tv_course_detail_totaltime.setText("总课时："+kechengbean.getData().getCourse_hour());
        tv_course_detail_grade.setText("评分："+kechengbean.getData().getSchool_category());
        tv_course_detail_person_num.setText(kechengbean.getData().getCourse_paycount()+"人在学");
        vp_course_detail.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                curnetPosition = position;
                return HomeFragmentFactoty.getFragment(str[position]);
                // return ;
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
        tabLayout.setupWithViewPager(vp_course_detail);
    }
}
