package com.bwie.demo.daylystudy.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.adapter.MyAdapter;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseNetFragment;
import com.bwie.demo.daylystudy.bean.MySort;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.view.MyGridView;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class CatogoryFragment extends BaseNetFragment {
    private String data;
    private TextView textView;

    private boolean isConnet = true;
    private MySort[] mySort;
    private TextView sort_tv1,sort_tv2,sort_tv3,sort_tv4,sort_tv5,sort_tv6;
    private View view;
    private ArrayList<TextView> tv_name_list;
    private RelativeLayout sort_rl_item1,sort_rl_item2,sort_rl_item3,sort_rl_item4,sort_rl_item5,sort_rl_item6;
    private ArrayList<RelativeLayout> rl_list;
    private MyGridView sort_gridview1,sort_gridview2,sort_gridview3,sort_gridview4,sort_gridview5,sort_gridview6;
    private ArrayList<MyGridView> gv_list;
    private boolean flag=true;
    private ArrayList<Integer> colorlist;
    private ImageView sort_iv1,sort_iv2,sort_iv3,sort_iv4,sort_iv5,sort_iv6;
    private ArrayList<ImageView> ivlist;
    private ArrayList<Integer> sxlist;


    //加载数据 并加载成功后设置应该返回的状态
    @Override
    public void onload() {
        initData();
    }

    public void initData() {
        MyBaseDate myBaseDate = new MyBaseDate();
        myBaseDate.getData("http://www.meirixue.com", Constants.sort,0);
    }

    //创建成功的视图
    @Override
    public View createSuccessView() {

        view = CommonUtil.inflate(R.layout.fragment_catogory_sort);
        initView();
        return view;
    }
    private void initView() {
        sort_tv1 = (TextView) view.findViewById(R.id.sort_tv1);
        sort_tv2 = (TextView) view.findViewById(R.id.sort_tv2);
        sort_tv3 = (TextView) view.findViewById(R.id.sort_tv3);
        sort_tv4 = (TextView) view.findViewById(R.id.sort_tv4);
        sort_tv5 = (TextView) view.findViewById(R.id.sort_tv5);
        sort_tv6 = (TextView) view.findViewById(R.id.sort_tv6);
        tv_name_list = new ArrayList<>();
        tv_name_list.add(sort_tv1);
        tv_name_list.add(sort_tv2);
        tv_name_list.add(sort_tv3);
        tv_name_list.add(sort_tv4);
        tv_name_list.add(sort_tv5);
        tv_name_list.add(sort_tv6);
        sort_rl_item1 = (RelativeLayout) view.findViewById(R.id.sort_rl_item1);
        sort_rl_item2 = (RelativeLayout) view.findViewById(R.id.sort_rl_item2);
        sort_rl_item3 = (RelativeLayout) view.findViewById(R.id.sort_rl_item3);
        sort_rl_item4 = (RelativeLayout) view.findViewById(R.id.sort_rl_item4);
        sort_rl_item5 = (RelativeLayout) view.findViewById(R.id.sort_rl_item5);
        sort_rl_item6 = (RelativeLayout) view.findViewById(R.id.sort_rl_item6);
        rl_list = new ArrayList<>();
        rl_list.add(sort_rl_item1);
        rl_list.add(sort_rl_item2);
        rl_list.add(sort_rl_item3);
        rl_list.add(sort_rl_item4);
        rl_list.add(sort_rl_item5);
        rl_list.add(sort_rl_item6);
        sort_gridview1 = (MyGridView) view.findViewById(R.id.sort_gridview1);
        sort_gridview2 = (MyGridView) view.findViewById(R.id.sort_gridview2);
        sort_gridview3 = (MyGridView) view.findViewById(R.id.sort_gridview3);
        sort_gridview4 = (MyGridView) view.findViewById(R.id.sort_gridview4);
        sort_gridview5 = (MyGridView) view.findViewById(R.id.sort_gridview5);
        sort_gridview6 = (MyGridView) view.findViewById(R.id.sort_gridview6);
        gv_list = new ArrayList<>();
        gv_list.add(sort_gridview1);
        gv_list.add(sort_gridview2);
        gv_list.add(sort_gridview3);
        gv_list.add(sort_gridview4);
        gv_list.add(sort_gridview5);
        gv_list.add(sort_gridview6);
        colorlist = new ArrayList<>();
        colorlist.add(R.color.sortText1);
        colorlist.add(R.color.sortText2);
        colorlist.add(R.color.sortText3);
        colorlist.add(R.color.sortText4);
        colorlist.add(R.color.sortText5);
        colorlist.add(R.color.sortText6);
        sort_iv1 = (ImageView) view.findViewById(R.id.sort_iv1);
        sort_iv2 = (ImageView) view.findViewById(R.id.sort_iv2);
        sort_iv3 = (ImageView) view.findViewById(R.id.sort_iv3);
        sort_iv4 = (ImageView) view.findViewById(R.id.sort_iv4);
        sort_iv5 = (ImageView) view.findViewById(R.id.sort_iv5);
        sort_iv6 = (ImageView) view.findViewById(R.id.sort_iv6);
        ivlist = new ArrayList<>();
        ivlist.add(sort_iv1);
        ivlist.add(sort_iv2);
        ivlist.add(sort_iv3);
        ivlist.add(sort_iv4);
        ivlist.add(sort_iv5);
        ivlist.add(sort_iv6);
        sxlist = new ArrayList<>();
        sxlist.add(R.mipmap.heart_sx);
        sxlist.add(R.mipmap.coffee_sx);
        sxlist.add(R.mipmap.diamond_sx);
        sxlist.add(R.mipmap.heart_sx);
        sxlist.add(R.mipmap.hat_sx);
        sxlist.add(R.mipmap.language_sx);

    }
    //标题栏
    @Override
    public void setTitleView1(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setText("全部分类");
    }


    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            CatogoryFragment.this.data = data;
            CatogoryFragment.this.showCurrentView(ShowingPage.StateType.STATE_LOAD_SUCCESS);
            Gson gson=new Gson();
            mySort = gson.fromJson(data,MySort[].class);
            for (int i = 0; i < tv_name_list.size(); i++) {
                tv_name_list.get(i).setText(mySort[i].getCname());
            }
            for (int i = 0; i < gv_list.size(); i++) {
                gv_list.get(i).setAdapter(new MyAdapter(MyApplication.getContext(),mySort[i].getNodes()));
            }

            for (int i = 0; i < rl_list.size(); i++) {
                final int a=i;
                rl_list.get(a).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int j = 0; j < gv_list.size(); j++) {
                            if(a!=j){
                                gv_list.get(j).setVisibility(View.GONE);
                                tv_name_list.get(j).setTextColor(getResources().getColor(R.color.oldColor));
                                ivlist.get(j).setImageResource(R.mipmap.down);
                            }else{
                                gv_list.get(j).setVisibility(View.VISIBLE);
                                tv_name_list.get(j).setTextColor(getResources().getColor(colorlist.get(j)));
                                ivlist.get(j).setImageResource(sxlist.get(j));
                            }
                        }
                    }
                });
            }

        }

        //error后显示error状态
        @Override
        public void onError(Throwable t) {
            CatogoryFragment.this.showCurrentView(ShowingPage.StateType.STATE_LOAD_ERROR);
        }
    }
}
