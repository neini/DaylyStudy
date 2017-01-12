package com.bwie.demo.daylystudy.factoty;

import android.support.v4.app.Fragment;

import com.bwie.demo.daylystudy.fragment.CatogoryFragment;
import com.bwie.demo.daylystudy.fragment.CrileFragment;
import com.bwie.demo.daylystudy.fragment.HomeFragment;
import com.bwie.demo.daylystudy.fragment.MineFragment;

import java.util.HashMap;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：51.
 */

public class HomeFragmentFactoty {
    public static HashMap<Integer, Fragment> fragmentHashMap = new HashMap<>();

    public static Fragment getFragment(int position) {
        Fragment fragment = fragmentHashMap.get(position);

        if (fragment != null) {
            return fragment;
        }
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new CatogoryFragment();
                break;
            case 2:
                fragment = new CrileFragment();
                break;
            case 3:
                fragment = new MineFragment();
                break;
        }
        fragmentHashMap.put(position,fragment);
        return fragment;
    }
}
