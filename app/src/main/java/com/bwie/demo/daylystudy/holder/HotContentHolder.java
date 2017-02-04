package com.bwie.demo.daylystudy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

import static com.bwie.demo.daylystudy.R.id.hot_threeiimg;
import static com.bwie.demo.daylystudy.R.mipmap.hot;

/**
 * Created by ${薛亚南}
 * on 2017/1/16 09：25.
 */

public class HotContentHolder<T> extends RecyclerView.ViewHolder {

    public ImageView hotcontent_icon_img;
    public TextView hotcontent_tv_usename;
    public TextView hotcontent_tv_title;
    public TextView hotcontent_tv_leaderette;
    public CheckBox hotcon_bt_concern;
    public AutoLinearLayout hot_oneiimg, hot_threeiimg;
    public ImageView hot_oneimg_one, hot_twoimg_one, hot_twoimg_two, hot_threeiimg_two, hot_threeiimg_three, hot_threeimg_one;
    public AutoLinearLayout hot_twoiimg;
    public ImageView hotcontent_zan;
    public TextView hotcontent_zanshu;
    public ImageView chotcontent_share;
    public TextView chotcontent_shareshu;
    public ImageView hotcontent_pinlun;
    public TextView hotcontent_pinlunshu;
    public AutoLinearLayout hotcontent_tids;

    public HotContentHolder(View itemView) {
        super(itemView);
        AutoUtils.autoSize(itemView);
        //用户头像
        hotcontent_icon_img = (ImageView) itemView.findViewById(R.id.hotcontent_icon_img);
        //用户名
        hotcontent_tv_usename = (TextView) itemView.findViewById(R.id.hotcontent_tv_usename);
        //标题
        hotcontent_tv_title = (TextView) itemView.findViewById(R.id.hotcontent_tv_title);
        //描述
        hotcontent_tv_leaderette = (TextView) itemView.findViewById(R.id.hotcontent_tv_leaderette);
        //是否关注
        hotcon_bt_concern = (CheckBox) itemView.findViewById(R.id.hotcon_bt_concern);
        //一张图片
        hot_oneiimg = (AutoLinearLayout) itemView.findViewById(R.id.hot_oneiimg);
        hot_oneimg_one = (ImageView) itemView.findViewById(R.id.hot_oneimg_one);
        //两张 图片
        hot_twoiimg = (AutoLinearLayout) itemView.findViewById(R.id.hot_twoiimg);
        hot_twoimg_one = (ImageView) itemView.findViewById(R.id.hot_twoimg_one);
        hot_twoimg_two = (ImageView) itemView.findViewById(R.id.hot_twoimg_two);
        //三张 图片
        hot_threeiimg = (AutoLinearLayout) itemView.findViewById(R.id.hot_threeiimg);
        hot_threeimg_one = (ImageView) itemView.findViewById(R.id.hot_threeimg_one);
        hot_threeiimg_two = (ImageView) itemView.findViewById(R.id.hot_threeiimg_two);
        hot_threeiimg_three = (ImageView) itemView.findViewById(R.id.hot_threeiimg_three);
        //点赞
        hotcontent_zan = (ImageView) itemView.findViewById(R.id.hotcontent_zan);
        hotcontent_zanshu = (TextView) itemView.findViewById(R.id.hotcontent_zanshu);
        //分享
        chotcontent_share = (ImageView) itemView.findViewById(R.id.chotcontent_share);
        chotcontent_shareshu = (TextView) itemView.findViewById(R.id.chotcontent_shareshu);
        //评论
        hotcontent_pinlun = (ImageView) itemView.findViewById(R.id.hotcontent_pinlun);
        hotcontent_pinlunshu = (TextView) itemView.findViewById(R.id.hotcontent_pinlunshu);
        //类型
        hotcontent_tids = (AutoLinearLayout) itemView.findViewById(R.id.hotcontent_tids);

    }
}
