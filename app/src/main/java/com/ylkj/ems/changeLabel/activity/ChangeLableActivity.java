package com.ylkj.ems.changeLabel.activity;

import android.os.Bundle;

import com.ylkj.ems.R;
import com.ylkj.ems.base.activity.BaseMvpActivity;
import com.ylkj.ems.changeLabel.contract.ChangeLableContract;
import com.ylkj.ems.changeLabel.presenter.ChangeLablePresenter;

public class ChangeLableActivity extends BaseMvpActivity<ChangeLableContract.IChangeLablePresenter> implements ChangeLableContract.IChangeLableView{
    @Override
    protected ChangeLableContract.IChangeLablePresenter createPresenter() {
        return new ChangeLablePresenter();
    }

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_change_label;
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
