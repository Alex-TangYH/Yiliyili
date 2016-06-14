package yuhao.yiliyili.adapter.view_holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yuhao.yiliyili.R;
import yuhao.yiliyili.bean.category.CategoryBean;

/**
 * CategoryFragment中的item的持久类
 * Created by Yuhao on 2016/6/15.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @InjectView(R.id.item_category_icon)
    ImageView icon;
    @InjectView(R.id.item_category_tv)
    TextView text;
    Context context;

    public CategoryViewHolder(View itemView, Context context2) {
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
