package com.bwie.demo.daylystudy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.bean.ThreeSort;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/1/16.
 */

public class MyThreeAdapter extends BaseAdapter {
    Context context;
    ThreeSort[] threeSorts;
    ArrayList<Integer> ivlist;

    public MyThreeAdapter(Context context, ThreeSort[] threeSorts, ArrayList<Integer> ivlist) {
        this.context = context;
        this.threeSorts = threeSorts;
        this.ivlist = ivlist;
    }

    @Override
    public int getCount() {
        return threeSorts.length;
    }

    @Override
    public Object getItem(int position) {
        return threeSorts[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.three_list_one_item,null);
            viewHolder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_img= (ImageView) convertView.findViewById(R.id.tv_img);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_name.setText(threeSorts[position].getMenu().getCategory_name());
        viewHolder.tv_img.setImageResource(ivlist.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView tv_name;
        ImageView tv_img;
    }
}
