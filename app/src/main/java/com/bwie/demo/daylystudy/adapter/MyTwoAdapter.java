package com.bwie.demo.daylystudy.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.bean.ThreeSort;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */

public class MyTwoAdapter extends BaseAdapter {
    Context context;
    List<ThreeSort.NodesBean> list;

    public MyTwoAdapter(Context context, List<ThreeSort.NodesBean> list) {
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
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.three_list_one_item,null);
            viewHolder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_name.setText(list.get(position).getMenu2().getCategory_name());
        return convertView;
    }
    class ViewHolder{
        TextView tv_name;
    }
}
