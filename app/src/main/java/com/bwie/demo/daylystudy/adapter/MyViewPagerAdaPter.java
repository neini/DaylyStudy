package com.bwie.demo.daylystudy.adapter;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.demo.daylystudy.app.DaoHangActivity;
import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.MainActivity;

import java.util.ArrayList;

/**
 * Created by johpo on 2017/1/12 0012.
 */

public class MyViewPagerAdaPter extends PagerAdapter {
    private final DaoHangActivity daoHangActivity;
    private ArrayList<Integer> al;
    public MyViewPagerAdaPter(DaoHangActivity daoHangActivity, ArrayList<Integer> al) {
        this.daoHangActivity=daoHangActivity;
        this.al=al;
    }
    @Override
    public int getCount() {
        return al.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(daoHangActivity, R.layout.vp_ite,null);
        ImageView xq_imag= (ImageView) view.findViewById(R.id.xq_image);
        if(position==al.size()-1){
            xq_imag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Intent intent=new Intent(daoHangActivity,MainActivity.class);
                  daoHangActivity.startActivity(intent);
                }
            });
        }
        xq_imag.setImageResource(al.get(position));
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}