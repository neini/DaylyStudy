package com.bwie.demo.daylystudy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.bean.TopicRootBean;
import com.bwie.demo.daylystudy.holder.TopicHotItemHolder;
import com.bwie.demo.daylystudy.utils.GLideUtils;

import java.util.List;

/**
 * Created by ${薛亚南}
 * on 2017/1/13 22：29.
 */

public class TopicHotRecyclerView extends RecyclerView.Adapter<TopicHotItemHolder<Object>> {
    private Context context;
    private List<TopicRootBean.DataBean.CircleBean> circleBeanList;

    public TopicHotRecyclerView(Context context, List<TopicRootBean.DataBean.CircleBean> circleBeanList) {
        this.context = context;
        this.circleBeanList = circleBeanList;
    }

    @Override
    public TopicHotItemHolder<Object> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotcricle_item, parent, false);
        TopicHotItemHolder topicHotItemHolder = new TopicHotItemHolder(view);
        return topicHotItemHolder;
    }

    @Override
    public void onBindViewHolder(TopicHotItemHolder<Object> holder, int position) {
        GLideUtils.loagNormalImg(circleBeanList.get(position).getN_small_img(), holder.imageView);
        holder.topichot_tv_brief.setText(circleBeanList.get(position).getN_brief());
        holder.topichot_tv_userCount.setText(circleBeanList.get(position).getN_user_count() + "关注");
        holder.topichot_tv_postCount.setText(circleBeanList.get(position).getN_post_count() + "帖子");
        holder.topichot_tv_title.setText(circleBeanList.get(position).getN_title());
    }

    @Override
    public int getItemCount() {
        return circleBeanList.size();
    }
}
