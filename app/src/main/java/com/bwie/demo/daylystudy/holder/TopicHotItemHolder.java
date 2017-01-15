package com.bwie.demo.daylystudy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by ${薛亚南}
 * on 2017/1/13 22：30.
 */

public class TopicHotItemHolder<T> extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView topichot_tv_title, topichot_tv_brief, topichot_tv_postCount, topichot_tv_userCount;

    public TopicHotItemHolder(View itemView) {
        super(itemView);
        AutoUtils.autoSize(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        topichot_tv_title = (TextView) itemView.findViewById(R.id.topichot_tv_title);
        topichot_tv_brief = (TextView) itemView.findViewById(R.id.topichot_tv_brief);
        topichot_tv_postCount = (TextView) itemView.findViewById(R.id.topichot_tv_postCount);
        topichot_tv_userCount = (TextView) itemView.findViewById(R.id.topichot_tv_userCount);
    }
}
