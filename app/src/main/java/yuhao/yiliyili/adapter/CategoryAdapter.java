package yuhao.yiliyili.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yuhao.yiliyili.R;
import yuhao.yiliyili.bean.CategoryBean;

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
            return new FenquViewHolder(view, context);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            FenquViewHolder viewholder = (FenquViewHolder) holder;
            viewholder.loadData(categoryBeanList.get(position));
        }

        @Override
        public int getItemCount() {
            return categoryBeanList.size();
        }
}

class FenquViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @InjectView(R.id.item_category_icon)
    ImageView icon;
    @InjectView(R.id.item_category_tv)
    TextView text;
    Context context;


    public FenquViewHolder(View itemView, Context context2) {
        super(itemView);
        context = context2;
        ButterKnife.inject(this,itemView);
        itemView.setOnClickListener(this);
    }

    public void loadData(CategoryBean categoryBean) {
        icon.setImageResource(categoryBean.getIconsource());
        text.setText(categoryBean.getIconName());
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(context, text.getText(), Toast.LENGTH_SHORT).show();
    }
}
