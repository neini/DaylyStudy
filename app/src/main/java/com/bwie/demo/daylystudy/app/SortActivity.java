package com.bwie.demo.daylystudy.app;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseShowInPagerActivity;
import com.bwie.demo.daylystudy.bean.ThreeSort;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.view.MyListVIew;
import com.google.gson.Gson;

import java.util.ArrayList;


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
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
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
                        }
                    });
                }
            });
        }
    };

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
        course_list_total_tv.setText(name);
        return view;
    }

    @Override
    public void creatTitleView(View view) {

    }

    private void initView() {
        course_list_total_tv = (TextView) view.findViewById(R.id.course_list_total_tv);
        course_list_ll = (LinearLayout) view.findViewById(R.id.course_list_ll);
        course_list_ll_filter = (LinearLayout)view. findViewById(R.id.course_list_ll_Filter);
        course_list_ll_sort = (LinearLayout)view. findViewById(R.id.course_list_ll_sort);
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
