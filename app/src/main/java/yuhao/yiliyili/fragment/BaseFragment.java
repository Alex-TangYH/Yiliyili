package yuhao.yiliyili.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yuhao.yiliyili.R;

/**
 * Fragment的Base类，定义一些公用的方法和接口，便于开发，且减少代码冗余
 * Created by Yuhao on 2016/5/24.
 */
public abstract class  BaseFragment extends Fragment {


    protected Activity mActivity;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        initData();
        super.onActivityCreated(savedInstanceState);
    }

    public abstract void initData();
    public abstract View initView();
}
