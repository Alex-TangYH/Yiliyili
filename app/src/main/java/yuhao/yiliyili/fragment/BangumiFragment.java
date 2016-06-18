package yuhao.yiliyili.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import yuhao.yiliyili.R;
import yuhao.yiliyili.adapter.HotBanguimiAdapter;
import yuhao.yiliyili.bean.bangummi.RankVedioInfoBean;
import yuhao.yiliyili.interfaces.SetBanguimiUI;
import yuhao.yiliyili.bean.banner.NewsBean;
import yuhao.yiliyili.bean.banner.StoryBean;
import yuhao.yiliyili.utils.AdBannerUtils;
import yuhao.yiliyili.utils.MyHttpUtils;
import yuhao.yiliyili.utils.Utils;

/**
 * 番剧Fragment，包括顶部的Banner广告，以及最热番剧
 */
public class BangumiFragment extends BaseFragment {
    private static String  TAG = "BangumiFragment";
    private static final String ZHIHU_API = "http://news-at.zhihu.com/api/4/news/latest";
    protected Activity mActivity;
    private ViewPager mViewPager;
    private BannerAdapter bannerAdapter;
    private TextView mTitle;
    private ImageView[] mIndicator;
    private View mView;
    private RequestQueue mQueue;

    private RecyclerView recyclerView;

    private Gson gson;
    private NewsBean news;
    private Timer mTimer = new Timer();
    private AdBannerUtils adBannerUtils;
    private MyHttpUtils myHttpUtils;
    private List<RankVedioInfoBean> rankVedioInfoBeanList;

    private int mBannerPosition = 0;
    private final int FAKE_BANNER_SIZE = 100;
    private final int DEFAULT_BANNER_SIZE = 5;
    private boolean mIsUserTouched = false;


    public BangumiFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //第一个5000表示从调用schedule()方法到第一次执行mTimerTask的run()方法的时间间隔
        //第二个5000表示以后每隔5000毫秒执行一次mTimerTask的run()方法
        adBannerUtils = new AdBannerUtils();
        mTimer.schedule(mTimerTask,5000,5000);


        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_bangumi, container, false);
        mActivity = super.mActivity;
        initView();
        initEvent();



        return mView;
    }

    @Override
    public View initView() {
        //dot
        mIndicator = new ImageView[]{
                (ImageView) mView.findViewById(R.id.dot_indicator1),
                (ImageView) mView.findViewById(R.id.dot_indicator2),
                (ImageView) mView.findViewById(R.id.dot_indicator3),
                (ImageView) mView.findViewById(R.id.dot_indicator4),
                (ImageView) mView.findViewById(R.id.dot_indicator5),
        };
        //view
        mViewPager = (ViewPager) mView.findViewById(R.id.view_pager);
        mTitle = (TextView) mView.findViewById(R.id.title);
        //Gson
        gson = new Gson();
        //Touch
        adBannerUtils.setViewPagerOnTouchListener(mViewPager);

        rankVedioInfoBeanList = new ArrayList<RankVedioInfoBean>();
        myHttpUtils = new MyHttpUtils(new SetBanguimiUI.SetHotBanguimiUI() {
            @Override
            public void doing(RankVedioInfoBean rankVedioInfoBean) {
                rankVedioInfoBeanList.add(rankVedioInfoBean);
                // 初始化自定义的适配器
                HotBanguimiAdapter hotBanguimiAdapter = new HotBanguimiAdapter(mActivity, mActivity,rankVedioInfoBeanList);
                // 为mRecyclerView设置适配器
                recyclerView.setAdapter(hotBanguimiAdapter);
            }
        });
        myHttpUtils.getRankOfSort("13","",1,1);
        myHttpUtils.getRankOfSort("13","",1,2);
        myHttpUtils.getRankOfSort("13","",1,3);
        myHttpUtils.getRankOfSort("13","",1,4);
        myHttpUtils.getRankOfSort("13","",1,5);

        // 拿到RecyclerView
        recyclerView = (RecyclerView) mView.findViewById(R.id.rec_hotBangumi);
        // 设置LinearLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        // 设置ItemAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        recyclerView.setHasFixedSize(true);
//        //以下代码已写入callBack中，保证数据异步
//        // 初始化自定义的适配器
//        HotBanguimiAdapter hotBanguimiAdapter = new HotBanguimiAdapter(mActivity, mActivity,rankVedioInfoBeanList);
//        // 为mRecyclerView设置适配器
//        recyclerView.setAdapter(hotBanguimiAdapter);
        //TODO 增加第一第二个页面的展示


        return null;
    }

    private void initEvent() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mBannerPosition = position;
                setIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }

    private void setIndicator(int position) {
        position %= DEFAULT_BANNER_SIZE;
        //遍历mIndicator重置src为normal
        for (ImageView indicator : mIndicator){
            indicator.setImageResource(R.drawable.dot_normal);
        }
        mIndicator[position].setImageResource(R.drawable.dot_focused);
        mTitle.setText(news.getTop_stories().get(position).getTitle());
    }



    @Override
    public void initData() {
        adBannerUtils.initImageLoader(mActivity);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, ZHIHU_API,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dealWithResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
        //给stringRequest设置Tag，便于在Activity销毁时cancel掉网络请求
        stringRequest.setTag(TAG);
        if(mQueue == null){
            mQueue = Volley.newRequestQueue(mActivity.getApplication());
        }
        mQueue.add(stringRequest);
    }

    private void dealWithResponse(String response) {
        news = gson.fromJson(response,NewsBean.class);
        bannerAdapter = new BannerAdapter(mActivity.getApplicationContext(),news.getTop_stories());
        mViewPager.setAdapter(bannerAdapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //cancel掉mTimer和网络请求
        mTimer.cancel();
        mQueue.cancelAll(TAG);
    }

    private TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            if (!mIsUserTouched){
                mBannerPosition = (mBannerPosition + 1) % FAKE_BANNER_SIZE;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (mBannerPosition == FAKE_BANNER_SIZE - 1){
                            mViewPager.setCurrentItem(DEFAULT_BANNER_SIZE - 1,false);
                        }else {
                            mViewPager.setCurrentItem(mBannerPosition);
                        }
                    }
                });
            }
        }
    };

    private class BannerAdapter extends PagerAdapter{
        private Context context;
        private List<StoryBean> newsList;

        public BannerAdapter(Context context, List<StoryBean> newsList) {
            this.context = context;
            this.newsList = newsList;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %= DEFAULT_BANNER_SIZE;

            View view = LayoutInflater.from(context).inflate(R.layout.item, container, false);
            ImageView image = (ImageView) view.findViewById(R.id.image);

            Utils.loadImage(newsList.get(position).getImage(), image);
            final int pos = position;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,pos+"-->"+newsList.get(pos).getTitle(),Toast.LENGTH_SHORT).show();
                }
            });
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return FAKE_BANNER_SIZE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void finishUpdate(ViewGroup container) {
            //这个有点懵逼..
            int position = mViewPager.getCurrentItem();
            if (position == 0){
                position = DEFAULT_BANNER_SIZE;
                mViewPager.setCurrentItem(position,false);
            }else if (position == FAKE_BANNER_SIZE - 1){
                position = DEFAULT_BANNER_SIZE - 1;
                mViewPager.setCurrentItem(position,false);
            }
        }
    }
}
