package yuhao.yiliyili.activity;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import yuhao.yiliyili.R;
import yuhao.yiliyili.fragment.BaseFragment;
import yuhao.yiliyili.fragment.DiscoverFragment;
import yuhao.yiliyili.fragment.BangumiFragment;
import yuhao.yiliyili.fragment.SubscriptionsFragment;
import yuhao.yiliyili.fragment.LiveFragment;
import yuhao.yiliyili.fragment.CategoryFragment;
import yuhao.yiliyili.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private List<BaseFragment> homeFragmentsList;
    private ViewPager vp_home;
    private String[] homeTabsName;
    private TabLayout homeTabLayout;

    //抽屉控件相关对象
    private DrawerLayout homeDrawerLayout;
    private ActionBarDrawerToggle homeToggle;
    private Toolbar home_toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化ToolBar
        initToolBar();
        //初始化ViewPager
        initViewPager();
        initListener();
        //初始化抽屉
        initDrawerLayout();
    }


    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        home_toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        home_toolbar.setTitle("");
        setSupportActionBar(home_toolbar);
    }


    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        homeTabsName = getResources().getStringArray(R.array.home_tabs);

        homeTabLayout = (TabLayout) findViewById(R.id.home_tablayout);
        vp_home = (ViewPager) findViewById(R.id.vp_home);

        //初始化Fragement集合，其中各元素对应各页面
        homeFragmentsList = new ArrayList<BaseFragment>();
        homeFragmentsList.add(new LiveFragment());
        homeFragmentsList.add(new HomeFragment());
        homeFragmentsList.add(new BangumiFragment());
        homeFragmentsList.add(new CategoryFragment());
        homeFragmentsList.add(new SubscriptionsFragment());
        homeFragmentsList.add(new DiscoverFragment());

        vp_home.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        homeTabLayout.setupWithViewPager(vp_home);

        //手动让它加载一次viewpager初始化，因为viewpager是不会触发onPageSelected事件
        vp_home.setCurrentItem(0);
        vp_home.setCurrentItem(1);
        vp_home.setCurrentItem(2);
        vp_home.setCurrentItem(3);
        vp_home.setCurrentItem(4);
        vp_home.setCurrentItem(5);
    }

    /**
     * 初始化抽屉
     */
    private void initDrawerLayout() {
        //TODO 尝试理解
        homeDrawerLayout = (DrawerLayout) findViewById(R.id.home_drawerlayout);
        homeToggle = new ActionBarDrawerToggle(this, homeDrawerLayout, home_toolbar, R.string.open, R.string.close);
        homeDrawerLayout.addDrawerListener(homeToggle);
        homeToggle.syncState();
        home_toolbar.setNavigationIcon(R.drawable.ic_navigation_drawer);

        //与界面的抽屉绑定，并初始化条目监听器
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new navItemSelectedListener());
    }

    /**
     * 设置主页上方的ToolBar的三个按钮
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_top, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 设置主页上方的ToolBar的三个按钮的点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO 设置主页上方的ToolBar的三个按钮的点击事件
        switch (item.getItemId()) {
            case R.id.menu_home_top_game:
                Toast.makeText(this, R.string.game, Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_home_top_download:
                Toast.makeText(this, R.string.download, Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_home_top_search:
                Toast.makeText(this, R.string.search, Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * viewpager的适配器
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return homeFragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return homeFragmentsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return homeTabsName[position];
        }
    }

    /**
     * homeDrawerLayout的条目点击监听器
     */
    public class navItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // 确定点击的条目ID
            int id = item.getItemId();
            //TODO 将按钮与它们对应的Fragment连接
            switch (id) {
                case R.id.nav_home:
                    Toast.makeText(MainActivity.this, R.string.home, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_offline:
                    Toast.makeText(MainActivity.this, R.string.offline, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_favorites:
                    Toast.makeText(MainActivity.this, R.string.favorites, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_history:
                    Toast.makeText(MainActivity.this, R.string.history, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_following:
                    Toast.makeText(MainActivity.this, R.string.following, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_my_wallet:
                    Toast.makeText(MainActivity.this, R.string.my_wallet, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_theme:
                    Toast.makeText(MainActivity.this, R.string.theme, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_recommend_app:
                    Toast.makeText(MainActivity.this, R.string.recommend_app, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_setting_and_help:
                    Toast.makeText(MainActivity.this, R.string.setting_and_help, Toast.LENGTH_SHORT).show();
                    break;

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.home_drawerlayout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.home_drawerlayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //viewpager切换监听器
    private void initListener() {
        vp_home.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                BaseFragment fragment = homeFragmentsList.get(position);
                fragment.initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}

