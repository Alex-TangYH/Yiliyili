package yuhao.yiliyili.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * 广告Banner的工具类，用于减少重复代码
 *
 * Created by Yuhao on 2016/6/12.
 */
public class AdBannerUtils {
    private boolean mIsUserTouched = false;
    private static final String ZHIHU_API = "http://news-at.zhihu.com/api/4/news/latest";
    public AdBannerUtils() {
    }

    public void setViewPagerOnTouchListener(ViewPager viewPager){
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE){
                    mIsUserTouched = true;
                }else if (action == MotionEvent.ACTION_UP){
                    mIsUserTouched = false;
                }
                return false;
            }
        });
    }


    public boolean initImageLoader(Activity mActivity){
        File cacheDir = StorageUtils.getOwnCacheDirectory(mActivity.getApplication(),"Banner/cache/image");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mActivity.getApplication())
                .memoryCache(new LruMemoryCache(2*1024*1024))
                .memoryCacheSize(2*1024*1024)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheSize(50*1024*1024)
                .imageDownloader(new BaseImageDownloader(mActivity.getApplication(),20*60*60,30*60*60))
                .diskCacheFileCount(100)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ImageLoader.getInstance().init(config);
        return true;
    }


}
