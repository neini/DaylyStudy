package com.bwie.demo.daylystudy.factoty;

import android.support.v4.app.Fragment;

import com.bwie.demo.daylystudy.fragment.CatogoryFragment;
import com.bwie.demo.daylystudy.fragment.CrileFragment;
import com.bwie.demo.daylystudy.fragment.EyeFragment;
import com.bwie.demo.daylystudy.fragment.HomeFragment;
import com.bwie.demo.daylystudy.fragment.HotFragment;
import com.bwie.demo.daylystudy.fragment.MineFragment;
import com.bwie.demo.daylystudy.fragment.TopicFragment;

import java.util.HashMap;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：51.
 */

public class HomeFragmentFactoty {
    public static HashMap<String, Fragment> fragmentHashMap = new HashMap<>();

    public static Fragment getFragment(String position) {
        Fragment fragment = fragmentHashMap.get(position);

        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case "首页":
                fragment = new HomeFragment();
                break;
            case "课程":
                fragment = new CatogoryFragment();
                break;
            case "圈子":
                fragment = new CrileFragment();
                break;
            case "我的":
                fragment = new MineFragment();
                break;
            case "热门":
                fragment = new HotFragment();
                break;
            case "话题":
                fragment = new TopicFragment();
                break;
            case "关注":
                fragment = new EyeFragment();
                break;

        }
        fragmentHashMap.put(position, fragment);
        return fragment;
    }
}
