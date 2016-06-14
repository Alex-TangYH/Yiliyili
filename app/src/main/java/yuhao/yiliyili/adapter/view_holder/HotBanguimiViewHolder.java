package yuhao.yiliyili.adapter.view_holder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.math.BigDecimal;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yuhao.yiliyili.R;
import yuhao.yiliyili.activity.VitamioVideoActivity;
import yuhao.yiliyili.bean.bangummi.RankVedioInfoBean;

/**
 * 热门番剧的item_cartview_banggumi的viewHolder
 * Created by Yuhao on 2016/6/15.
 */
public class HotBanguimiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @InjectView(R.id.imageview_item_banggumi)
    ImageView imageView;
    @InjectView(R.id.title_item_banggumi)
    TextView title;
    @InjectView(R.id.up_item_banggumi)
    TextView author;
    @InjectView(R.id.bofangcishu_item_banggumi)
    TextView bofangcishu;
    @InjectView(R.id.viewreview_item_banggumi)
    TextView viewreview;

    Context context;
    Activity mActivity;
    RankVedioInfoBean rankVedioInfoBean;


    public HotBanguimiViewHolder(View itemView, Context context, Activity mActivity) {
        super(itemView);
        this.context = context;
        this.mActivity = mActivity;

        ButterKnife.inject(this, itemView);
        itemView.setOnClickListener(this);
    }

    public void loadData(RankVedioInfoBean rankVedioInfoBean) {
        //设置左边图片
        this.rankVedioInfoBean = rankVedioInfoBean;
        BitmapUtils bitmapUtils = new BitmapUtils(mActivity);
        String imageURL = rankVedioInfoBean.getPic();
        bitmapUtils.display(imageView, imageURL);

        //设置文字
        title.setText(" " + rankVedioInfoBean.getTitle());
        author.setText(rankVedioInfoBean.getAuthor());
        BigDecimal bd = new BigDecimal(rankVedioInfoBean.getPlay());
        bofangcishu.setText(bd.toPlainString());
        bd = new BigDecimal(rankVedioInfoBean.getVideo_review());
        viewreview.setText(bd.toPlainString());
    }


    @Override
    public void onClick(View v) {
        //设置点击事件，当点击时跳转到播放视频的activity（VitamioVideoActivity）,将cart内的信息一并传过去，以便之后的数据获取
        Intent intent = new Intent(mActivity, VitamioVideoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("rankVedioInfoBean", rankVedioInfoBean);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
