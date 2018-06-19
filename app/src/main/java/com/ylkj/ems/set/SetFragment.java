package com.ylkj.ems.set;

import android.os.Bundle;

import com.ylkj.ems.R;
import com.ylkj.ems.base.fragment.BaseFragment;

public class SetFragment extends BaseFragment{

    public static SetFragment newInstance(Bundle bundle) {
        SetFragment fragment = new SetFragment();
        //fragment保存参数，传入一个Bundle对象
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {

    }
}
