package com.bwie.demo.daylystudy.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.demo.daylystudy.R;
import com.bwie.demo.daylystudy.XiangQingActivity;
import com.bwie.demo.daylystudy.adapter.CommonAdapter;
import com.bwie.demo.daylystudy.adapter.ViewHolder;
import com.bwie.demo.daylystudy.base.BaseData;
import com.bwie.demo.daylystudy.base.BaseFragment;
import com.bwie.demo.daylystudy.bean.HomeBean;
import com.bwie.demo.daylystudy.interfaces.OnShowinPageListener;
import com.bwie.demo.daylystudy.utils.CommonUtil;
import com.bwie.demo.daylystudy.utils.Constants;
import com.bwie.demo.daylystudy.utils.GLideUtils;
import com.bwie.demo.daylystudy.utils.ShowingPage;
import com.bwie.demo.daylystudy.utils.ToastUtil;
import com.bwie.demo.daylystudy.view.MyViewPager;
import com.google.gson.Gson;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${薛亚南}
 * on 2017/1/11 11：56.
 */

public class HomeFragment extends BaseFragment implements SpringView.OnFreshListener{
    int[] dotArray = new int[]{R.mipmap.zaker_content_praise_press, R.mipmap.zaker_content_praise};
    //装viewpager的图片
    ArrayList<String> imgUrlList = new ArrayList<>();
    //装小圆点
    ArrayList<ImageView> dotList = new ArrayList<>();
    ArrayList<TextView> tvlist = new ArrayList<>();
    ArrayList<ImageView> ivlist = new ArrayList<>();
    ArrayList<TextView> tvlist2 = new ArrayList<>();
    ArrayList<TextView> tvlist3 = new ArrayList<>();
    ArrayList<ImageView> ivlist2 = new ArrayList<>();
    ArrayList<ImageView> ivlist3 = new ArrayList<>();
    ArrayList<ImageView> ivlist4= new ArrayList<>();
    ArrayList<TextView> tvlist4 = new ArrayList<>();
    List<HomeBean.DataBean.SliderBean> adl;
    private SpringView springView;
    private HomeBean homebean;
    private String data;
    private LinearLayout dots_ll;
    private LinearLayout hoem_ad_ll1;
    private LinearLayout hoem_ad_ll2;
    private LinearLayout home_more_1;
    private RelativeLayout home_ad_rl;
    private MyViewPager myViewPager;
    private ImageView home_more_iv_1;
    private ImageView home_more_iv_2;
    private ImageView home_more_iv_3;
    private ImageView home_more_iv_4;
    private ImageView home_more_iv_5;
    private ImageView home_more_iv_6;
    private TextView home_more_tv_1;
    private TextView home_more_tv_2;
    private TextView home_more_tv_3;
    private TextView home_more_tv_4;
    private TextView home_more_tv_5;
    private TextView home_more_tv_6;
    private ImageView home_ad_iv1;
    private ImageView home_ad_iv2;
    private ImageView home_ad_iv3;
    private TextView home_ad_tv1;
    private TextView home_ad_tv2;
    private TextView home_ad_tv3;
    private TextView home_ad_tv4;
    private TextView home_ad_tv5;
    private TextView home_ad_tv6;
    private RelativeLayout home_hot_Rl1;
    private ImageView home_hot_iv1;
    private TextView home_hot_title_1;
    private TextView hot_name_1;
    private ImageView home_hot_iv2;
    private TextView home_hot_title_2;
    private TextView hot_name_2;
    private ImageView home_hot_iv3;
    private TextView home_hot_title_3;
    private TextView hot_name_3;
    private ImageView home_hot_iv4;
    private TextView home_hot_title_4;
    private TextView hot_name_4;
    private ImageView home_recomm_top_iv1;
    private ImageView home_recomm_top_iv2;
    private ListView home_recommend_lv;
    private ListView other_listView;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str= (String) msg.obj;
            Gson gson = new Gson();
            homebean = gson.fromJson(str, HomeBean.class);


