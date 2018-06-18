package com.ylkj.ems.base.mvp;

import android.os.Bundle;

/**
 * Created by Administrator on 2016/9/29.
 */

public interface InitView {

    int getLayoutId();

    void onCreateView(Bundle savedInstanceState);

    void initView();
}
