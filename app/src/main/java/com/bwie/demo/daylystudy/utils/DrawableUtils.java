package com.bwie.demo.daylystudy.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;


public class DrawableUtils
{

	public static GradientDrawable getGradientDrawable(int shape, float radius, int argb)
	{
		GradientDrawable bg = new GradientDrawable();
		bg.setShape(shape);// 设置形状
		bg.setCornerRadius(radius);// 设置圆角
		bg.setColor(argb);
		return bg;
	}

	public static StateListDrawable getStateListDrawable(Drawable normalBg, Drawable pressBg)
	{
		StateListDrawable selectorBg = new StateListDrawable();
		selectorBg.addState(new int[] { android.R.attr.state_pressed }, pressBg);
		selectorBg.addState(new int[] {}, normalBg);
		return selectorBg;
	}
}