            //轮播图
            initRoolViewPager(homebean);
//        //多彩生活
            initDuoCai(homebean);
//        //最强思路
            initZuiQiang(homebean);
//        //热门
            initReMen(homebean);
//        //小编
            initXiaoBian(homebean);
//        //大家
            initDaJia(homebean);
        }
    };
    private GridView gv;
    private Toolbar title_toolbar;

    //加载数据 并根据加载的结果返回相应的状态
    @Override
    public void onLoad() {
        showingPage.setOnShowinPageListener(new OnShowinPageListener() {
            @Override
            public void isShowPager(View view) {
                initData();
            }
        });
        initData();
    }

    //执行加执行加载数据的操作
    public void initData() {
        MyBaseDate myBaseDate = new MyBaseDate();
        myBaseDate.getData(Constants.shouye, Constants.shouye3, BaseData.NORMALTIME);
    }

    //创建成功的视图
    @Override
    public View createSuccessView() {
        View view = initView();
        return view;
    }

    private void initDaJia(HomeBean homebean) {
        List<HomeBean.DataBean.IndexothersBean> ib = homebean.getData().getIndexothers();
        CommonAdapter comm = new CommonAdapter<HomeBean.DataBean.IndexothersBean>(getActivity(), ib, R.layout.lv_item) {
            @Override
            public void convert(ViewHolder helper, HomeBean.DataBean.IndexothersBean item) {
                helper.setImageByUrl(R.id.home_recomm_iv_main, item.getCourse_pic());
                helper.setText(R.id.home_recomm_tv3, item.getCourse_name());
                helper.setText(R.id.home_recomm_tv4, item.getSchool_name());
                helper.setText(R.id.home_recomm_tv5, item.getCourse_paycount() + "人在学习");
            }

        };
        other_listView.setAdapter(comm);
    }

    private void initXiaoBian(HomeBean homebean) {
        List<HomeBean.DataBean.IndexrecommendBean.TopBean> tb = homebean.getData().getIndexrecommend().getTop();
        List<HomeBean.DataBean.IndexrecommendBean.ListviewBean> lb = homebean.getData().getIndexrecommend().getListview();
        ivlist3.add(home_recomm_top_iv1);
        ivlist3.add(home_recomm_top_iv2);
        for (int i = 0; i < 2; i++) {
            GLideUtils.loagNormalImg(tb.get(i).getCourse_pic(), ivlist3.get(i));
        }
        CommonAdapter commonA = new CommonAdapter<HomeBean.DataBean.IndexrecommendBean.ListviewBean>(getActivity(), lb, R.layout.lv_item) {
            @Override
            public void convert(ViewHolder helper, HomeBean.DataBean.IndexrecommendBean.ListviewBean item) {
                helper.setImageByUrl(R.id.home_recomm_iv_main, item.getCourse_pic());
                helper.setText(R.id.home_recomm_tv3, item.getCourse_name());
                helper.setText(R.id.home_recomm_tv4, item.getSchool_name());
                helper.setText(R.id.home_recomm_tv5, item.getCourse_paycount() + "人在学习");
            }
        };
        home_recommend_lv.setAdapter(commonA);
    }

    private void initReMen(HomeBean homebean) {
        List<HomeBean.DataBean.HotcourseBean> hb = homebean.getData().getHotcourse();
        ivlist2.add(home_hot_iv1);
        ivlist2.add(home_hot_iv2);
        ivlist2.add(home_hot_iv3);
        ivlist2.add(home_hot_iv4);

        tvlist2.add(home_hot_title_1);
        tvlist2.add(home_hot_title_2);
        tvlist2.add(home_hot_title_3);
        tvlist2.add(home_hot_title_4);
        tvlist3.add(hot_name_1);
        tvlist3.add(hot_name_2);
        tvlist3.add(hot_name_3);
        tvlist3.add(hot_name_4);
        for (int i = 0; i < 4; i++) {
            GLideUtils.loagNormalImg(hb.get(i).getImg(), ivlist2.get(i));
        }
        for (int i = 0; i < 4; i++) {
            tvlist3.get(i).setText(hb.get(i).getName());
            tvlist2.get(i).setText(hb.get(i).getTitle());
        }
    }

    //最强思路
    private void initZuiQiang(HomeBean homebean) {
        List<HomeBean.DataBean.AdlistBean> ad = homebean.getData().getAdlist();
        ivlist.add(home_ad_iv1);
        ivlist.add(home_ad_iv2);
        ivlist.add(home_ad_iv3);

        tvlist.add(home_ad_tv1);
        tvlist.add(home_ad_tv2);
        tvlist.add(home_ad_tv3);
        tvlist.add(home_ad_tv4);
        tvlist.add(home_ad_tv5);
        tvlist.add(home_ad_tv6);

        for (int i = 0; i < 3; i++) {
            GLideUtils.loagNormalImg(ad.get(i).getImg(), ivlist.get(i));
        }
        for (int i = 0; i < 3; i++) {
            if (i % 2 == 0) {
                tvlist.get(i).setText(ad.get(i / 2).getName());
            } else {
                tvlist.get(i).setText(ad.get(i / 2).getTitle());
            }
        }
    }

    //多彩生活
    private void initDuoCai(HomeBean homebean) {
        List<HomeBean.DataBean.HotcategoryBean> hb = homebean.getData().getHotcategory();
        ivlist4.add(home_more_iv_1);
        ivlist4.add(home_more_iv_2);
        ivlist4.add(home_more_iv_3);
        ivlist4.add(home_more_iv_4);
        ivlist4.add(home_more_iv_5);
        ivlist4.add(home_more_iv_6);

        tvlist4.add(home_more_tv_1);
        tvlist4.add(home_more_tv_2);
        tvlist4.add(home_more_tv_3);
        tvlist4.add(home_more_tv_4);
        tvlist4.add(home_more_tv_5);
        tvlist4.add(home_more_tv_6);
        for (int i = 0; i < 6; i++) {
            GLideUtils.loagNormalImg(hb.get(i).getImg(), ivlist4.get(i));
        }
        for (int i = 0; i < 6; i++) {
            tvlist4.get(i).setText(hb.get(i).getCname());
        }
    }

    //轮播图
    private void initRoolViewPager(HomeBean homebean) {
        adl = homebean.getData().getSlider();
        for (int i = 0; i < adl.size(); i++) {
            imgUrlList.add(adl.get(i).getImg());
        }
        initDots(adl);
        myViewPager.initData(imgUrlList, dotArray, dotList);
        myViewPager.startViewPager();
        myViewPager.setOnPageClickListener(new MyViewPager.OnPageClickListener() {
            @Override
            public void setOnPage(int position) {
                // Toast.makeText(getContext(),"aaaa",Toast.LENGTH_SHORT).show();
                //   TiaoZhuan.tiaoZhuan(getActivity(),adl.get(position).getAd_type_dynamic_data());
                //  TiaoZhuan.tiaoZhuan(getActivity(),adl.get(position).getAd_type_dynamic());
                Intent intent=new Intent(getActivity(),XiangQingActivity.class);
                //  intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
            }
        });
    }

    //小圆点
    private void initDots(List<HomeBean.DataBean.SliderBean> adl) {
        dotList.clear();
        dots_ll.removeAllViews();
        for (int i = 0; i < adl.size(); i++) {
            ImageView imageView = new ImageView(getActivity());
            if (i == 0) {
                imageView.setImageResource(dotArray[0]);
            } else {
                imageView.setImageResource(dotArray[1]);
            }
            dotList.add(imageView);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(10, 5, 10, 5);
            dots_ll.addView(imageView, params);
        }

    }

    private View initView() {
        View view = CommonUtil.inflate(R.layout.homefragment);
        //shangalaxiaal
        springView = (SpringView) view.findViewById(R.id.springView);
        //上下刷新
        springView = (SpringView) view.findViewById(R.id.springView);
        springView.setHeader(new DefaultHeader(getActivity()));
        springView.setType(SpringView.Type.FOLLOW);
        //对上下刷新设置上下文
        springView.setListener(this);
        //轮播
        //  top_news_viewpager=(LinearLayout)view.findViewById(R.id.top_news_viewpager);
        //viewpager第一
        myViewPager = (MyViewPager) view.findViewById(R.id.myRoolViewPager);
        //小圆点
        dots_ll = (LinearLayout) view.findViewById(R.id.dots_ll);
        //多彩
        //  gv = (GridView) view.findViewById(R.id.gv);

        home_more_1 = (LinearLayout) view.findViewById(R.id.home_more_1);
        home_more_iv_1 = (ImageView) view.findViewById(R.id.home_more_iv_1);
        home_more_iv_2 = (ImageView) view.findViewById(R.id.home_more_iv_2);
        home_more_iv_3 = (ImageView) view.findViewById(R.id.home_more_iv_3);
        home_more_iv_4 = (ImageView) view.findViewById(R.id.home_more_iv_4);
        home_more_iv_5 = (ImageView) view.findViewById(R.id.home_more_iv_5);
        home_more_iv_6 = (ImageView) view.findViewById(R.id.home_more_iv_6);

        home_more_tv_1 = (TextView) view.findViewById(R.id. home_more_tv_1);
        home_more_tv_2 = (TextView) view.findViewById(R.id. home_more_tv_2);
        home_more_tv_3 = (TextView) view.findViewById(R.id. home_more_tv_3);
        home_more_tv_4 = (TextView) view.findViewById(R.id. home_more_tv_4);
        home_more_tv_5 = (TextView) view.findViewById(R.id. home_more_tv_5);
        home_more_tv_6 = (TextView) view.findViewById(R.id. home_more_tv_6);


        //最强
        home_ad_rl = (RelativeLayout) view.findViewById(R.id.home_ad_rl);
        home_ad_iv1 = (ImageView) view.findViewById(R.id.home_ad_iv1);
        home_ad_tv2 = (TextView) view.findViewById(R.id.home_ad_tv2);
        home_ad_tv1 = (TextView) view.findViewById(R.id.home_ad_tv1);
        //跑步
        hoem_ad_ll1 = (LinearLayout) view.findViewById(R.id.hoem_ad_ll1);
        home_ad_tv3 = (TextView) view.findViewById(R.id.home_ad_tv3);
        home_ad_tv4 = (TextView) view.findViewById(R.id.home_ad_tv4);
        home_ad_iv2 = (ImageView) view.findViewById(R.id.home_ad_iv2);
        //思维
        hoem_ad_ll2 = (LinearLayout) view.findViewById(R.id.hoem_ad_ll2);
        home_ad_tv5 = (TextView) view.findViewById(R.id.home_ad_tv5);
        home_ad_tv6 = (TextView) view.findViewById(R.id.home_ad_tv6);
        home_ad_iv3 = (ImageView) view.findViewById(R.id.home_ad_iv3);
        //热门
        home_hot_Rl1 = (RelativeLayout) view.findViewById(R.id.home_hot_Rl1);
        home_hot_iv1 = (ImageView) view.findViewById(R.id.home_hot_iv1);
        home_hot_title_1 = (TextView) view.findViewById(R.id.home_hot_title_1);
        hot_name_1 = (TextView) view.findViewById(R.id.hot_name_1);

        home_hot_iv2 = (ImageView) view.findViewById(R.id.home_hot_iv2);
        home_hot_title_2 = (TextView) view.findViewById(R.id.home_hot_title_2);
        hot_name_2 = (TextView) view.findViewById(R.id.hot_name_2);

        home_hot_iv3 = (ImageView) view.findViewById(R.id.home_hot_iv3);
        home_hot_title_3 = (TextView) view.findViewById(R.id.home_hot_title_3);
        hot_name_3 = (TextView) view.findViewById(R.id.hot_name_3);

        home_hot_iv4 = (ImageView) view.findViewById(R.id.home_hot_iv4);
        home_hot_title_4 = (TextView) view.findViewById(R.id.home_hot_title_4);
        hot_name_4 = (TextView) view.findViewById(R.id.hot_name_4);
        //小编
        home_recomm_top_iv1 = (ImageView) view.findViewById(R.id.home_recomm_top_iv1);
        home_recomm_top_iv2 = (ImageView) view.findViewById(R.id.home_recomm_top_iv2);
        home_recommend_lv = (ListView) view.findViewById(R.id.home_recommend_lv);
        //大家

        other_listView = (ListView) view.findViewById(R.id.other_listView);
        return view;

    }

    @Override
    public void onRefresh() {
        springView.onFinishFreshAndLoad();
    }

    @Override
    public void onLoadmore() {

    }

    //设置标题栏
    @Override
    public void setTitleView(View view) {
        TextView textView1 = (TextView) view.findViewById(R.id.title_tv);
        textView1.setVisibility(View.VISIBLE);
        textView1.setTextColor(Color.WHITE);
        textView1.setTextSize(20);
        textView1.setText("每日学");
    }

    //初始化标题栏
    public void intiTitleView() {

    }

    public class MyBaseDate extends BaseData {
        //成功后显示成功状态
        @Override
        public void onSucesss(String data) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_SUCCESS);
                Message msg = Message.obtain();
                msg.obj = data;
                handler.sendMessage(msg);

                HomeFragment.this.data = data;
      // ToastUtil.show(getActivity(), data);
            }
        }

        //error后显示error状态
        @Override
        public void onError(Throwable t) {
            if (showingPage != null) {
                showingPage.showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
            }
        }
    }
}
