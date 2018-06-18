package com.ylkj.ems.device.activity;

import android.os.Bundle;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.device.contract.AddDeviceContract;
import com.ylkj.ems.device.persenter.AddDevicePresenter;

public class AddDeviceActivity extends BaseMvpActivity<AddDeviceContract.IAddDevicePresenter> implements AddDeviceContract.IAddDeviceView{
    @Override
    protected AddDeviceContract.IAddDevicePresenter createPresenter() {
        return new AddDevicePresenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_add_device;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return true;
    }

    @Override
    protected boolean isCustomPendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getCustomPendingTransitionType() {
        return TransitionMode.FADE;
    }

    @Override
    protected void initViewsAndEvents() {

    }
}
