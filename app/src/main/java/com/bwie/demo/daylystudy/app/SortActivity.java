package com.bwie.demo.daylystudy.app;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.adapter.MyOneAdapter;
import com.bwie.demo.daylystudy.adapter.MyThreeAdapter;
import com.bwie.demo.daylystudy.adapter.MyTwoAdapter;
import com.bwie.demo.daylystudy.adapter.XqAdapter;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseShowInPagerActivity;
import com.bwie.demo.daylystudy.bean.ThreeSort;
import com.bwie.demo.daylystudy.bean.XqBean;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.bwie.demo.daylystudy.view.MyListVIew;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SortActivity extends BaseShowInPagerActivity implements View.OnClickListener {

    private TextView course_list_total_tv;
    private LinearLayout course_list_ll;
    private LinearLayout course_list_ll_filter;
    private LinearLayout course_list_ll_sort;
    private View view;
    private ListView pop_list_one;
    private View popur_item;
    private PopupWindow popupWindow;
    private ThreeSort[] threeSorts;
    private String data;
    private ArrayList<Integer> ivlist;
    private MyListVIew pop_list_two;
    private MyListVIew pop_list_three;
    private int cid;
    private MyListVIew sort_class_listview;
    private XqBean xqBean;
    private Map<String, String> map;
    private XqAdapter xqAdapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);
            String data= (String) msg.obj;
            Gson gson=new Gson();
            threeSorts = gson.fromJson(data,ThreeSort[].class);
            Log.i("aaaaa",data);
            pop_list_one.setAdapter(new MyThreeAdapter(SortActivity.this,threeSorts,ivlist));
            pop_list_one.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int a, long id) {

                    pop_list_two.setAdapter(new MyTwoAdapter(SortActivity.this,threeSorts[a].getNodes()));
                    pop_list_two.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            pop_list_three.setAdapter(new MyOneAdapter(SortActivity.this,threeSorts[a].getNodes().get(position).getNodes2()));
                            final int b=position;
                            pop_list_three.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    String id1 = threeSorts[a].getNodes().get(b).getNodes2().get(position).getMenu3().getId();
                                    map = new HashMap<>();
                                    map.put("cid",id1);
                                    new BaseData() {
                                        @Override
                                        public void onSucesss(String data) {
                                            Gson gson=new Gson();
                                            xqBean = gson.fromJson(data,XqBean.class);
                                            final List<XqBean.DatalistBean> datalist = xqBean.getDatalist();
                                            xqAdapter = new XqAdapter(SortActivity.this,datalist);
                                            sort_class_listview.setAdapter(xqAdapter);
                                            sort_class_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Intent intent=new Intent(SortActivity.this,KeChengXQActivity.class);
                                                    String cid = datalist.get(position).getCid();
                                                    intent.putExtra("url",cid);
                                                    startActivity(intent);
                                                }
                                            });
                                        }

                                        @Override
                                        public void onError(Throwable t) {

                                        }
                                    }.postData(false,false,"http://www.meirixue.com","api.php?c=list&a=index",0, map);
                                }
                            });
                        }
                    });
                }
            });
        }
    };
    private View popur_item_two;
    private TextView mianfei;
    private TextView shoufei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onLoad() {
        showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }

    @Override
    public View creatSuccessView() {
        view = CommonUtil.inflate(R.layout.activity_sort);
        initView();
        String name=getIntent().getStringExtra("name");
        cid = getIntent().getIntExtra("cid",0);
        course_list_total_tv.setText(name);
        map = new HashMap<>();
        map.put("cid",cid+"");
        new BaseData() {

            private List<XqBean.DatalistBean> datalist;

            @Override
            public void onSucesss(String data) {
                Gson gson=new Gson();
                xqBean = gson.fromJson(data,XqBean.class);
                datalist = xqBean.getDatalist();
                xqAdapter = new XqAdapter(SortActivity.this, datalist);
                sort_class_listview.setAdapter(xqAdapter);
                sort_class_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent=new Intent(SortActivity.this,KeChengXQActivity.class);
                        String cid = datalist.get(position).getCid();
                        intent.putExtra("url",cid);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onError(Throwable t) {

            }
        }.postData(false,false,"http://www.meirixue.com","api.php?c=list&a=index",0, map);
        return view;
    }


    @Override
    public void creatTitleView(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setTextSize(20);
        textView1.setText("课程列表");
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

    private void initView() {
        course_list_total_tv = (TextView) view.findViewById(R.id.course_list_total_tv);
        course_list_ll = (LinearLayout) view.findViewById(R.id.course_list_ll);
        course_list_ll_filter = (LinearLayout)view. findViewById(R.id.course_list_ll_Filter);
        course_list_ll_sort = (LinearLayout)view. findViewById(R.id.course_list_ll_sort);
        sort_class_listview = (MyListVIew) view.findViewById(R.id.sort_class_listview);
        course_list_ll.setOnClickListener(this);
        course_list_ll_filter.setOnClickListener(this);
        course_list_ll_sort.setOnClickListener(this);
        ivlist = new ArrayList<>();
        ivlist.add(R.mipmap.one);
        ivlist.add(R.mipmap.two);
        ivlist.add(R.mipmap.three);
        ivlist.add(R.mipmap.four);
        ivlist.add(R.mipmap.five);
        ivlist.add(R.mipmap.six);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.course_list_ll:
                popur_item = View.inflate(MyApplication.getContext(), R.layout.popur_iten,null);
                popupWindow = new PopupWindow(popur_item, ActionBar.LayoutParams.MATCH_PARENT, 600,true);
                pop_list_one = (ListView) popur_item.findViewById(R.id.pop_list_one);
                pop_list_two = (MyListVIew) popur_item.findViewById(R.id.pop_list_two);
                pop_list_three = (MyListVIew) popur_item.findViewById(R.id.pop_list_three);
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.showAsDropDown(v);
                MyBaseDate myBaseDate=new MyBaseDate();
                myBaseDate.getData("http://www.meirixue.com", Constants.threeCourse,0);
                break;
            case R.id.course_list_ll_Filter:
                popur_item_two = View.inflate(MyApplication.getContext(), R.layout.popur_item_two, null);
                popupWindow = new PopupWindow(popur_item_two, ActionBar.LayoutParams.MATCH_PARENT, 600,true);
                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                popupWindow.showAsDropDown(v);
                mianfei = (TextView) popur_item_two.findViewById(R.id.mianfei);
                shoufei = (TextView) popur_item_two.findViewById(R.id.shoufei);
                mianfei.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<XqBean.DatalistBean> list=new ArrayList<XqBean.DatalistBean>();
                        for (int i = 0; i < xqBean.getDatalist().size(); i++) {
                            if(xqBean.getDatalist().get(i).getCourse_price().equals("0.00")){
                                list.add(xqBean.getDatalist().get(i));
                            }
                        }
                        xqAdapter = new XqAdapter(SortActivity.this,list);
                        sort_class_listview.setAdapter(xqAdapter);
                        ToastUtil.show(MyApplication.getContext(),"aaaaaaaaaaa");
                    }
                });
                shoufei.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        List<XqBean.DatalistBean> list=new ArrayList<XqBean.DatalistBean>();
                        for (int i = 0; i < xqBean.getDatalist().size(); i++) {
                            if(!(xqBean.getDatalist().get(i).getCourse_price().equals("0.00"))){
                                list.add(xqBean.getDatalist().get(i));
                            }
                        }
                        xqAdapter = new XqAdapter(SortActivity.this,list);
                        sort_class_listview.setAdapter(xqAdapter);
                        ToastUtil.show(MyApplication.getContext(),"bbbbbbbbbbbbbb");
                    }
                });
                break;
            case R.id.course_list_ll_sort:
                break;
        }
    }

    public class MyBaseDate extends BaseData {


        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            }
            Message msg=Message.obtain();
            msg.obj=data;
            handler.sendMessage(msg);
        }

        //error后显示error状态
        @Override
        public void onError(Throwable t) {

            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        }
    }
}
