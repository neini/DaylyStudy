package com.bwie.demo.daylystudy.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.GLideUtils;

import java.util.ArrayList;

/**
 * Created by johpo on 2017/1/12 0012.
 */

public class MyViewPager extends ViewPager {
 //   private DisplayImageOptions imageOptions;
    private ArrayList<String> imgUrlList;
    private ArrayList<ImageView> dotList;
    private MyPagerAdapter myPagerAdapter;
    private static final int ROOL = 0;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //获取当前所在的页码
            int currentItem = MyViewPager.this.getCurrentItem();
            currentItem++;
            MyViewPager.this.setCurrentItem(currentItem);
            this.sendEmptyMessageDelayed(ROOL, 2000);

        }
    };
    private OnPageClickListener onPageClickListener;


    public MyViewPager(Context context) {
        super(context);
        init();
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        //加载Imageloader
      //  imageOptions = ImageLoaderUtils.initOptions();
    }

    /**
     * 初始化数据
     *
     * @param imgUrlList
     * @param dotList
     */
    public void initData(ArrayList<String> imgUrlList, final int[] dotArray, final ArrayList<ImageView> dotList) {
        this.imgUrlList = imgUrlList;
        this.dotList = dotList;
        //设置ViewPager监听
        this.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //切换小点
                for (int i = 0; i < dotList.size(); i++) {
                    if (position % dotList.size() == i) {
                        //亮
                        dotList.get(i).setImageResource(dotArray[0]);
                    } else {
                        dotList.get(i).setImageResource(dotArray[1]);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    /**
     * 设置适配器，并开始轮播
     */
    public void startViewPager() {
        if (myPagerAdapter == null) {
            myPagerAdapter = new MyPagerAdapter();
        }
        this.setAdapter(myPagerAdapter);
        //自动轮播
        handler.sendEmptyMessageDelayed(ROOL, 2000);

    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = CommonUtil.inflate(R.layout.roolviewpager_item );
            ImageView iv_roolpage = (ImageView) view.findViewById(R.id.iv_roolpager);
            //充满整个屏幕
            iv_roolpage.setScaleType(ImageView.ScaleType.FIT_XY);
            GLideUtils.loagNormalImg(imgUrlList.get(position % imgUrlList.size()), iv_roolpage);
            container.addView(view);
            view.setOnTouchListener(new OnTouchListener() {
                private long downTime;
                private float downY;
                private float downX;

                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {

                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            downX = motionEvent.getX();
                            downY = motionEvent.getY();
                            downTime = System.currentTimeMillis();
                            handler.removeCallbacksAndMessages(null);
                            break;
                        case MotionEvent.ACTION_MOVE:

                            break;
                        case MotionEvent.ACTION_UP:
                            float upX = motionEvent.getX();
                            float upY = motionEvent.getY();
                            if(upX==downX&&upY==downY&&System.currentTimeMillis()-downTime<1000){
                                //设置点击事件
//                                Toast.makeText(getContext(), "点击", Toast.LENGTH_SHORT).show();
                                //跳转界面
                                //设置监听的回调
                                if(onPageClickListener!=null){
                                    onPageClickListener.setOnPage(position%imgUrlList.size());
                                }
                            }

                        case MotionEvent.ACTION_CANCEL:
                            handler.sendEmptyMessageDelayed(ROOL,2000);
                            break;

                    }
                    return true;
                }
            });
            return view;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
    //当前View不可见
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        //移除任务和消息
        handler.removeCallbacksAndMessages(null);
    }
    //准备接口
    public interface OnPageClickListener{

        public void setOnPage(int position);
    }
    //设置接口
    public void setOnPageClickListener(OnPageClickListener onPageClickListener){
        this.onPageClickListener = onPageClickListener;
    }
}