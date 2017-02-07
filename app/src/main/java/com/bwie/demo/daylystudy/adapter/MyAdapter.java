package com.bwie.demo.daylystudy.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.SortActivity;
import com.bwie.demo.daylystudy.bean.MySort;

import java.util.List;

/**
 * Created by Administrator on 2017/1/12.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<MySort.NodesBean> list;

    public MyAdapter(Context context, List<MySort.NodesBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=View.inflate(context, R.layout.sort_gridview_item,null);
            viewHolder.btn= (Button) convertView.findViewById(R.id.gv_btn);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.btn.setText(list.get(position).getCategory_name());
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SortActivity.class);
                intent.putExtra("name",list.get(position).getCategory_name());
                intent.putExtra("cid",list.get(position).getId());
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
    class ViewHolder{
        Button btn;
    }
}
