package com.bwie.demo.daylystudy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.bean.XqBean;
import com.bwie.demo.daylystudy.utils.GLideUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */

public class XqAdapter extends BaseAdapter{
    Context context;
    List<XqBean.DatalistBean> list;
    private ImageView home_recomm_iv_main;

    public XqAdapter(Context context, List<XqBean.DatalistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context,R.layout.lv_item,null);
            viewHolder.home_recomm_iv_main= (ImageView) convertView.findViewById(R.id.home_recomm_iv_main);
            viewHolder.home_recomm_tv3= (TextView) convertView.findViewById(R.id.home_recomm_tv3);
            viewHolder.home_recomm_tv4= (TextView) convertView.findViewById(R.id.home_recomm_tv4);
            viewHolder.home_recomm_tv5= (TextView) convertView.findViewById(R.id.home_recomm_tv5);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        GLideUtils.loagNormalImg(list.get(position).getCourse_pic(),viewHolder.home_recomm_iv_main);
        viewHolder.home_recomm_tv3.setText(list.get(position).getCourse_name());
        viewHolder.home_recomm_tv4.setText(list.get(position).getSchool_name());
        viewHolder.home_recomm_tv5.setText(list.get(position).getCourse_paycount()+"人在学习");
        return convertView;
    }
    class ViewHolder{
        ImageView home_recomm_iv_main;
        TextView home_recomm_tv3,home_recomm_tv4,home_recomm_tv5;
    }
}
