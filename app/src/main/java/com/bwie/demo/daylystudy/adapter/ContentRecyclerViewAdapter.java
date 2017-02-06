package com.bwie.demo.daylystudy.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.bean.HotContentBean;
import com.bwie.demo.daylystudy.bean.SpannedData;
import com.bwie.demo.daylystudy.holder.HotContentHolder;
import com.bwie.demo.daylystudy.utils.GLideUtils;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.List;

import static com.bwie.demo.daylystudy.R.id.hot_twoimg_one;

/**
 * Created by ${薛亚南}
 * on 2017/1/16 09：26.
 */

public class ContentRecyclerViewAdapter extends RecyclerView.Adapter<HotContentHolder<HotContentBean.DataBean>> {
    private List<HotContentBean.DataBean> hotContentBeanList;
    private Context context;

    public ContentRecyclerViewAdapter(List<HotContentBean.DataBean> hotContentBeanList, Context context) {
        this.hotContentBeanList = hotContentBeanList;
        this.context = context;
    }

    public void addMore(List list) {
        if (list != null) {
            hotContentBeanList.addAll(list);
        }
    }

    @Override
    public HotContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hotcontent_item, parent, false);
        HotContentHolder hotContentHolder = new HotContentHolder(view);

        return hotContentHolder;
    }

    @Override
    public void onBindViewHolder(HotContentHolder holder, int position) {
        HotContentBean.DataBean dataBean = hotContentBeanList.get(position);
        holder.hotcontent_tv_title.setText(dataBean.getP_title());
        holder.hotcontent_tv_usename.setText(dataBean.getUser_name());
        GLideUtils.loadCrileImg(dataBean.getUser_small_log(), holder.hotcontent_icon_img);
        //头像点击事件
        holder.hotcontent_icon_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(context, "点击了头像");
            }
        });
        //条目点击
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.show(context, "点击了条目");
            }
        });



        if (dataBean.getP_leaderette() != null) {
            holder.hotcontent_tv_leaderette.setText(dataBean.getP_leaderette());
        } else {
            holder.hotcontent_tv_leaderette.setVisibility(View.GONE);
        }
        Gson gson = new Gson();

        String p_tids = dataBean.getP_tids();
        if (!TextUtils.isEmpty(p_tids)) {
            Spanned spanned = Html.fromHtml(p_tids);
            final SpannedData[] spannedDatas = gson.fromJson(spanned.toString(), SpannedData[].class);
            holder.hotcontent_tids.removeAllViews();
            LinearLayout.LayoutParams pa = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            for (int i = 0; i < spannedDatas.length; i++) {
                final int p = i;
                TextView textView = new TextView(context);
                textView.setTextColor(Color.RED);
                textView.setText("#" + spannedDatas[p].getTname() + "#");
                pa.setMargins(10, 0, 10, 0);
                //点击事件
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ToastUtil.show(context, spannedDatas[p].getTname());
                    }
                });
                holder.hotcontent_tids.addView(textView, pa);
            }
        }


        String source = dataBean.getSource();
        if (!TextUtils.isEmpty(source)) {
            String[] strings = gson.fromJson(source, String[].class);
            if (strings.length == 1) {
                holder.hot_oneiimg.setVisibility(View.VISIBLE);
                holder.hot_twoiimg.setVisibility(View.GONE);
                holder.hot_threeiimg.setVisibility(View.GONE);
                holder.hot_oneimg_one.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load(strings[0]).placeholder(R.mipmap.default_one).into(holder.hot_oneimg_one);
            } else if (strings.length == 2) {
                holder.hot_twoiimg.setVisibility(View.VISIBLE);
                holder.hot_threeiimg.setVisibility(View.GONE);
                holder.hot_oneiimg.setVisibility(View.GONE);
                holder.hot_twoimg_one.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.hot_twoimg_two.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load(strings[0]).placeholder(R.mipmap.default_two).into(holder.hot_twoimg_one);
                Glide.with(context).load(strings[1]).placeholder(R.mipmap.default_two).into(holder.hot_twoimg_two);
            } else if (strings.length >= 3) {
                holder.hot_oneiimg.setVisibility(View.GONE);
                holder.hot_twoiimg.setVisibility(View.GONE);
                holder.hot_threeiimg.setVisibility(View.VISIBLE);
                holder.hot_threeimg_one.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.hot_threeiimg_two.setScaleType(ImageView.ScaleType.FIT_XY);
                holder.hot_threeiimg_three.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load(strings[0]).placeholder(R.mipmap.default_three).into(holder.hot_threeimg_one);
                Glide.with(context).load(strings[1]).placeholder(R.mipmap.default_three).into(holder.hot_threeiimg_two);
                Glide.with(context).load(strings[2]).placeholder(R.mipmap.default_three).into(holder.hot_threeiimg_three);
            }
        }
        holder.hotcontent_zanshu.setText(dataBean.getIs_prasie() + "");
        holder.chotcontent_shareshu.setText(dataBean.getP_aftershare() + "");
        holder.hotcontent_pinlunshu.setText(dataBean.getP_collectcount() + "");
    }

    @Override
    public int getItemCount() {
        return hotContentBeanList.size();
    }
}
