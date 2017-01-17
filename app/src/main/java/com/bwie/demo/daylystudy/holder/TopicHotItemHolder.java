package com.bwie.demo.daylystudy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.zhy.autolayout.utils.AutoUtils;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by ${薛亚南}
 * on 2017/1/13 22：30.
 */

public class TopicHotItemHolder<T> extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView topichot_tv_title, topichot_tv_brief, topichot_tv_postCount, topichot_tv_userCount;
    public View view;
    public ImageView img_add;

    public TopicHotItemHolder(View itemView) {
        super(itemView);
        AutoUtils.autoSize(itemView);
        view = itemView;
        img_add = (ImageView) itemView.findViewById(R.id.img_add);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        topichot_tv_title = (TextView) itemView.findViewById(R.id.topichot_tv_title);
        topichot_tv_brief = (TextView) itemView.findViewById(R.id.topichot_tv_brief);
        topichot_tv_postCount = (TextView) itemView.findViewById(R.id.topichot_tv_postCount);
        topichot_tv_userCount = (TextView) itemView.findViewById(R.id.topichot_tv_userCount);
    }
}
