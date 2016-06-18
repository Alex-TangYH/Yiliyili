package yuhao.yiliyili.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yuhao.yiliyili.R;
import yuhao.yiliyili.adapter.CategoryAdapter;
import yuhao.yiliyili.bean.category.CategoryBean;

/**
 * TODO 需要将点击事件与新的Activity连接
 * 分类页面，目前已实现布局
 * Created by Yuhao on 2016/5/24.
 */
public class CategoryFragment extends BaseFragment {
    public Context context;
    private RecyclerView recyclerView;
    private String[] categoryArray;
    private int[] cateIconArray;
    private List<CategoryBean> categoryBeanList;

    public CategoryFragment() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = super.getContext();
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rec_category);
        initData();

        return view;
    }


    //初始化数据，填充RecyclerView
    @Override
    public void initData(){
        categoryArray = getResources().getStringArray(R.array.categoryName);
        //TODO 将这段做成数组放在XML文件中
        cateIconArray = new int[]{R.mipmap.ic_category_live, R.mipmap.ic_category_bangumi, R.mipmap.ic_category_animation,
                R.mipmap.ic_category_music, R.mipmap.ic_category_dance, R.mipmap.ic_category_game,
                R.mipmap.ic_category_technology, R.mipmap.ic_category_entertainment, R.mipmap.ic_category_kichiku, R.mipmap.ic_category_movie,
                R.mipmap.ic_category_drama, R.mipmap.ic_category_fashion, R.mipmap.ic_category_gamecenter};

        //将数据填入
        categoryBeanList = new ArrayList<>();
        for(int i = 0;i<categoryArray.length;i++){
            CategoryBean cateBean = new CategoryBean();
            cateBean.setIconsource(cateIconArray[i]);
            cateBean.setIconName(categoryArray[i]);
            categoryBeanList.add(cateBean);
        }

        recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        recyclerView.setAdapter(new CategoryAdapter(categoryBeanList, context));
    }

    @Override
    public View initView() {
        return null;
    }

}
