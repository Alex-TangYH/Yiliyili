package yuhao.yiliyili.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;

import java.math.BigDecimal;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yuhao.yiliyili.R;
import yuhao.yiliyili.bean.RankVedioInfoBean;

/**
 * Created by Yuhao on 2016/6/14.
 */
public class HotBanguimiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<RankVedioInfoBean> rankVedioInfoBeanList;
    private Context context;
    private Activity mActivity;


    public HotBanguimiAdapter(Context context, Activity mActivity, List<RankVedioInfoBean> rankVedioInfoBeanList) {
        this.rankVedioInfoBeanList =rankVedioInfoBeanList;
        this.context = context;
        this.mActivity = mActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_cartview_bangumi, parent,false);
        return new HotBanguimiViewHolder(view, context, mActivity);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HotBanguimiViewHolder hotBanguimiViewHolder = (HotBanguimiViewHolder) holder;
        hotBanguimiViewHolder.loadData(rankVedioInfoBeanList.get(position));
    }

    @Override
    public int getItemCount() {
        return rankVedioInfoBeanList.size();
    }













    class HotBanguimiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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


        public HotBanguimiViewHolder(View itemView, Context context, Activity mActivity) {
            super(itemView);
            this.context = context;
            this.mActivity = mActivity;

            ButterKnife.inject(this,itemView);
            itemView.setOnClickListener(this);
        }

        public void loadData(RankVedioInfoBean rankVedioInfoBean) {
            //设置左边图片
            BitmapUtils bitmapUtils = new BitmapUtils(mActivity);
            String imageURL = rankVedioInfoBean.getPic();
            bitmapUtils.display(imageView, imageURL);

            //设置文字
            title.setText(" "+rankVedioInfoBean.getTitle());
            author.setText(rankVedioInfoBean.getAuthor());
            BigDecimal bd = new BigDecimal(rankVedioInfoBean.getPlay());
            bofangcishu.setText(bd.toPlainString());
            bd = new BigDecimal(rankVedioInfoBean.getVideo_review());
            viewreview.setText(bd.toPlainString());
        }


        @Override
        public void onClick(View v) {

        }
    }
}
