package com.bwie.demo.daylystudy.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.adapter.CommonAdapter;
import com.bwie.demo.daylystudy.adapter.ViewHolder;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseShowInPagerActivity;
import com.bwie.demo.daylystudy.bean.DianJiBean;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XiangQingActivity extends BaseShowInPagerActivity implements SpringView.OnFreshListener{
    private ImageView setting_back;
    private String url;
    private DianJiBean dianjibean;
    private String data;
    private SpringView springView;
    private ImageView  tu;
    private View view;
    private TextView  tv_miaoshu;
    private TextView  tv_title;
    private TextView  title_tv;
    private ListView listView;
    @Override
    public void onLoad() {
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        MyBaseDate myBaseDate = new MyBaseDate();
        Map<String,String> map=new HashMap<>();
        map.put("aid",url);
        //Log.i("TAG", "zhanshi: ------------"+url);
        myBaseDate.postData(false,false, Constants.dian, Constants.dianji,0,map);


    }
    @Override
    public View creatSuccessView() {
      view= CommonUtil.inflate(R.layout.activity_xiang_qing);
        initData();
        return view;
    }

    private void zhanshi() {
       //  Log.i("TAG", "zhanshi: ------------"+dianjibean.getToppic());
     if(!(dianjibean.getToppic()==null)){
         Glide.with(this).load(dianjibean.getToppic()).into(tu);
     }
        tv_miaoshu.setText(dianjibean.getDesc());
        tv_title.setText(dianjibean.getDataList().get(0).getTitle());
      final  List<DianJiBean.DataListBean.ListBean> db=dianjibean.getDataList().get(0).getList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(XiangQingActivity.this,KeChengXQActivity.class);
                intent.putExtra("url",db.get(position).getCid());
                //  Log.i("AAAAAAA","....."+adl.get(position).getUrl());
              startActivity(intent);
            }
        });
        CommonAdapter com= new CommonAdapter<DianJiBean.DataListBean.ListBean>(this, db, R.layout.list_item) {
         @Override
            public void convert(ViewHolder helper, DianJiBean.DataListBean.ListBean item) {
                helper.setImageByUrl(R.id.home_recomm_iv_main, item.getCourse_pic());
                helper.setText(R.id.home_recomm_tv3, item.getCourse_name());
                helper.setText(R.id.home_recomm_tv4, item.getSchool_name());
                helper.setText(R.id.home_recomm_tv5, item.getCourse_paycount() + "人在学习");
            }
        };
         listView.setAdapter(com);
    }
    @Override
    public void creatTitleView(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setTextSize(20);
        textView1.setText("每日学");
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

    private void initData() {
        tu=(ImageView)view.findViewById(R.id.tu);
        tv_miaoshu=(TextView)view.findViewById(R.id.tv_miaoshu);
        tv_title=(TextView) view.findViewById(R.id.tv_title);
        listView=(ListView)view.findViewById(R.id.listView);
        //让listview失去焦点
        listView.setFocusable(false);
        //shangalaxiaal
        springView = (SpringView) view.findViewById(R.id.springView);
        //上下刷新
        springView = (SpringView) view.findViewById(R.id.springView);
        springView.setHeader(new DefaultHeader(this));
        springView.setType(SpringView.Type.FOLLOW);
        //对上下刷新设置上下文
        springView.setListener(this);
    }

    @Override
    public void onRefresh() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void onLoadmore() {

    }

    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                Message msg = Message.obtain();
                msg.obj = data;
                XiangQingActivity.this.data = data;
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
            Gson gson = new Gson();
            dianjibean = gson.fromJson(str, DianJiBean.class);
            //展示
            zhanshi();
        }
    };
}
