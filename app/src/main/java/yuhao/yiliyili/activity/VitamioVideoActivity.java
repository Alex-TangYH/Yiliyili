package yuhao.yiliyili.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.vov.vitamio.widget.VideoView;
import yuhao.yiliyili.R;
import yuhao.yiliyili.bean.bangummi.RankVedioInfoBean;
import yuhao.yiliyili.interfaces.SetBanguimiUI;
import yuhao.yiliyili.utils.MyHttpUtils;

public class VitamioVideoActivity extends AppCompatActivity {
    private MyHttpUtils myHttpUtils1;
    private MyHttpUtils myHttpUtils2;


    private String cid;
    private Uri uri;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitamio_video);

        videoView = (VideoView) findViewById(R.id.vva_vv);

        Intent intent=getIntent();
        RankVedioInfoBean rankVedioInfoBean = (RankVedioInfoBean) intent.getSerializableExtra("rankVedioInfoBean");
        //根据rankVedioInfoBean的aid获取cid
        //根据cid获取播放地址
        myHttpUtils2 = new MyHttpUtils(new SetBanguimiUI.SetVideoUI() {
            @Override
            public void doing(String url) {
                uri = Uri.parse(url);
                videoView.setVideoURI(uri);
            }
        });

        myHttpUtils1 = new MyHttpUtils(new SetBanguimiUI.GetVideoInfo() {
            @Override
            public void doing(String cid2) {
                cid = cid2;
                myHttpUtils2.getBangumi(cid);
            }
        });
        myHttpUtils1.getCid(rankVedioInfoBean.getAid());

        io.vov.vitamio.widget.MediaController controller = new io.vov.vitamio.widget.MediaController(this);
        videoView.setMediaController(controller);
        //全屏
//        videoView.setVideoLayout(videoView.VIDEO_LAYOUT_SCALE,0);
    }

    @Override
    protected void onResume() {
        Intent intent=getIntent();
        RankVedioInfoBean rankVedioInfoBean = (RankVedioInfoBean) intent.getSerializableExtra("rankVedioInfoBean");
        //根据rankVedioInfoBean的aid获取cid
        //根据cid获取播放地址
        myHttpUtils2 = new MyHttpUtils(new SetBanguimiUI.SetVideoUI() {
            @Override
            public void doing(String url) {
                uri = Uri.parse(url);
                videoView.setVideoURI(uri);
            }
        });

        myHttpUtils1 = new MyHttpUtils(new SetBanguimiUI.GetVideoInfo() {
            @Override
            public void doing(String cid2) {
                cid = cid2;
                Log.e("cid",cid2);
                myHttpUtils2.getBangumi(cid);
            }
        });
        myHttpUtils1.getCid(rankVedioInfoBean.getAid());

        io.vov.vitamio.widget.MediaController controller = new io.vov.vitamio.widget.MediaController(this);
        videoView.setMediaController(controller);

        super.onResume();
    }
}
