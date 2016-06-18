package yuhao.yiliyili.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yuhao.yiliyili.R;

/**
 * 关注页面
 * Created by Yuhao on 2016/5/24.
 */
public class SubscriptionsFragment extends BaseFragment {


    public SubscriptionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subscriptions, container, false);
    }

    @Override
    public void initData() {

    }

    @Override
    public View initView() {
        return null;
    }

}
