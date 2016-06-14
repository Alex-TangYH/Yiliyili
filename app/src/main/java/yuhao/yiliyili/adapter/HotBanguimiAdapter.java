package yuhao.yiliyili.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

import yuhao.yiliyili.R;
import yuhao.yiliyili.adapter.view_holder.HotBanguimiViewHolder;
import yuhao.yiliyili.bean.bangummi.RankVedioInfoBean;

/**
 * 热门番剧的item_cartview_banggumi的适配器类
 * Created by Yuhao on 2016/6/14.
 */
public class HotBanguimiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<RankVedioInfoBean> rankVedioInfoBeanList;
    private Context context;
    private Activity mActivity;

    //初始化私有变量，获取传入的对象集
    public HotBanguimiAdapter(Context context, Activity mActivity, List<RankVedioInfoBean> rankVedioInfoBeanList) {
        this.rankVedioInfoBeanList =rankVedioInfoBeanList;
        this.context = context;
        this.mActivity = mActivity;
    }

    //初始化控件
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_cartview_bangumi, parent,false);
        return new HotBanguimiViewHolder(view, context, mActivity);
    }

    //绑定持久类HotBanguimiViewHolder
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HotBanguimiViewHolder hotBanguimiViewHolder = (HotBanguimiViewHolder) holder;
        hotBanguimiViewHolder.loadData(rankVedioInfoBeanList.get(position));
    }

    //返回条目总数
    @Override
    public int getItemCount() {
        return rankVedioInfoBeanList.size();
    }

}
