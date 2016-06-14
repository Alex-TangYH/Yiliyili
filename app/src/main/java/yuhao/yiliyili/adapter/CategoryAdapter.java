package yuhao.yiliyili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import yuhao.yiliyili.R;
import yuhao.yiliyili.adapter.view_holder.CategoryViewHolder;
import yuhao.yiliyili.bean.category.CategoryBean;

/**
 * 分区fragment的适配器
 * Created by Yuhao on 2016/6/10.
 */
public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        List<CategoryBean> categoryBeanList;
        Context context;

        public CategoryAdapter(List<CategoryBean> categoryBeanList2, Context context2) {
            categoryBeanList = categoryBeanList2;
            context = context2;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.item_catagory, parent,false);
            return new CategoryViewHolder(view, context);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            CategoryViewHolder viewholder = (CategoryViewHolder) holder;
            viewholder.loadData(categoryBeanList.get(position));
        }

        @Override
        public int getItemCount() {
            return categoryBeanList.size();
        }
}

