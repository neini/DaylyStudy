package com.bwie.demo.daylystudy.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.app.LogingActivity;
import com.bwie.demo.daylystudy.application.MyApplication;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import org.greenrobot.eventbus.EventBus;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.bwie.demo.daylystudy.R.layout.showingpage_load_error;
import static com.bwie.demo.daylystudy.R.layout.showingpage_loading;
import static com.bwie.demo.daylystudy.R.layout.showingpage_unload;
import static com.bwie.demo.daylystudy.R.layout.title_line;


/**
 * Created by 芮靖林
 * on 2016/12/28.
 */
public abstract class ShowingPage extends FrameLayout implements View.OnClickListener {

    /**
     * 定义状态
     */

    public static final int STATE_UNLOAD = 1;
    public static final int STATE_LOADING = 2;
    public static final int STATE_LOAD_ERROR = 3;
    public static final int STATE_LOAD_EMPTY = 4;
    public static final int STATE_LOAD_SUCCESS = 5;
    private final AutoLinearLayout show_title;
    public int currentState = STATE_LOADING;//得到当前的状态
    private OnShowinPageListener onShowinPageListener;
    private LayoutParams params;
    private View view;
    private AutoRelativeLayout re_sucess, loading, unload, empty, error;
    private Context context;

    public ShowingPage(Context context) {
        super(context);
        this.context = context;
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        view = LayoutInflater.from(context).inflate(R.layout.showinpager, null);
        re_sucess = (AutoRelativeLayout) view.findViewById(R.id.re_sucess);
        loading = (AutoRelativeLayout) view.findViewById(R.id.loading);
        unload = (AutoRelativeLayout) view.findViewById(R.id.unload);
        empty = (AutoRelativeLayout) view.findViewById(R.id.empty);
        error = (AutoRelativeLayout) view.findViewById(R.id.error);
        show_title = (AutoLinearLayout) view.findViewById(R.id.show_title);
        view.findViewById(R.id.showing_error_bt_reload).setOnClickListener(this);
        view.findViewById(R.id.unload).setOnClickListener(this);
        this.addView(view, params);

        View titleView = LayoutInflater.from(context).inflate(R.layout.title_line, null);
        if (titleView != null && (show_title.getVisibility() == View.VISIBLE)) {
            show_title.removeAllViews();
            show_title.addView(titleView);
            setTitleView(titleView);
        }
        showPage();

        onLoad();
    }

    public void goneTitle() {
        show_title.setVisibility(View.GONE);
    }

    public void setOnShowinPageListener(OnShowinPageListener onShowinPageListener) {
        this.onShowinPageListener = onShowinPageListener;
    }

    /**
     * 对外提供方法，设置当前状态
     *
     * @param stateType
     */
    public void showCurrentPage(StateType stateType) {
        this.currentState = stateType.getCurrentState();
        showPage();
    }

    private void showPage() {
        //在主线程执行
        CommonUtil.runOnMainThread(new Runnable() {
            @Override
            public void run() {
                showPageOnUI();
            }
        });
    }

    private void showPageOnUI() {
        /**
         * 选择当前的状态进行显示
         */
        View sucess = createSuccessView();
        if (currentState == STATE_LOAD_SUCCESS && sucess != null) {
            re_sucess.setVisibility(VISIBLE);
            re_sucess.removeAllViews();
            re_sucess.addView(sucess);
        } else {
            re_sucess.setVisibility(GONE);
        }
        loading.setVisibility(currentState == STATE_LOADING ? View.VISIBLE : View.GONE);
        unload.setVisibility(currentState == STATE_UNLOAD ? View.VISIBLE : View.GONE);
        empty.setVisibility(currentState == STATE_LOAD_EMPTY ? View.VISIBLE : View.GONE);
        error.setVisibility(currentState == STATE_LOAD_ERROR ? View.VISIBLE : View.GONE);
    }

    //获取成功界面（每一个成功的界面都不同）
    protected abstract View createSuccessView();

    //添加title的页面
    protected abstract void setTitleView(View view);

    //数据加载
    protected abstract void onLoad();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //重新请求
            case R.id.showing_error_bt_reload:
                if (CommonUtil.isConnected()) {
                    this.showCurrentPage(StateType.STATE_LOADING);
                    if (onShowinPageListener != null) {
                        onShowinPageListener.isShowPager(v);
                    }
                }
                break;
            case R.id.unload:
                Intent intent = new Intent(context, LogingActivity.class);
                context.startActivity(intent);
                break;
        }
    }

    /**
     * 定义枚举类，限制状态类型
     */
    public enum StateType {
        STATE_LOADING(2), STATE_LOAD_ERROR(3), STATE_LOAD_EMPTY(4), STATE_LOAD_SUCCESS(5), STATE_UNLOAD(1);
        private final int currentState;

        StateType(int currentState) {
            this.currentState = currentState;
        }

        public int getCurrentState() {
            return currentState;
        }
    }
}
