package yuhao.yiliyili.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import yuhao.yiliyili.R;

public class SplashActivity extends AppCompatActivity {
    private static final int DELAY_TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
    }

    private void init() {
        //创建一新的线程，在该线程中执行网络检查
        executedInBackground();
        //用来延时进入主界面
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SplashActivity.this.startActivity(
                        new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        }, DELAY_TIME);
    }

    private void executedInBackground() {
        isNetworkConnected();
    }

    private void isNetworkConnected() {
        //TODO 进行不同网络情况的判断，根据网络情况显示不同页面
        ConnectivityManager cm = (ConnectivityManager) SplashActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) { // connected to the internet
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
            }
        } else {
            // not connected to the internet
        }

    }
}
