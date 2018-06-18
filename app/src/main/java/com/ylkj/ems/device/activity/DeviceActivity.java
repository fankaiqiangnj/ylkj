package com.ylkj.ems.device.activity;

import android.os.Bundle;
import android.view.View;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.device.contract.DeviceContract;
import com.ylkj.ems.device.persenter.DevicePresenter;

import butterknife.OnClick;

/**
 *
 */
public class DeviceActivity extends BaseMvpActivity<DeviceContract.IDevicePresenter> implements DeviceContract.IDeviceView{
    @Override
    protected DeviceContract.IDevicePresenter createPresenter() {
        return new DevicePresenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_device;
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
    @OnClick({R.id.btn_add})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_add:
                go(AddDeviceActivity.class);

                break;
            default:
                break;
        }
    }

}
